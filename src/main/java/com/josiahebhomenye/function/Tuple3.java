package com.josiahebhomenye.function;

import java.io.Serializable;

import lombok.Data;

@Data
public class Tuple3<A, B, C> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public final A a;
	public final B b;
	public final C c;
	
}
