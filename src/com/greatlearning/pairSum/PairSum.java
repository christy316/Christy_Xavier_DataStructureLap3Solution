package com.greatlearning.pairSum;

import java.util.HashSet;

public class PairSum {
	
	static class Node{
		int nodeData;
		Node leftNode;
		Node righNode;
	}
	
	static Node NewNode(int nodeDate) {
		Node temp = new Node();
		temp.nodeData = nodeDate;
		temp.leftNode = null;
		temp.righNode = null;
		
		return temp;		
	}
	
	private Node insert(Node root,int key) {
		if(root == null) {
			return NewNode(key);
		}
		if(key< root.nodeData)
			root.leftNode = insert(root.leftNode, key);
		else 
			root.righNode = insert(root.righNode, key);
		return root;
	}
	
	private boolean findPair(Node root, int sum,HashSet<Integer> set) {
		
		if(root == null) {
			return false;
		}
		if(findPair(root.leftNode, sum, set))
			return true;
		
		if(set.contains(sum-root.nodeData)) {
			System.out.println("Pair is found (" + (sum-root.nodeData) +", " +root.nodeData +")" );
			return true;
		}
		else
			set.add(root.nodeData);
		
		return findPair(root.righNode, sum, set);
	}
	
	private void findPairWithGivenSum(Node root, int sum) {
		
		HashSet<Integer> set = new HashSet<>();
		if(!findPair(root, sum, set))
			System.out.println("Pair is not foound");		
	}

	public static void main(String[] args) {
		
		Node root = null;
		PairSum findSum = new PairSum();
		root = findSum.insert(root, 40);
		root = findSum.insert(root, 20);
		root = findSum.insert(root, 60);
		
		int sum = 60;
		findSum.findPairWithGivenSum(root, sum);
	}

}
