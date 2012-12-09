package com.josiahebhomenye.algorithm.sorting;

import com.josiahebhomenye.algorithm.sort.BubbleSort;
import com.josiahebhomenye.algorithm.sort.Sorter;

public class BubbleSortTest extends SortTest {

	@Override
	protected Sorter<Integer> createSorter() {
		return new BubbleSort<Integer>();
	}

}
