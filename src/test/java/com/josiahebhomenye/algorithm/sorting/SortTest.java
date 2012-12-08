package com.josiahebhomenye.algorithm.sorting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.josiahebhomenye.algorithm.sort.Sorter;

public abstract class SortTest {

	@Test
	public void testSortListOfT() {
		List<Integer> array = array();
		List<Integer> expected = expected();

		Sorter<Integer> sorter = createSorter();
		List<Integer> actual = sorter.sort(array);
		assertEquals(expected, actual);
	}

	@Test 
	public void testSortListOfTComparatorOfT() {
		List<Integer> array = array();
		List<Integer> expected = expected();
		List<Integer> expectedR = expectedR();

		Sorter<Integer> sorter = createSorter();
		List<Integer> actual = sorter.sort(array, new ReverseComparator());
		assertNotSame(expected, actual);
		assertEquals(expectedR, actual);
	}

	protected abstract Sorter<Integer> createSorter();

	private class ReverseComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer one, Integer two) {
			return two.compareTo(one);
		}

	}

	private static List<Integer> array() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(15);
		list.add(2);
		list.add(5);
		list.add(8);
		list.add(6);
		list.add(10);
		list.add(7);
		list.add(2);
		list.add(4);
		list.add(1);
		list.add(3);
		list.add(9);

		return list;
	}

	private static List<Integer> expected() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(15);

		return list;
	}

	private static List<Integer> expectedR() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(15);
		list.add(10);
		list.add(9);
		list.add(8);
		list.add(7);
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(2);
		list.add(1);

		return list;
	}

}
