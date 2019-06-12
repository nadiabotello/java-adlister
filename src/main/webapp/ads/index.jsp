<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nadiabotello
  Date: 2019-06-12
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ads Page</title>
</head>
<body>
    <h1>Available items</h1>
    <c:forEach var="ad" items="${ads}">
            <ul>
            <h2>${ad.title}</h2>
            <li><p>${ad.description}</p></li>
            </ul>
    </c:forEach>
</body>
</html>
