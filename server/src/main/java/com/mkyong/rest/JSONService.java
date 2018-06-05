package com.mkyong.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mkyong.Expression;
import com.mkyong.ExpressionTree;
import com.mkyong.Message;

@Path("/json")
public class JSONService {
	
	ExpressionTree tree = new ExpressionTree();
	String stack;
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getTreeInJSON() {
		Message message = new Message();
		
		tree.setText("0");
		stack = "[0]";
		
		message.setTree(tree);
		message.setStack(stack);
		
		return message;
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message createTreeInJSON(Expression expression) {
		Message message = new Message();
		
		// For testing
		String result = "Converted the expression ''" + expression.getExpression() + "'' to a tree.";
		System.out.println(result);
		
		// stack = tree.update(expression);
		
		// For testing
		tree.setText(expression.getExpression());
		stack = "[" + expression.getExpression() + "]";
		
		message.setTree(tree);
		message.setStack(stack);
		
		return message;
	}
}
