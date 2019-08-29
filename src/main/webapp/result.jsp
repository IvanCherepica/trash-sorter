<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Результат по QR-CODE</title>
</head>
<body>
<center>
    <h1>Данные</h1>

</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Данные по товару</h2></caption>
        <tr>
            <th>Наименование</th>

        </tr>
        <c:forEach items="${result}" var="result">
            <tr>
                <td>${result}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>