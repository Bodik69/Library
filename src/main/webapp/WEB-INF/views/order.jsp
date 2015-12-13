<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Orders</title>
</head>
<body>
<form method="post" action="add">
    <table>
        <tr>
            <td>Прізвище: </td>
            <td><input type="text" name="surname"></td>
        </tr>
        <tr>
            <td>Ім'я: </td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Книжка: </td>
            <td><input type="text" name="book"></td>
        </tr>
        <tr>
            <td>Інвентарний номер: </td>
            <td><input type="text" name="inventoryNumber"></td>
        </tr>
        <tr>
            <td>Дата видачі: </td>
            <td><input type="text" name="dataOrder"></td>
        </tr>
        <tr>
            <td>Дата повернення: </td>
            <td><input type="text" name="dataReturn"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Додати" />
            </td>
        </tr>
    </table>
</form>
<table>
    <caption>Журнал бібліотеки</caption>
    <tr>
        <th>Прізвище</th>
        <th>Ім'я</th>
        <th>Книжка</th>
        <th>Інвентарний номер</th>
        <th>Дата видачі</th>
        <th>Дата повернення</th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.reader.surname}</td>
            <td>${order.reader.name}</td>
            <td>${order.copy.book.title}</td>
            <td>${order.copy.id}</td>>
            <td>${order.dataOrder}</td>
            <td>${order.dataReturn}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
