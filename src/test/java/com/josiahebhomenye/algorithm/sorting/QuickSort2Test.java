package com.josiahebhomenye.algorithm.sorting;

import com.josiahebhomenye.algorithm.sort.QuickSort2;
import com.josiahebhomenye.algorithm.sort.Sorter;

public class QuickSort2Test extends SortTest {

	@Override
	protected Sorter<Integer> createSorter() {
		return new QuickSort2<Integer>();
	}

}
