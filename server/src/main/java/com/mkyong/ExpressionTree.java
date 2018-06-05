package com.mkyong;

public class ExpressionTree {
	
	text text = new text();
	ExpressionTree[] children;
	
	public text getText() {
		return text;
	}
	public void setText(String name) {
		this.text.name = name;
	}
	public ExpressionTree[] getChildren() {
		return children;
	}
	public void setChildren(ExpressionTree[] children) {
		this.children = children;
	}
	
	public String update(String expression) {
		// here, the tree is modified based on an expression
		// returns the stack (string)
		return "";
	}
	
}
