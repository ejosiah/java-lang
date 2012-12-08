package com.josiahebhomenye.util;

import java.math.BigInteger;

public class BigIntRange extends Range<BigInteger> {

	public BigIntRange(BigInteger lower, BigInteger upper) {
		super(lower, upper);
		
	}
	
	public BigIntRange(BigInteger lower, BigInteger upper, boolean inclusive) {
		super(lower, upper, inclusive);
		
	}

	@Override
	protected void nextNumber(int i, BigInteger lower) {
		range.add(lower.add(new BigInteger(i + "")));
		
	}


}
