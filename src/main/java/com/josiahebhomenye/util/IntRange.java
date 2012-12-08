package com.josiahebhomenye.util;

public class IntRange extends Range<Integer> {

	public IntRange(Integer lower, Integer upper) {
		super(lower, upper);
		
	}
	
	public IntRange(Integer lower, Integer upper, boolean inclusive) {
		super(lower, upper, inclusive);
		
	}

	@Override
	protected void nextNumber(int i, Integer lower) {
		range.add(i + lower);
		
	}


}
