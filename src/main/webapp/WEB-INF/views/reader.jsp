<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Менеджер читачів</title>
</head>
<body>

<h2>
    Менеджер читачів
</h2>
<form:form method="post" action="add" commandName="contact">
    <table>
    <tr>
        <td>Name</td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td>Surname</td>
        <td><form:input path="surname" /></td>
    </tr>
    <tr>
        <td>Address</td>
        <td><form:input path="adres" /></td>
    </tr>
    <tr>
        <td>Phone</td>
        <td><form:input path="phone" /></td>
    </tr>
    <tr>
        <td>Date of Birth</td>
        <td><form:input path="birth" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit"
                   value="Add reader" /></td>
    </tr>
</table>
</form:form>
<h3>Читачі</h3>
<c:if test="${!empty readerList}">
    <table style="border: 1px" class="data">
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Address</th>
            <th>Phone</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${readerList}" var="reader">
            <tr>
                <td>${reader.name}, ${reader.surname}</td>
                <td>${reader.adress}</td>
                <td>${reader.phone}</td>
                <td><a href="delete/${reader.id}">
                    Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>