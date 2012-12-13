package com.josiahebhomenye.algorithm.datastructure;

public class LinearProbingHashtableTest extends AbstractHashtableTestCase {
	protected Hashtable<String> createTable(int capacity) {
		return new LinearProbingHashtable<String>(capacity);
	}
}