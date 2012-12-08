package com.josiahebhomenye.util;

public class ByteRange extends Range<Byte> {

	public ByteRange(Byte lower, Byte upper) {
		super(lower, upper);
		
	}
	
	public ByteRange(Byte lower, Byte upper, boolean inclusive) {
		super(lower, upper, inclusive);
		
	}

	@Override
	protected void nextNumber(int i, Byte lower) {
		range.add(i + lower);
		
	}

}
