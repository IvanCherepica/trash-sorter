<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: andrei
  Date: 28.08.2019
  Time: 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    <c:forEach items="${tanks}" var="tank" varStatus="status">
        <tr>
            <td>${tank.id}</td>
            <td>${tank.tankName}</td>
            <td>

                <a href="${pageContext.servletContext.contextPath}/admin/edit?id=${tank.id}">Edit</a>
                <a href="${pageContext.servletContext.contextPath}/admin/delete?id=${tank.id}&item=tank">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    <c:forEach items="${categories}" var="category" varStatus="status">
        <tr>
            <td>${category.id}</td>
            <td>${category.trashCategoria}</td>
            <td>
<%--                <a href="${pageContext.servletContext.contextPath}/admin/edit?id=${category.id}">Edit</a>--%>
                Edit
                <a href="${pageContext.servletContext.contextPath}/admin/delete?id=${category.id}&item=category">
                    Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    <c:forEach items="${trash}" var="trash" varStatus="status">
        <tr>
            <td>${trash.id}</td>
            <td>${trash.name}</td>
            <td>
<%--                <a href="${pageContext.servletContext.contextPath}/admin/edit?id=${trash.id}">Edit</a>--%>
                Edit
                <a href="${pageContext.servletContext.contextPath}/admin/delete?id=${trash.id}&item=trash">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
