package com.josiahebhomenye.algorithm.sort;

import java.util.Comparator;
import java.util.List;

public interface Sorter<T extends Comparable<T>> {
	
	List<T> sort(List<T> list);
	
	List<T> sort(List<T> list, Comparator<T> comparator);

}
