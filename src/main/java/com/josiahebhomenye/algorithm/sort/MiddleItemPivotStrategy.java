package com.josiahebhomenye.algorithm.sort;

import java.util.List;

public class MiddleItemPivotStrategy<T extends Comparable<T>> implements PivotStrategy<T> {

	@Override
	public T getPivot(List<T> list) {
		int middle = list.size()/2;
		return list.remove(middle);
	}

}
