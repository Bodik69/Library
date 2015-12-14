<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Books</title>
</head>
<body>
<form:form action="book" method="post" modelAttribute="book" commandName="book">
    <table>
        <tr>
            <td><form:label path="title">Назва</form:label></td>
            <td><form:input path="title"/></td>
        </tr>
        <tr>
            <td><form:label path="edition">Видавництво: </form:label></td>
            <td><form:input path="edition"/></td>
        </tr>
        <tr>
            <td><form:label path="year">Рік: </form:label></td>
             <td><form:input path="year"/></td>
        </tr>
        <tr>
            <td><form:label path="pages">К-ть сторінок: </form:label></td>
            <td><form:input path="pages"/></td>
        </tr>
        <tr>
            <td><form:label path="copyCount">К-ть копій: </form:label></td>
            <td><form:input path="copyCount"/></td>
        </tr>
        <tr>
            <td><form:label path="author.firstName">Ім'я автора: </form:label></td>
            <td><form:input path="author.firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="author.lastName">Прізвище автора: </form:label></td>
            <td><form:input path="author.lastName"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Додати"/>
            </td>
        </tr>
    </table>
</form:form>
<table>
    <caption>Список книг у бібліотеці</caption>
    <tr>
        <th>Назва</th>
        <th>Автор</th>
        <th>Видавництво</th>
        <th>Рік</th>
        <th>К-ть сторінок</th>
        <th>К-ть копій</th>
        <th>Операції</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.title}</td>
            <td>${book.author.firstName} ${book.author.lastName}</td>
            <td>${book.edition}</td>
            <td>${book.year}</td>
            <td>${book.pages}</td>
            <td>${book.copyCount}</td>
            <td>
                <a href="book/add/${book.idBook}" title="Додати копію книги">+</a>
                <a href="book/edit/${book.idBook}" title="Редагувати інформацію про книгу">Редагувати</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
