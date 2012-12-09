package com.josiahebhomenye.function;

import java.io.Serializable;

import lombok.Data;

@Data
public class Tuple6<A, B, C, D, E, F> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public final A a;
	public final B b;
	public final C c;
	public final D d;
	public final E e;
	public final F f;
	
}
