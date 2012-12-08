package com.josiahebhomenye.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import com.josiahebhomenye.Closure;
import com.josiahebhomenye.Visitor;
import com.josiahebhomenye.function.Tuple2;

import lombok.Delegate;

@SuppressWarnings("all")
public class RichList<E>{
	
	@Delegate(types=List.class)
	private final List list;
	
	private RichList(List<E> list){
		this.list = list;
	}
	
	public static <E> RichList<E> enrich(List<E> list){
		return new RichList<E>(list);
	}
	
	public E fold(final E initialValue, final Closure<Tuple2<E, E>, E> callable){
		final List<E> list = new ArrayList<E>();
		list.addAll(this.list);
		
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
	
	public List<E> use(final Closure<List<E>, List<E>> closure){
		final List<E> list = new ArrayList<E>(this.list);
		return closure.call(list);
	}
	
	public List<E> collect(final Closure<E, Boolean> closure){
		final List<E> list = new ArrayList<E>(this.list);
		final List<E> result = new ArrayList<E>();
		
		for(E elm : list){
			if(closure.call(elm)){
				result.add(elm);
			}
		}
		
		return result;
	}
	
	public List<E> getDelegate(){
		return list;
	}
}
