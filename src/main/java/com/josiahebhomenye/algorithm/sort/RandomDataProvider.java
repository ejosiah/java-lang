package com.josiahebhomenye.algorithm.sort;


import java.util.*;

public class RandomDataProvider extends AbstractDataProvider{
	
	RandomDataProvider(String location){
		super(location);
	}

	@Override
	public List<String> provide() throws Exception {
		List<String> data = super.provide();
		Collections.shuffle(data);
		
		return data;
	}

}
