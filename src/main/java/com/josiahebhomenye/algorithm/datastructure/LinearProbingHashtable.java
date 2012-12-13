package com.josiahebhomenye.algorithm.datastructure;

import java.lang.reflect.Array;

public class LinearProbingHashtable<T> implements Hashtable<T> {
	private T[] values;
	private int size;

	@SuppressWarnings("unchecked")
	public LinearProbingHashtable(int capacity) {
		values = (T[]) new Object[capacity];
	}

	@Override
	public void add(T value) {
		ensureCapacityForOneMore();

		int index = indexFor(value);

		if (values[index] == null) {
			values[index] = value;
			++size;
		}

	}

	private int indexFor(T value) {
		int start = startingIndexFor(value);
		int index = indexFor(value, start, values.length);
		if (index == -1) {
			index = indexFor(value, 0, start);

		}
		return index;
	}

	private int indexFor(T value, int start, int end) {
		for (int i = start; i < end; ++i) {
			if (values[i] == null || value.equals(values[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	private int indexOf(T value) {
		int start = startingIndexFor(value);
		int index = indexOf(value, start, values.length);
		if (index == -1) {
			index = indexOf(value, 0, start);
		}
		return index;
	}

	private int indexOf(Object value, int start, int end) {
		for (int i = start; i < end; ++i) {
			if (value.equals(values[i])) {
				return i;
			}
		}
		return -1;
	}

	private int startingIndexFor(T value) {
		return Math.abs(value.hashCode() % values.length);
	}

	private void ensureCapacityForOneMore() {
		if (size() == values.length) {
			resize();
		}
	}

	private void resize() {
		LinearProbingHashtable<T> copy = new LinearProbingHashtable<T>(
				values.length * 2);
		for (int i = 0; i < values.length; ++i) {
			if (values[i] != null) {
				copy.add(values[i]);
			}
		}
		values = copy.values;
	}

}
