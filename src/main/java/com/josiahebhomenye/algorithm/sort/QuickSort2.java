package com.josiahebhomenye.algorithm.sort;

import java.util.Comparator;
import java.util.List;

public class QuickSort2<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public List<T> sort(List<T> list) {
		return sort(list, null);
	}
	
	@Override
	public List<T> sort(List<T> list, Comparator<T> comparator) {
		if(list.size() > 1){
			//int pivotIndex = list.size()/2;
			int pivotIndex = 0;
			System.out.println(list + " p: " + pivotIndex);
			pivotIndex = pattition(0, list.size() - 1, pivotIndex, list, comparator);
			System.out.println( " New p: " + pivotIndex);
			sort(split(0, pivotIndex, list), comparator);
			sort(split(pivotIndex, list.size(), list), comparator);
		}
		return list;
	}
	
	private int pattition(int left, int right, int pivotIndex, List<T> list, Comparator<T> comparator){
		swap(pivotIndex, right, list);
		int sortIndex = left;
		
		for(int i = left; i < right; i++){
			if(compare(i, right, list, comparator)){
				swap(i, sortIndex++, list);
			}
		}
		swap(sortIndex, right, list);
		
		return sortIndex;
	}
	
	private List<T> split(int from, int to, List<T> list){
		if(list.size() == to && from == 0){
			return list.subList(++from, to);
		}
		return list.subList(from, to);
	}
	
	private boolean compare(int i, int pivotIndex, List<T> list,
			Comparator<T> comparator) {
		if(comparator != null){
			return comparator.compare(list.get(i), list.get(pivotIndex)) <= 0;
		}
		return list.get(i).compareTo(list.get(pivotIndex)) <= 0;
	}

	private void swap(int i, int j, List<T> list){
		list.set(j, list.set(i, list.get(j)));
	}


}
