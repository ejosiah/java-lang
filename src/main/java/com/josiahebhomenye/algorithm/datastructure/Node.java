package com.josiahebhomenye.algorithm.datastructure;

import lombok.*;

@Getter @Setter
class Node {
	private Character value;
	private Node childNode;
	private Node leftChild;
	private Node rightChild;
	private String word;
	
	
	Node(char value){
		this.value = value;
	}

	
	boolean isEndOfWord(){
		return word != null;
	}
	
	public String toString(){
		return "(" + value + ")";
	}
}