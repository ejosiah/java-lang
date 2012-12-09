package com.josiahebhomenye.util;

import com.josiahebhomenye.Closure;
import com.josiahebhomenye.function.Tuple2;

final class Bigger<T extends Comparable<T>> implements Closure<Tuple2<T, T>, T> {

	public T call(Tuple2<T, T> t) {
		if(t.a.compareTo(t.b) > 0){
			return t.a;
		}else if(t.a.compareTo(t.b) < 0){
			return t.b;
		}else{
			return t.a;
		}
	}

}
