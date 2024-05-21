<%
	session.removeAttribute("e");
	session.invalidate();
	response.sendRedirect("login.jsp");
%>