package com.josiahebhomenye.util;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.josiahebhomenye.Closure;
import com.josiahebhomenye.Visitor;
import com.josiahebhomenye.function.Tuple2;

@Ignore
public class RichListTest {
	
	private static final List<Integer> testData1 = Arrays.asList(5, 2, 8, 6, 9, 3, 7, 4, 1, 10);
	private static final List<String> testData2 = Arrays.asList("Z", "S", "U", "A", "T", "Q", "M", "K");
	private RichList<Integer> list;
	@Before
	public void setUp() throws Exception {
		list = RichList.enrich(testData1);
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testFoldEClosure() {
		RichList<Integer> list = RichList.enrich(Arrays.asList(1, 2, 3, 4, 5));
		int expected = 120;
		// folding this list should give use factoral of 5
		int actual = list.fold(new Tuple2Closure<Integer, Integer>() {
			
			public Integer call(Tuple2<Integer, Integer> tuple) {
				return tuple.a * tuple.b;
			}
		});
		assertEquals(expected, actual);
	}

	@Test
	public void testFoldClosureWithInitialValue() {
		int initialValue = 11;
		Integer expected = (int) ((initialValue/2.0) * (initialValue + 1));  // sum first 11 numbers n/2 * (n + 1)
		
		Integer actual = list.fold(initialValue, new Tuple2Closure<Integer, Integer>() {

			public Integer call(Tuple2<Integer, Integer> tuple) {
				return tuple.a + tuple.b;
			}
		});
		
		assertEquals(expected, actual);
		
	}
	
	private Integer count = 0;
	
	@Test
	public void testEach() {
		Integer expected = list.size();
		
		list.each(new Visitor<Integer>() {
			public void visit(Integer t) {
				count++;	
			}
		});
		
		assertEquals(expected, count);
	}

	@Test
	public void testUse() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testCollect() {
		fail("Not yet implemented");
	}

	@Test
	public void testMin() {
		Integer expected = 1;
		Integer actual = list.min();
		assertEquals(expected, actual);
	}

	@Test
	public void testMax() {
		Integer expected = 10;
		Integer actual = list.min();
		assertEquals(expected, actual);
	}

	@Test
	public void testSort() {
		List<Integer> expected = new ArrayList<Integer>(testData1);
		Collections.sort(expected);
		
		list.sort();
		List<Integer> actual = new ArrayList<Integer>(list.getDelegate());
		for(int i = 0; i < list.size(); i++){
			assertEquals("Items not equal", expected.get(0), actual.get(0));
		}
	}

	@Test
	public void testSortWithClosure() {
		List<Integer> expected = new ArrayList<Integer>(testData1);
		Collections.sort(expected, new Comparator<Integer>() {	// sort in desending order

			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		
		list.sort(new Closure<Tuple2<Integer,Integer>, Boolean>() {

			public Boolean call(Tuple2<Integer, Integer> t) {
				return t.b > t.a;
			}
		});
		List<Integer> actual = new ArrayList<Integer>(list.getDelegate());
		for(int i = 0; i < list.size(); i++){
			assertEquals("Items not equal", expected.get(0), actual.get(0));
		}
	}


}
