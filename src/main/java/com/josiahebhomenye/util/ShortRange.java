package com.josiahebhomenye.util;

public final class ShortRange extends Range<Short> {

	public ShortRange(Short lower, Short upper) {
		super(lower, upper);
		
	}
	
	public ShortRange(Short lower, Short upper, boolean inclusive) {
		super(lower, upper, inclusive);
		
	}

	@Override
	protected void nextNumber(int i, Short lower) {
		range.add(i + lower);
		
	}


}
