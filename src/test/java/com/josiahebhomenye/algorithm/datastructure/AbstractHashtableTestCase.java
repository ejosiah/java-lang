package com.josiahebhomenye.algorithm.datastructure;


import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;

public abstract class AbstractHashtableTestCase {
	private static final int TEST_SIZE = 1000;
	private Hashtable<String> hashtable;
	
	protected abstract Hashtable<String> createTable(int capacity);

	@Before
	public void setUp() throws Exception {
		hashtable = createTable(TEST_SIZE);
		for (int i = 0; i < TEST_SIZE; ++i) {
			hashtable.add(String.valueOf(i));
		}
	}

	@After
	public void tearDown() throws Exception {
	}
	


	public void testContains() {
		for (int i = 0; i < TEST_SIZE; ++i) {
			assertTrue(hashtable.contains(String.valueOf(i)));
		}
	}

	public void testDoesntContain() {
		for (int i = 0; i < TEST_SIZE; ++i) {
			assertFalse(hashtable.contains(String.valueOf(i + TEST_SIZE)));
		}
	}

	public void testAddingTheSameValuesDoesntChangeTheSize() {
		assertEquals(TEST_SIZE, hashtable.size());
		for (int i = 0; i < TEST_SIZE; ++i) {
			hashtable.add(String.valueOf(i));
			assertEquals(TEST_SIZE, hashtable.size());
		}
	}

}
