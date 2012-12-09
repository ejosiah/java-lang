package com.josiahebhomenye.algorithm.sort;

import java.util.Comparator;
import java.util.List;

public class InsertionSort<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public List<T> sort(List<T> list) {
		return sort(list, null);
	}

	@Override
	public List<T> sort(List<T> list, Comparator<T> comparator) {
		for(int i = 1; i < list.size(); i++){
			T currentItem = list.remove(i);
			int j = i - 1;
			while( j > -1 && compare(currentItem, j, list, comparator)){
				//list.set(j+1, list.get(j));
				j--;
			}
			list.add(j+1, currentItem);
		}
		return list;
	}

	private boolean compare(T currentItem, int j, List<T> list, Comparator<T> comparator) {
		if(comparator != null){
			return comparator.compare(list.get(j), currentItem) >= 0;
		}
		return list.get(j).compareTo(currentItem) >= 0;
	}

}
