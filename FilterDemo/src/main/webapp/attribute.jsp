<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Define custom tag with attributes --%>
<customTag:tagName>
    <jsp:attribute name="attributeName">attributeValue</jsp:attribute>
</customTag:tagName>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Display Attribute</title>
</head>
<body>
    <h1>Display Attribute</h1>
    
    <%-- Display attribute value --%>
    <p>Attribute Value: <c:out value="${attributeName}" /></p>
</body>
</html>
