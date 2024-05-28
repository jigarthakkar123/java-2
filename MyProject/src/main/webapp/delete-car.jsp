<%@page import="com.dao.CarDao"%>
<%
	int cid=Integer.parseInt(request.getParameter("cid"));
	CarDao.deleteCar(cid);
	request.setAttribute("msg", "Car Deleted Successfully");
	request.getRequestDispatcher("view-car.jsp").forward(request, response);
%>