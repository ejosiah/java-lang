package com.josiahebhomenye.algorithm.sort;

import java.util.Comparator;
import java.util.List;


public class BubbleSort<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public List<T> sort(List<T> list) {
		return sort(list, null);
	}

	@Override
	public List<T> sort(List<T> list, Comparator<T> comparator) {
		for(int i = 0, size = list.size(); i < size; i++){
			for(int j = i+1; j < list.size(); j++){
				if(compare(i, j, list, comparator)){
					swap(i, j, list);
				}
			}
		}
		return list;
	}

	private void swap(int i, int j, List<T> list) {
		T temp = list.get(j);
		list.set(j, list.get(i));
		list.set(i, temp);
		
	}

	private boolean compare(int i, int j, List<T> list, Comparator<T> comparator) {
		if(comparator != null){
			return comparator.compare(list.get(i), list.get(j)) >= 0;
		}
		return list.get(i).compareTo(list.get(j)) >= 0;
	}

}
