package com.josiahebhomenye.algorithm.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuickSort<T extends Comparable<T>> extends AbstractSorter<T> implements Sorter<T> {
	
	private PivotStrategy<T> pivotStrategy;
	
	public QuickSort(PivotStrategy<T> pivotStrategy){
		this.pivotStrategy = pivotStrategy;
	}

	@Override
	public List<T> sort(List<T> list, Comparator<T> comparator) {
		if(list.size() <= 1){
			return list;
		}
		
		T pivot = pivotStrategy.getPivot(list);
		System.out.println("pivot" + pivot);
		List<T> left = new ArrayList<T>();
		List<T> right = new ArrayList<T>();
		
		for(int i = 0; i < list.size(); i++){
			if(compare(pivot, i, list, comparator)){
				left.add(list.get(i));
			}else{
				right.add(list.get(i));
			}
		}
		return join(sort(left, comparator), pivot, sort(right, comparator));
	}

	private List<T> join(List<T> left, T pivot, List<T> right) {
		List<T> result = new ArrayList<T>();
		result.addAll(left);
		result.add(pivot);
		result.addAll(right);
		return result;
	}

	private boolean compare(T pivot, int i, List<T> list, Comparator<T> comparator) {
		if(comparator != null){
			return comparator.compare(pivot, list.get(i)) >= 0;
		}
		return pivot.compareTo(list.get(i)) >= 0;
	}
	


}
