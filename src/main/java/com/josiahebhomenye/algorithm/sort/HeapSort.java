package com.josiahebhomenye.algorithm.sort;

import java.util.Comparator;
import java.util.List;

public class HeapSort<T extends Comparable<T>> extends AbstractSorter<T> {
	
	private Comparator<T> comparator;
	
	@Override
	public List<T> sort(List<T> list, Comparator<T> comparator) {
		this.comparator = comparator;
		list = buildHeap(list);
		for(int i = list.size() - 1; i > 0; i--){
			swap(0, i, list);
			heapify(list, 0, i);
		}
		return list;
	}


	private List<T> buildHeap(List<T> list) {
		for(int i = (list.size()/2) - 1; i >= 0; i--){
			heapify(list, i, list.size());
		}
		return list;
	}
	
	private void swap(int i, int j, List<T> list) {
		T temp = list.get(j);
		list.set(j, list.get(i));
		list.set(i, temp);
		
	}
	
	private void heapify(List<T> list, int i, int max) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = 0;
		if(compare(left, max,i, list)){
			largest = left;
		}else {
			largest = i;
		}
		if(compare(right, max, largest, list)){
			largest = right;
		}
		if(largest !=  i){
			swap(i, largest, list);
			heapify(list, largest, max);
		}
		
	}

	// TODO check why variable assignment failing
	private boolean compare(int index, int max, int i, List<T> list) {
		if(comparator != null){
			return (index < max) && comparator.compare(list.get(index), list.get(i)) > 0;
		}
		return (index < max) && list.get(index).compareTo(list.get(i) ) > 0;
	}

}
