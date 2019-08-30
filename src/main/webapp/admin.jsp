<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
Created by IntelliJ IDEA.
User: andrei
Date: 28.08.2019
Time: 1:42
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Title</title>
    <meta charset="windows-1251">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    ​
    <title>Landing Page - Start Bootstrap Theme</title>
    ​
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    ​
    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    ​
    <!-- Custom styles for this template -->
    <link href="css/landing-page.min.css" rel="stylesheet">
    <style>
        table{
            margin-top: 20px;
        }
    </style>
</head>
<body>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>QR</th>
        <th>Control</th>
    </tr>
    <c:forEach items="${tanks}" var="tank" varStatus="status">
        <tr>
            <td>${tank.id}</td>
            <td>${tank.tankName}</td>
            <td>${tank.qr}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/admin/edit?id=${tank.id}&item=tank">Edit</a>
                <a href="${pageContext.servletContext.contextPath}/admin/delete?id=${tank.id}&item=tank">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Добавить бак</button>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Добавить бак</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="POST" action="/admin/add">
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Наименование:</label>
                        <input type="text" class="form-control" id="recipient-name" name="tankName">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                <button type="button" class="btn btn-primary">Сохранить</button>
            </div>
        </div>
    </div>
</div>
</div>


<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Control</th>
    </tr>
    <c:forEach items="${categories}" var="category" varStatus="status">
        <tr>
            <td>${category.id}</td>
            <td>${category.trashCategoria}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/admin/delete?id=${category.id}&item=category">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Control</th>
    </tr>
    <c:forEach items="${trash}" var="trash" varStatus="status">
        <tr>
            <td>${trash.id}</td>
            <td>${trash.name}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/admin/edit?id=${trash.id}&item=trash">Edit</a>
                <a href="${pageContext.servletContext.contextPath}/admin/delete?id=${trash.id}&item=trash">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
