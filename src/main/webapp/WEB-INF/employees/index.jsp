<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Employees" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the Employees!</h1>

    <c:forEach var="employee" items="${employees}">
        <div class="card" style="width: 18rem;">
            <img src="https://robohash.org/${employee.name}" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">${employee.first_name} ${employee.last_name}</h5>
                <p class="card-text">Sample Employee</p>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
