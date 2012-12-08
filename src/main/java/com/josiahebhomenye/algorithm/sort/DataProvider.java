package com.josiahebhomenye.algorithm.sort;

import java.util.List;

public interface DataProvider<E extends Comparable<E>> {
	
	List<E> provide() throws Exception;

}
