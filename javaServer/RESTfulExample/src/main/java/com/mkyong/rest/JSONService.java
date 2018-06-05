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

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getTrackInJSON() {
		
		Message message = new Message();
		ExpressionTree tree = new ExpressionTree();
		
		tree.setText("0");
		String stack = "[0]";
		
		message.setTree(tree);
		message.setStack(stack);
		
		return message;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message createTreeInJSON(Expression expression) {
		ExpressionTree tree = new ExpressionTree();
		
		// For testing
		String result = "Converted the expression ''" + expression.getExpression() + "'' to a tree.";
		System.out.println(result);
		
		//String stack = tree.update(expression);
		
		// For testing
		tree.setText(expression.getExpression());
		String stack = "[" + expression.getExpression() + "]";
		
		Message message = new Message();
		message.setStack(stack);
		message.setTree(tree);
		
		return message;
	}
	
}