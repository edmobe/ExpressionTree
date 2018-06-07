package com.mkyong;

// Java program to construct an expression tree

import java.util.Stack;

public class ExpressionTree {

	// A utility function to check if 'c'
	// is an operator

	boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
			return true;
		}
		return false;
	}

	// Utility function to do inorder traversal
	void inorder(Node t) {
		if (t != null) {
			inorder(t.left);
			System.out.print(t.value + " ");
			inorder(t.right);
		}
	}

	// Returns root of constructed tree for given
	// postfix expression
	Node constructTree(char postfix[]) {
		Stack<Node> st = new Stack();
		Node t, t1, t2;

		// Traverse through every character of
		// input expression
		for (int i = 0; i < postfix.length; i++) {

			// If operand, simply push into stack
			if (!isOperator(postfix[i])) {
				t = new Node(postfix[i]);
				st.push(t);
			} else // operator
			{
				t = new Node(postfix[i]);

				// Pop two top nodes
				// Store top
				t1 = st.pop(); // Remove top
				t2 = st.pop();

				// make them children
				t.right = t1;
				t.left = t2;

				// System.out.println(t1 + "" + t2);
				// Add this subexpression to stack
				st.push(t);
			}
		}

		// only element will be root of expression
		// tree
		t = st.peek();
		st.pop();

		return t;
	}

	void printPostorder(Node node) {
		if (node == null)
			return;

		// first recur on left subtree
		printPostorder(node.left);

		// then recur on right subtree
		printPostorder(node.right);

		// now deal with the node
		System.out.print(node.value + " ");
	}

	public static void main(String args[]) {

		ExpressionTree et = new ExpressionTree();
		InToPost theTrans = new InToPost("5+3*2-5 *2+(1+4)*3");
		String postfix = theTrans.doTrans();
		char[] charArray = postfix.toCharArray();
		Node root = et.constructTree(charArray);
		et.printPostorder(root); // debugging
	}
}

// This code has been contributed by Mayank Jaiswal
