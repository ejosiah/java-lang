package com.josiahebhomenye.function;

import java.io.Serializable;

import lombok.Data;

@Data
public class Tuple10<A, B, C, D, E, F, G, H, I, J> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public final A a;
	public final B b;
	public final C c;
	public final D d;
	public final E e;
	public final F f;
	public final G g;
	public final H h;
	public final I i;
	public final J j;
}
