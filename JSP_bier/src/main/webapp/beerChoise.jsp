<%--
  Created by IntelliJ IDEA.
  User: jaspe
  Date: 05/04/2023
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Beer selection page</title>
</head>
<body>
<h1>Beer selection page</h1>
<p>Choose your favorite beer color</p>
<form action="beerSelect" method="post">
    <select name="color">
        <c:forEach items="${beerColors}" var="color">
            <option><c:out value="${color}"/></option>
        </c:forEach>
    </select>

    <input type="submit" value="Submit">
</form>


</body>
</html>
