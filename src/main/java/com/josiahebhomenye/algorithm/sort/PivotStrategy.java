package com.josiahebhomenye.algorithm.sort;

import java.util.List;

public interface PivotStrategy<T extends Comparable<T>> {
	
	T getPivot(List<T> list);

}
