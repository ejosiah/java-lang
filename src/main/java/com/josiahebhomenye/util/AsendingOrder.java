package com.josiahebhomenye.util;

import com.josiahebhomenye.Closure;
import com.josiahebhomenye.function.Tuple2;

final class AsendingOrder<T extends Comparable<T>> implements Closure<Tuple2<T,T>, Boolean> {

	@Override
	public Boolean call(Tuple2<T, T> t) {
		return t.a.compareTo(t.b) <= 0;
	}

}
