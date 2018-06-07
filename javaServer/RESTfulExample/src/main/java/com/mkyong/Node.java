package com.mkyong;

// Java program for expression tree
public class Node {

	char value;
	Node left, right;

	Node(char item) {
		value = item;
		left = right = null;
	}
}