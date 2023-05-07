<%--
  Created by IntelliJ IDEA.
  User: jaspe
  Date: 05/04/2023
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Color bier result</title>
</head>
<body>

<h1>Color bier result</h1>
<p>Color bier is: ${color}</p>

<c:forEach var="beer" items="${list}">
    <p>${beer}</p>
</c:forEach>
</body>
</html>
