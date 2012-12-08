package com.josiahebhomenye.algorithm.datastructure;

import junit.framework.TestCase;
import java.util.*;

public class TernarySearchTreeTest extends TestCase {
	private TernarySearchTree _tree;

	protected void setUp() throws Exception {
		super.setUp();
		_tree = new TernarySearchTree();
		_tree.add("prefabricate");
		_tree.add("presume");
		_tree.add("prejudice");
		_tree.add("preliminary");
		_tree.add("apple");
		_tree.add("ape");
		_tree.add("appeal");
		_tree.add("car");
		_tree.add("dog");
		_tree.add("cat");
		_tree.add("mouse");
		_tree.add("mince");
		_tree.add("minty");
		_tree.add("prize");
	}

	public void testContains() {
		assertTrue(_tree.contains("prefabricate"));
		assertTrue(_tree.contains("presume"));
		assertTrue(_tree.contains("prejudice"));
		assertTrue(_tree.contains("preliminary"));
		assertTrue(_tree.contains("prize"));
		assertTrue(_tree.contains("apple"));
		assertTrue(_tree.contains("ape"));
		assertTrue(_tree.contains("appeal"));
		assertTrue(_tree.contains("car"));
		assertTrue(_tree.contains("dog"));
		assertTrue(_tree.contains("cat"));
		assertTrue(_tree.contains("mouse"));
		assertTrue(_tree.contains("mince"));
		assertTrue(_tree.contains("minty"));
		assertFalse(_tree.contains("pre"));
		assertFalse(_tree.contains("dogs"));
		assertFalse(_tree.contains("UNKNOWN"));
	}

	public void testPrefixSearch() {
		assertPrefixEquals(new String[] { "prefabricate", "prejudice",
				"preliminary", "presume" }, "pre");
		assertPrefixEquals(new String[] { "ape", "appeal", "apple" }, "ap");
	}

	public void testPatternMatch() {
		assertPatternEquals(new String[] { "mince", "mouse" }, "m???e");
		assertPatternEquals(new String[] { "car", "cat" }, "?a?");
	}

	private void assertPrefixEquals(String[] expected, String prefix) {
		List<CharSequence> words = _tree.prefixSearch(prefix);
		assertEquals(expected, words);
	}

	private void assertPatternEquals(String[] expected, String pattern) {
		List<CharSequence> words = _tree.patternMatch(pattern);
		assertEquals(expected, words);
	}

	private void assertEquals(String[] expected, List<CharSequence> actual) {
		assertEquals(expected.length, actual.size());
		for (int i = 0; i < expected.length; ++i) {
			assertEquals(expected[i], actual.get(i));
		}
	}
}