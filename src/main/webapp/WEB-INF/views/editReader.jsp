<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Редагування читача</title>
</head>
<body>
<form:form method="post" action="save/${id}" modelAttribute="reader" commandName="reader">
    <h2>Редагування читача ${editReader.name} ${editReader.surname}</h2>
    <table>
        <tr>
            <td><form:label path="name">Ім'я</form:label></td>
            <td><form:input path="name" value="${editReader.name}"/></td>
        </tr>
        <tr>
            <td><form:label path="surname">Прізвище</form:label></td>
            <td><form:input path="surname" value="${editReader.surname}"/></td>
        </tr>
        <tr>
            <td><form:label path="adress">Адреса</form:label></td>
            <td><form:input path="adress" value="${editReader.adress}"/></td>
        </tr>
        <tr>
            <td><form:label path="phone">Телефон</form:label></td>
            <td><form:input path="phone" value="${editReader.phone}"/></td>
        </tr>
        <tr>
            <td><form:label path="birth">Дата народження</form:label></td>
            <td><form:input path="birth" value="${editReader.birth}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Зберегти зміни" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
