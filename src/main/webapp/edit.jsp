<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: andrei
  Date: 28.08.2019
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

<table border="1" cellpadding="5">
    <tr>
        <th class="id">ID</th>
        <th>Category</th>
    </tr>
    <c:forEach items="${categs}" var="categ" varStatus="status">
        <tr>
            <td>${categ.id}</td>
            <td>${categ.trashCategoria}</td>
            <td>
                <input type="checkbox" class="editor" value=${categ.id}>Add to tank
            </td>
        </tr>
    </c:forEach>
</table>

<input type="button" id="sendSelectedCategory" value="Change">

<script>

    $('#sendSelectedCategory').on('click', function () {
        $.ajax({
            method: 'POST',
            url: '/admin/edit',
            data: {
                tankId: $_GET('id'),
                itemType: $_GET('item'),
                ids: JSON.stringify(getSelectedIds())
            },
            success: function(response){
                console.log('succes')
            },
            error: function (e) {
                console.log(e);
            }
        });
    });

    function getSelectedIds() {
        var values = [];

        $('input[type="checkbox"]:checked').each(function() {
            values.push($(this).val());
        });

        return values;
    }
    var selected;
    $('#clicker').on('click', function () {

        var values = [];
        $('input[type="checkbox"]:checked').each(function() {
            values.push($(this).val());
        });
        console.log(values);
    });

    function $_GET(key) {
        var p = window.location.search;
        p = p.match(new RegExp(key + '=([^&=]+)'));
        return p ? p[1] : false;
    }
</script>

</body>
</html>
