<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h1 {
            color: #333;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            margin-bottom: 10px;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Welcome to JSP Action Tags Example</h1>
    <ul>
        <li><a href="include.jsp">Include Action</a></li>
        <li><a href="forward.jsp">Forward Action</a></li>
        <li><a href="setProperty.jsp">setProperty Action</a></li>
        <li><a href="getProperty.jsp">getProperty Action</a></li>
        <li><a href="useBean.jsp">useBean Action</a></li>
        <li><a href="plugin.jsp">plugin Action</a></li>
        <li><a href="attribute.jsp">attribute Action</a></li>
        <li><a href="body.jsp">body Action</a></li>
    </ul>
</body>
</html>
