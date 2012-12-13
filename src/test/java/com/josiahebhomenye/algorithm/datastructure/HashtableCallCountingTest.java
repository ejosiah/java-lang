package com.josiahebhomenye.algorithm.datastructure;

import junit.framework.TestCase;

public class HashtableCallCountingTest extends TestCase {
	private static final int TEST_SIZE = 1000;
	private static final int INITIAL_CAPACITY = 17;
	private int _counter;
	private Hashtable<Value> hashtable;

	public void testLinearProbingWithResizing() {
		hashtable = new LinearProbingHashtable<Value>(INITIAL_CAPACITY);
		runAll();
	}

	public void testLinearProbingNoResizing() {
		hashtable = new LinearProbingHashtable<Value>(TEST_SIZE);
		runAll();
	}

	public void testBucketsLoadFactor100Percent() {
		hashtable = new BucketingHashtable<Value>(INITIAL_CAPACITY, 1.0f);
		runAll();
	}

	public void testBucketsLoadFactor75Percent() {
		hashtable = new BucketingHashtable<Value>(INITIAL_CAPACITY, 0.75f);
		runAll();
	}

	public void testBuckets50Percent() {
		hashtable = new BucketingHashtable<Value>(INITIAL_CAPACITY, 0.50f);
		runAll();
	}

	public void testBuckets25Percent() {
		hashtable = new BucketingHashtable<Value>(INITIAL_CAPACITY, 0.25f);
		runAll();
	}

	public void testBuckets150Percent() {
		hashtable = new BucketingHashtable<Value>(INITIAL_CAPACITY, 1.50f);
		runAll();
	}

	public void testBuckets200Percent() {
		hashtable = new BucketingHashtable<Value>(INITIAL_CAPACITY, 2.0f);
		runAll();
	}

	private void runAll() {
		runAdd();
		runContains();
	}

	private void runAdd() {
		_counter = 0;
		for (int i = 0; i < TEST_SIZE; ++i) {
			hashtable.add(new Value(i));
		}
		reportCalls("add");
	}

	private void runContains() {
		_counter = 0;
		for (int i = 0; i < TEST_SIZE; ++i) {
			hashtable.contains(new Value(i));
		}
		reportCalls("contains");
	}

	private void reportCalls(String method) {
		System.out.println(getName() + "(" + method + "): " + _counter
				+ " calls");
	}

	private final class Value {
		private final String _value;

		public Value(int value) {
			_value = String.valueOf(Math.random() * TEST_SIZE);
		}

		public int hashCode() {
			return _value.hashCode();
		}

		public boolean equals(Object object) {
			++_counter;
			return object != null && _value.equals(((Value) object)._value);
		}
	}
}