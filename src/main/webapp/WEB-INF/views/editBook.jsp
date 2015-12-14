<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
<form:form action="/book/edit/${book.idBook}" method="post" modelAttribute="book" commandName="book">
    <table>
        <caption>Редагувати</caption>
        <tr>
            <td><form:label path="title">Назва</form:label></td>
            <td><form:input path="title" value="${book.title}"/></td>
        </tr>
        <tr>
            <td><form:label path="edition">Видавництво: </form:label></td>
            <td><form:input path="edition" value="${book.edition}"/></td>
        </tr>
        <tr>
            <td><form:label path="year">Рік: </form:label></td>
            <td><form:input path="year" value="${book.year}"/></td>
        </tr>
        <tr>
            <td><form:label path="pages">К-ть сторінок: </form:label></td>
            <td><form:input path="pages" value="${book.pages}"/></td>
        </tr>
        <%--<tr>
            <td><form:label path="copyCount">К-ть копій: </form:label></td>
            <td><form:input path="copyCount" value="${book.copyCount}"/></td>
        </tr>--%>
        <tr>
            <td><form:label path="author.firstName">Ім'я автора: </form:label></td>
            <td><form:input path="author.firstName" value="${book.author.firstName}"/></td>
        </tr>
        <tr>
            <td><form:label path="author.lastName">Прізвище автора: </form:label></td>
            <td><form:input path="author.lastName" value="${book.author.lastName}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Зберегти"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
