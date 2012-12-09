package com.josiahebhomenye.function;

import java.io.Serializable;

import lombok.Data;

@Data
public final class Tuple2<A,B> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public final A a;
	public final B b;
	
}
