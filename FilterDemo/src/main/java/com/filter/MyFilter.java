package com.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

public class MyFilter extends HttpFilter implements Filter {
       
	public void destroy() {
		System.out.println("Filter Destroy");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Before Do Filter");
		if(request.getParameter("email").equals("tops"))
		{
			if(request.getParameter("password").equals("tops"))
			{
				chain.doFilter(request, response);
			}
			else
			{
				request.setAttribute("msg", "Incorrect Password");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("msg", "Email Not Registered");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		System.out.println("After Do Filter");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter Initialized");
	}

}
