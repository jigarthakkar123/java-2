<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
tr,td{
	padding:10px;
}
</style>
</head>
<body>
	<%
		if(request.getAttribute("msg")!=null)
		{
	%>
	<h3><%=request.getAttribute("msg") %></h3>
	<%		
		}
	%>
	<form name="frm" method="post" action="EmpController">
		<table>
			
			
			<tr>
				<td>Enter Email : </td>
				<td><input type="email"  name="email"></td>
			</tr>
			
			
			<tr>
				<td>
					<input type="submit" name="action" value="Send OTP" class="btn btn-primary">
				</td>
				
			</tr>
		</table>
	</form>
</body>
</html>