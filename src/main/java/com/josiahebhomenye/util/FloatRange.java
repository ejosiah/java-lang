package com.josiahebhomenye.util;

public final class FloatRange extends Range<Float> {

	public FloatRange(Float lower, Float upper) {
		super(lower, upper);
		
	}
	
	public FloatRange(Float lower, Float upper, boolean inclusive) {
		super(lower, upper, inclusive);
		
	}

	@Override
	protected void nextNumber(int i, Float lower) {
		range.add(i + lower);
		
	}


}
