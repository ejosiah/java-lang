package com.josiahebhomenye.util;

public final class DoubleRange extends Range<Double> {

	public DoubleRange(Double lower, Double upper) {
		super(lower, upper);
		
	}
	
	public DoubleRange(Double lower, Double upper, boolean inclusive) {
		super(lower, upper, inclusive);
		
	}

	@Override
	protected void nextNumber(int i, Double lower) {
		range.add(i + lower);
		
	}


}
