<%--
  Created by IntelliJ IDEA.
  User: c-alexmala
  Date: 12/19/20
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach var = "s" items="${test_students}">
    <div>
        <span style="display: inline-block; width: 80px">Id: <a href="student_get?id=${s.id}"><c:out value = "${s.id}"/></a></span>
        <span style="display: inline-block; width: 200px">First Name: <c:out value = "${s.firstName}"/></span>
        <span style="display: inline-block; width: 200px">Last Name: <c:out value = "${s.lastName}"/></span>
        <span style="display: inline-block; width: 200px"><a href="student_delete?id=${s.id}">Delete</a></span>
        <br><hr style="display: inline-block;width: 600px;">
    </div>
</c:forEach>

<div>
    <a href="new.jsp">New Student</a>
</div>
</body>
</html>
