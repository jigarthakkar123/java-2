package com.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ServletContext context;
	
	public void init(ServletConfig config) throws ServletException {
		this.context=config.getServletContext();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		int counter=1;
		if(context.getAttribute("counter")!=null)
		{
			counter=Integer.parseInt(context.getAttribute("counter").toString());
			counter++;
		}
		out.print("You Are Visiting This Web Page "+counter+" Times");
		context.setAttribute("counter", counter);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
