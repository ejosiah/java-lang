package com.josiahebhomenye.algorithm.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort<T extends Comparable<T>> extends AbstractSorter<T> {



	@Override
	public List<T> sort(List<T> list, Comparator<T> withComparator) {
		if(list.size() <= 1){
			return list;
		}
		
		int middle = list.size() / 2;
		List<T> left = sort(split(0, middle, list), withComparator);
		List<T> right = sort(split(middle++, list.size(), list), withComparator);
		list = merge(left, right, withComparator);
		
		return list;
	}
	
	private List<T> split(int from, int to, List<T>	list){
		return new ArrayList<T>(list.subList(from, to));
	}
	
	
	@SuppressWarnings("unchecked")
	private List<T> merge(List<T> left, List<T> right, Comparator<T> withComparator) {
		List<T> results = new ArrayList<T>();
		
		while(eitherListNotEmpty(left, right)){
			if(bothListNotEmpty(left, right)){
				if(compare(left, right, withComparator)){
					results.add(left.remove(0));
				}else{
					results.add(right.remove(0));
				}
			}else if (!left.isEmpty()){
				results.add(left.remove(0));
			}else if(!right.isEmpty()){
				results.add(right.remove(0));
			}
		}
		
		return results;
	}
	
	private boolean eitherListNotEmpty(List<T>...lists){
		boolean notEmpty = false;
		for(List<T> list : lists){
			notEmpty = (notEmpty || !list.isEmpty());
		}
		return notEmpty;
	}
	
	private boolean bothListNotEmpty(List<T> left, List<T> right){
		return !left.isEmpty() && !right.isEmpty();
	}

	private boolean compare(List<T> left, List<T> right, Comparator<T> comparator) {
		if(comparator != null){
			return comparator.compare(left.get(0), right.get(0)) <= 0;
		}
		return left.get(0).compareTo(right.get(0)) <= 0;
	}

}
