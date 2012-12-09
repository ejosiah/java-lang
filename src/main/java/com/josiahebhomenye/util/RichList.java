package com.josiahebhomenye.util;

import java.util.ArrayList;
import java.util.List;

import com.josiahebhomenye.Closure;
import com.josiahebhomenye.Visitor;
import com.josiahebhomenye.algorithm.sort.InsertionSort;
import com.josiahebhomenye.algorithm.sort.QuickSort2;
import com.josiahebhomenye.algorithm.sort.Sorter;
import com.josiahebhomenye.function.Tuple2;

import lombok.Delegate;

@SuppressWarnings("all")
public class RichList<E>{
	
	private static final AsendingOrder ASENDING_ORDER = new AsendingOrder();
	private static final Smaller SMALLER = new Smaller();
	private static final Bigger BIGGER = new Bigger();
	private static final Sorter QUICK_SORT = new QuickSort2();
	private static final Sorter INSERTION_SORT = new InsertionSort();
	
	@Delegate(types=List.class)
	private final List list;
	
	private RichList(List<E> list){
		this.list = list;
	}
	
	public static <E> RichList<E> enrich(final List<E> list){
		return new RichList<E>(list);
	}
	
	public E fold(final E initialValue, final Closure<Tuple2<E, E>, E> callable){
		final List<E> list = copyList();
		
		E result = initialValue == null ? list.remove(0) : initialValue;
		while(!list.isEmpty()){
			result = callable.call(new Tuple2<E, E>(result, list.remove(0)));
		}
		return result;
	}
	
	public E fold(final Closure<Tuple2<E, E>, E> callable){
		return fold(null, callable);
	}
	
	public void each(final Visitor<E> visitor){
		final List<E> list = (List<E>)this.list;
		for(E elem : list){
			visitor.visit(elem);
		}
	}
	
	public List<E> apply(final Closure<List<E>, List<E>> closure){
		final List<E> list = copyList();
		return closure.call(list);
	}
	
	public List<E> findAll(final Closure<E, Boolean> closure){
		final List<E> list = copyList();
		final List<E> result = newList();
		
		for(E elm : list){
			if(closure.call(elm)){
				result.add(elm);
			}
		}
		
		return result;
	}
	
	public List<E> collect(final Closure<E, E> closure){
		final List<E> list = copyList();
		final List<E> result = newList();
		
		for(E elm : list){
			result.add(closure.call(elm));
		}
		
		return result;
	}
	
	public E min(){
		elementIsComparable();
		return fold(SMALLER);
		
	}
	
	public E max(){
		elementIsComparable();
		return fold(BIGGER);
		
	}
	
	public List<E> sort(){
		elementIsComparable();
		return sort(ASENDING_ORDER);	
	}
	
	public List<E> sort(Closure<Tuple2<E, E>, Boolean> comparator){
		elementIsComparable();
		final List<E> list = copyList();
		if(list.size() < 7){
			return INSERTION_SORT .sort(list, new ComparatorAdaptor(comparator));
		}
		return QUICK_SORT.sort(list, new ComparatorAdaptor(comparator));
	}
	
	private void elementIsComparable(){
		if(!(list.get(0) instanceof Comparable)){
			throw new UnsupportedOperationException("Element type is not an instance of Comparable");
		}
	}
	
	public List<E> getDelegate(){
		return list;
	}
	
	private List<E> copyList(){
		return createList(true);
	}
	
	private List<E> newList(){
		return createList(false);
	}
	
	private List<E> createList(boolean copy){
		List<E> list = null;
		try {
			list = (List<E>) this.list.getClass().newInstance();
		} catch (Exception e) {
			list = new ArrayList<E>();
		}
		if(copy){
			list.addAll(this.list);
		}
		return list;
	}

}
