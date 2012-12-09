package com.josiahebhomenye.algorithm.sorting;

import org.junit.Ignore;

import com.josiahebhomenye.algorithm.sort.SelectionSort;
import com.josiahebhomenye.algorithm.sort.Sorter;

@Ignore
public class SelectionSortTest extends SortTest {

	@Override
	protected Sorter<Integer> createSorter() {
		return new SelectionSort<Integer>();
	}

}
