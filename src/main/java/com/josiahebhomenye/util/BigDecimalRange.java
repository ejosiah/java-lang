package com.josiahebhomenye.util;

import java.math.BigDecimal;

public class BigDecimalRange extends Range<BigDecimal> {

	public BigDecimalRange(BigDecimal lower, BigDecimal upper) {
		super(lower, upper);
		
	}
	
	public BigDecimalRange(BigDecimal lower, BigDecimal upper, boolean inclusive) {
		super(lower, upper, inclusive);
		
	}

	@Override
	protected void nextNumber(int i, BigDecimal lower) {
		range.add(lower.add(new BigDecimal(i + "")));
		
	}


}
