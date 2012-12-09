package com.josiahebhomenye.algorithm.sorting;

import com.josiahebhomenye.algorithm.sort.MergeSort;
import com.josiahebhomenye.algorithm.sort.Sorter;

public class MergeSortTest extends SortTest {

	@Override
	protected Sorter<Integer> createSorter() {
		return new MergeSort<Integer>();
	}

}
