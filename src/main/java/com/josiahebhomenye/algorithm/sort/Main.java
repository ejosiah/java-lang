package com.josiahebhomenye.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String...args){
		List list = Arrays.asList(new Integer[]{1, 2, 3 ,4});
		
		System.out.println(list.get(0));
		
		try {
			System.out.println(list.add(5));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(list.remove(3));
	}

}
