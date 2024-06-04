<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="com.tops.User" />
<jsp:setProperty name="user" property="username" value="Jigar" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Set and Display Property</title>
</head>
<body>
    <h1>Set and Display Property</h1>
    <%
        // Get the value of the username property and print it
        String username = user.getUsername();
    %>
    <p>Username: <%= username %></p>
</body>
</html>
