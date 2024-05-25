package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.bean.User;
import com.dao.UserDao;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("sign up"))
		{
			boolean flag=UserDao.checkEmail(request.getParameter("email"));
			if(flag==false)
			{
				if(request.getParameter("password").equals(request.getParameter("cpassword")))
				{
					User u=new User();
					u.setFname(request.getParameter("fname"));
					u.setLname(request.getParameter("lname"));
					u.setEmail(request.getParameter("email"));
					u.setMobile(Long.parseLong(request.getParameter("mobile")));
					u.setAddress(request.getParameter("address"));
					u.setPassword(request.getParameter("password"));
					u.setUsertype(request.getParameter("usertype"));
					UserDao.signupUser(u);
					request.setAttribute("msg", "User Sign Up Successfully");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("msg", "Password & Confirm Password Does Not Matched");
					request.getRequestDispatcher("signup.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("msg", "Email Already Registered");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("login"))
		{
			User u=UserDao.loginUser(request.getParameter("email"));
			
			if(u!=null)
			{
				if(u.getPassword().equals(request.getParameter("password")))
				{
					HttpSession session=request.getSession();
					session.setAttribute("u", u);
					if(u.getUsertype().equals("Owner"))
					{
						request.getRequestDispatcher("owner-index.jsp").forward(request, response);
					}
					else
					{
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					
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
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("change password"))
		{
			HttpSession session=request.getSession();
			User u=(User)session.getAttribute("u");
			if(u.getPassword().equals(request.getParameter("old_password")))
			{
				if(request.getParameter("new_password").equals(request.getParameter("cnew_password")))
				{
					UserDao.changePassword(u.getEmail(), request.getParameter("new_password"));
					session.removeAttribute("u");
					session.invalidate();
					request.setAttribute("msg", "Password Changed Successfully");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("msg", "New Password & Confirm New Password Does Not Matched");
					request.getRequestDispatcher("change-password.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("msg", "Old Password Does Not Matched");
				request.getRequestDispatcher("change-password.jsp").forward(request, response);
			}
		}
	}

}
