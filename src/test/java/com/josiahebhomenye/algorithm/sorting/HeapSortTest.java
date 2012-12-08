package com.josiahebhomenye.algorithm.sorting;

import com.josiahebhomenye.algorithm.sort.HeapSort;
import com.josiahebhomenye.algorithm.sort.Sorter;

public class HeapSortTest extends SortTest {

	@Override
	protected Sorter<Integer> createSorter() {
		return new HeapSort<Integer>();
	}

}
