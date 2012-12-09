package com.josiahebhomenye.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartialySortedDataProvider extends AbstractDataProvider {

	public PartialySortedDataProvider(String pathname) {
		super(pathname);
	}

	@Override
	public List<String> provide() throws Exception {
		List<String> data = super.provide();
		data = new InsertionSort<String>().sort(data);
		List<String> left = split(0, data.size()/2, data);
		List<String> right = split(data.size()/2 + 1, data.size(), data);
		Collections.shuffle(right);
		left.addAll(right);
		
		return left;
	}
	
	private List<String> split(int from, int to, List<String>	list){
		return new ArrayList<String>(list.subList(from, to));
	}

}
