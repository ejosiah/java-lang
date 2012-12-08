package com.josiahebhomenye.algorithm.sort;

import java.util.List;

public abstract class  AbstractSorter<T extends Comparable<T>> implements Sorter<T> {

	public AbstractSorter() {
		super();
	}
	
	@Override
	public List<T> sort(List<T> list) {

		return sort(list, null);
	}
}