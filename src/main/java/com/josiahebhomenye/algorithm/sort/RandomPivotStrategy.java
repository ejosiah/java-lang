package com.josiahebhomenye.algorithm.sort;

import java.util.List;

public class RandomPivotStrategy<T extends Comparable<T>> implements PivotStrategy<T> {

	@Override
	public T getPivot(List<T> list) {
		int pivotIndex = (int) (Math.random() * list.size());
		return list.remove(pivotIndex);
	}

}
