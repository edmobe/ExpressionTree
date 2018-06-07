package com.mkyong.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mkyong.Expression;
import com.mkyong.JSONTree;
import com.mkyong.Message;

@Path("/json")
public class JSONService {

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message createTreeInJSON(Expression expression) {
		JSONTree tree = new JSONTree();
		
		// For testing
		String result = "Converted the expression ''" + expression.getExpression() + "'' to a tree.";
		System.out.println(result);
		
		String stack = tree.update(expression.getExpression());
		
		Message message = new Message();
		message.setStack(stack);
		message.setTree(tree);
		
		return message;
	}
	
}