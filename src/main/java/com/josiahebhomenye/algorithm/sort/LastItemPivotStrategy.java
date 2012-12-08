package com.josiahebhomenye.algorithm.sort;

import java.util.List;

public class LastItemPivotStrategy <T extends Comparable<T>> implements PivotStrategy<T>{

	@Override
	public T getPivot(List<T> list) {
		int size = list.size();
		return list.remove(size-1);
	}

}
