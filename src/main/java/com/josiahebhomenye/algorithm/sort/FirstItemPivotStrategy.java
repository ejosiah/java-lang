package com.josiahebhomenye.algorithm.sort;

import java.util.List;

public class FirstItemPivotStrategy<T extends Comparable<T>> implements PivotStrategy<T>{

	@Override
	public T getPivot(List<T> list) {
		return list.remove(0);
	}


}
