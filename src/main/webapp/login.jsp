<%--
  Created by IntelliJ IDEA.
  User: nadiabotello
  Date: 2019-06-11
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="partials/header.jsp" %>
</head>
<body>

<form method="POST" action="/login.jsp">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" class="form-control" name="username" id="username" aria-describedby="username" placeholder="Enter username">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" name="password" id="password" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<c:if test="${param.username == 'admin' && param.password == 'password'}">
    <% response.sendRedirect("/profile.jsp"); %>
</c:if>

<%@ include file="partials/footer.jsp" %>
</body>
</html>