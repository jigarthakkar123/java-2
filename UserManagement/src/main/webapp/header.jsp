<%@page import="com.bean.Emp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	Emp e=null;
	if(session!=null)
	{
		if(session.getAttribute("e")!=null)
		{
			e=(Emp)session.getAttribute("e");
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Tops Technologies</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="index.jsp">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Courses <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Python</a></li>
          <li><a href="#">Java</a></li>
          <li><a href="#">Automation</a></li>
        </ul>
      </li>
      <li><a href="#">Contact</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    	<%
    		if(e==null)
    		{
    	%>
		      <li><a href="signup.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
		      <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		<%
    		}
    		else
    		{
    	%>
    			<li><a href="change-password.jsp"><span class="glyphicon glyphicon-edit"></span> Change Password</a></li>
    			<li><a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout(<%=e.getFname() %>)</a></li>
    			
    	<%		
    		}
		%>
    </ul>
  </div>
</nav>
</body>
</html>