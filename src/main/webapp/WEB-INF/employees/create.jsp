<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create Employee" />
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Create a new Employee</h1>
    <form action="/employees/create" method="post">
        <div class="form-group">
            <label for="birthdate">Birthdate</label>
            <input id="birthdate" name="birthdate" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="firstname">First Name</label>
            <input id="firstname" name="firstname" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="lastname">Last Name</label>
            <input id="lastname" name="lastname" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="gender">Gender</label>
            <input id="gender" name="gender" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="hiredate">Hire Date</label>
            <input id="hiredate" name="hiredate" class="form-control" type="text">
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>

