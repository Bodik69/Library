<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<table>
    <caption>Список книг у бібліотеці</caption>
    <tr>
        <th>Назва</th>
        <th>Автор</th>
        <th>Видавництво</th>
        <th>Рік</th>
        <th>К-ть сторінок</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.title}</td>
            <td>${book.author.firstName} ${book.author.lastName}</td>
            <td>${book.edition}</td>
            <td>${book.year}</td>
            <td>${book.pages}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
