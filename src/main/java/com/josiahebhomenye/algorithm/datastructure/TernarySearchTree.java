package com.josiahebhomenye.algorithm.datastructure;

import java.util.*;

public class TernarySearchTree{
	private static final char WILDCARD = '?';
	private Node root;

	public void add(CharSequence word) {
		Node node = insert(root, word, 0);
		root = (root == null) ? node : root;
	}

	private Node insert(Node node, CharSequence word, int index) {
		char c = word.charAt(index);
		node = (node == null) ? new Node(c) : node;
		
		if(c == node.getValue()){
			if(index + 1 < word.length()){
				node.setChildNode(insert(node.getChildNode(), word, index + 1));
			}else{
				node.setWord(word.toString());
			}
		}else if(c < node.getValue()){
			node.setLeftChild(insert(node.getLeftChild(), word, index));
		}else{
			node.setRightChild(insert(node.getRightChild(), word, index));
		}
		
		return node;
	}

	public boolean contains(CharSequence word) {
		Node node = search(root, word, 0);
		return node != null && node.isEndOfWord();
	}

	private Node search(Node node, CharSequence word, int index) {
		if(node == null){
			return null;
		}
		
		char c = word.charAt(index);
		if(c == node.getValue()){
			if(index + 1 < word.length()){
				node = search(node.getChildNode(), word, index + 1);
			}
		}else if(c < node.getValue()){
			node = search(node.getLeftChild(), word, index);
		}else{
			node = search(node.getRightChild(), word, index);
		}
		
		return node;
	}

	public List<CharSequence> patternMatch(CharSequence pattern) {
		List<CharSequence> results = new LinkedList<CharSequence>();
		patternMarch(root, pattern, 0, results);
		
		return results;
		
	}
	private void patternMarch(Node node, CharSequence pattern, int index, List<CharSequence> results) {
		if(node == null){
			return;
		}
		
		char c = pattern.charAt(index);
		
		if(c == WILDCARD || c < node.getValue()){
			patternMarch(node.getLeftChild(), pattern, index, results);
		}
		
		if(c == WILDCARD || c == node.getValue()){
			if(index + 1 < pattern.length()){
				patternMarch(node.getChildNode(), pattern, index + 1, results);
			}else if(node.isEndOfWord()){
				results.add(node.getWord());
			}
		}
		if(c == WILDCARD || c > node.getValue()){
			patternMarch(node.getRightChild(), pattern, index, results);
		}
		
	}

	public List<CharSequence> prefixSearch(CharSequence prefix) {
		List<CharSequence> results = new LinkedList<CharSequence>();
		Node node = search(root, prefix, 0);
		node = (node == null) ? node : node.getChildNode();
		inOrderTraversal(node, results);
		return results;
	}
	
	private void inOrderTraversal(Node node, List<CharSequence> results) {
		if(node == null){
			return;
		}
		
		inOrderTraversal(node.getLeftChild(), results);
		if(node.isEndOfWord()){
			results.add(node.getWord());
		}
		inOrderTraversal(node.getChildNode(), results);
		inOrderTraversal(node.getRightChild(), results);
		
	}


}
