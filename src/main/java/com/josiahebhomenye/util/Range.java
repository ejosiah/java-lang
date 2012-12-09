package com.josiahebhomenye.util;

import java.util.ArrayList;
import java.util.List;

import lombok.Delegate;

public abstract class Range<N extends Number> implements Iterable<N> {
	
	@Delegate
	protected final RichList<N> range = RichList.enrich(new ArrayList<N>());
	
	public Range(N lower, N upper){
		this(lower, upper, false);
	}
	
	public Range(N lower, N upper, boolean inclusive){
		initialize(lower, upper, inclusive);
	}
	
	private void initialize(N lower, N upper, boolean inclusive){
		int count = inclusive ? upper.intValue() + 1 : upper.intValue();
		for(int i = 0; i < count; i++){
			nextNumber(i, lower);
		}
	}

	protected abstract void nextNumber(int i, N lower);
}
