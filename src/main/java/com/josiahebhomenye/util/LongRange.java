package com.josiahebhomenye.util;

public final class LongRange extends Range<Long> {

	public LongRange(Long lower, Long upper) {
		super(lower, upper);
		
	}
	
	public LongRange(Long lower, Long upper, boolean inclusive) {
		super(lower, upper, inclusive);
		
	}

	@Override
	protected void nextNumber(int i, Long lower) {
		range.add(i + lower);
		
	}


}
