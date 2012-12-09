package com.josiahebhomenye.algorithm.sort;

import java.util.Comparator;
import java.util.List;

public interface Comparer<T extends Comparable<T>> {
	
	public boolean compare(int firstIndex, int secondIndex, List<T> list, Comparator<T> comparator);

}
