package com.josiahebhomenye.algorithm.datastructure;

import java.util.*;

public class BucketingHashtable<T> implements Hashtable<T> {
	private final float _loadFactor;
	private List<T>[] buckets;
	private int _size;

	@SuppressWarnings("unchecked")
	public BucketingHashtable(int initialCapacity, float loadFactor) {
		assert initialCapacity > 0 : "initialCapacity can’t be < 1";
		assert loadFactor > 0 : "loadFactor can’t be <= 0";
		_loadFactor = loadFactor;
		buckets = (List<T>[])new LinkedList[initialCapacity];
	}

	public void add(T value) {
		List<T> bucket = bucketFor(value);
		if (!bucket.contains(value)) {
			bucket.add(value);
			++_size;
			maintainLoad();
		}
	}

	public boolean contains(T value) {
		List<T> bucket = buckets[bucketIndexFor(value)];
		return bucket != null && bucket.contains(value);
	}

	public int size() {
		return _size;
	}

	private List<T> bucketFor(T value) {
		int bucketIndex = bucketIndexFor(value);
		List<T> bucket = buckets[bucketIndex];
		if (bucket == null) {
			bucket = new LinkedList<T>();
			buckets[bucketIndex] = bucket;
		}
		return bucket;
	}

	private int bucketIndexFor(Object value) {
		assert value != null : "value can’t be null";
		return Math.abs(value.hashCode() % buckets.length);
	}

	private void maintainLoad() {
		if (loadFactorExceeded()) {
			resize();
		}
	}

	private boolean loadFactorExceeded() {
		return size() > buckets.length * _loadFactor;
	}

	private void resize() {
		BucketingHashtable<T> copy = new BucketingHashtable<T>(buckets.length * 2,
				_loadFactor);
		for (int i = 0; i < buckets.length; ++i) {
			if (buckets[i] != null) {
				copy.addAll(buckets[i]);
			}
		}
		buckets = copy.buckets;
	}

	private void addAll(Iterable<T> values) {
		assert values != null : "values can’t be null";
		for(T value : values){
			add(value);
		}
	}
}