<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <div>Student id: <c:out value="${test_student.id}"/>
    <div>Student First Name: <c:out value="${test_student.firstName}"/>
    <div>Student Last Name: <c:out value="${test_student.lastName}"/>
    <div>
        <a href="students">All Students</a>
    </div>

</body>
</html>
