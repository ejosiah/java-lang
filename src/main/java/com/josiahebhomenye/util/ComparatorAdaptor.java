package com.josiahebhomenye.util;

import java.util.Comparator;

import com.josiahebhomenye.Closure;
import com.josiahebhomenye.function.Tuple2;

public class ComparatorAdaptor<T extends Comparable<T>> implements Comparator<T> {

	
	private Closure<Tuple2<T, T>, Boolean> comparator;

	public ComparatorAdaptor(Closure<Tuple2<T, T>, Boolean> comparator){
		this.comparator = comparator;
	}
	
	@Override
	public int compare(T o1, T o2) {
		final Tuple2<T, T> tuple = new Tuple2<T, T>(o1, o2);
		
		if(comparator.call(tuple) == true){
			return -1;
		}else{
			return 1;
		}
	}

}
