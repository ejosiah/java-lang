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
		// this test doesn't really make any sense so don't try to understand it :)
		final List<Integer> expected = Arrays.asList(1, 2, 3, 4 ,5);
		
		List<Integer> actual = list.apply(new Closure<List<Integer>, List<Integer>>() {

			@Override
			public List<Integer> call(List<Integer> list) {
				List<Integer> result = new ArrayList<Integer>();
				for(Integer item : expected){
					if(list.contains(item)){
						result.add(item);
					}
				}
				return result;
			}
		});
		
		Collections.sort(actual);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindAll() {
		List<Integer> expected = Arrays.asList(1, 3, 5, 7, 9); // odd numbers in list
		
		List<Integer> actual = list.findAll(new Closure<Integer, Boolean>() {
			@Override
			public Boolean call(Integer arg) {
				return arg % 2 != 0;
			}
		});
		
		Collections.sort(actual);
		assertEquals(expected, actual);
	}

	@Test
	public void testCollect() {
		List<Integer> expected = Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20);
		
		List<Integer> actual = list.collect(new Closure<Integer, Integer>() {
			@Override
			public Integer call(Integer it) {
				return it * 2;
			}
		});
		
		Collections.sort(actual);
		assertEquals(expected, actual);
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
		Integer actual = list.max();
		assertEquals(expected, actual);
	}

	@Test
	public void testSort() {
		List<Integer> expected = new ArrayList<Integer>(testData1);
		Collections.sort(expected);
		
		List<Integer> actual = list.sort();
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
		
		List<Integer> actual = list.sort(new DesendingOrder<Integer>());
		for(int i = 0; i < list.size(); i++){
			assertEquals("Items not equal", expected.get(0), actual.get(0));
		}
	}
	
	@Test
	public void testSortWithLessThan7Items() {
		List<Integer> testData = Arrays.asList(8, 2, 6, 4, 1);
		
		List<Integer> expected = new ArrayList<Integer>(testData);
		Collections.sort(expected);
		
		RichList<Integer> list = RichList.enrich(testData);
		List<Integer> actual = list.sort();
		for(int i = 0; i < list.size(); i++){
			assertEquals("Items not equal", expected.get(0), actual.get(0));
		}
	}
	
	@Test
	public void testSortWithClosureWithLessThan7Items() {
		List<Integer> testData = Arrays.asList(8, 2, 6, 4, 1);
		
		List<Integer> expected = new ArrayList<Integer>(testData);
		Collections.sort(expected, new Comparator<Integer>() {	// sort in desending order
			
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		
		RichList<Integer> list = RichList.enrich(testData);
		List<Integer> actual = list.sort(new DesendingOrder<Integer>());
		for(int i = 0; i < list.size(); i++){
			assertEquals("Items not equal", expected.get(0), actual.get(0));
		}
	}


}
