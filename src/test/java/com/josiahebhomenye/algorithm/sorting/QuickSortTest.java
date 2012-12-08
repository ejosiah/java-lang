package com.josiahebhomenye.algorithm.sorting;

import java.util.List;

import com.josiahebhomenye.algorithm.sort.PivotStrategy;
import com.josiahebhomenye.algorithm.sort.QuickSort;
import com.josiahebhomenye.algorithm.sort.Sorter;

public class QuickSortTest extends SortTest {

	@Override
	protected Sorter<Integer> createSorter() {
		return new QuickSort<Integer>(new PivotStrategy<Integer>() {

			@Override
			public Integer getPivot(List<Integer> list) {
				return list.remove(0);
			}
		});
	}

}
