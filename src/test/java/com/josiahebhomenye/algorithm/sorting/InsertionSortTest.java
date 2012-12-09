package com.josiahebhomenye.algorithm.sorting;

import com.josiahebhomenye.algorithm.sort.InsertionSort;
import com.josiahebhomenye.algorithm.sort.Sorter;

public class InsertionSortTest extends SortTest {

	@Override
	protected Sorter<Integer> createSorter() {
		return new InsertionSort<Integer>();
	}

}
