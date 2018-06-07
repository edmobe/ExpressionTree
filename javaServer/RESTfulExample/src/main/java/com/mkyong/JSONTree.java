package com.mkyong;

public class JSONTree {

	text text = new text();
	JSONTree[] children;

	public text getText() {
		return text;
	}

	public void setText(char name) {
		this.text.name = name;
	}

	public JSONTree[] getChildren() {
		return children;
	}

	public void setChildren(JSONTree[] children) {
		this.children = children;
	}

	public String update(String expression) {
		ExpressionTree tree = new ExpressionTree();
		InToPost theTrans = new InToPost(expression);
		String postfix = theTrans.doTrans();
		char[] charArray = postfix.toCharArray();
		Node root = tree.constructTree(charArray);

		setParameters(root, this);

		return postfix;
	}

	public void setParameters(Node node, JSONTree tree) {
		tree.text.name = node.value;

		if (node.left != null && node.right != null) {
			tree.children = new JSONTree[2];
			tree.children[0] = new JSONTree();
			setParameters(node.left, tree.children[0]);
			tree.children[1] = new JSONTree();
			setParameters(node.right, tree.children[1]);
		} else if (node.left != null || node.right != null) {
			tree.children = new JSONTree[1];
			tree.children[0] = new JSONTree();
			if (node.left != null) {
				setParameters(node.left, tree.children[0]);
			} else {
				setParameters(node.right, tree.children[0]);
			}
		}
	}
}
