<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
    <form:form method="post" action="reader" modelAttribute="reader" commandName="reader">
        <table>
            <tr>
                <td><form:label path="name">Ім'я</form:label></td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td><form:label path="surname">Прізвище</form:label></td>
                <td><form:input path="surname"/></td>
            </tr>
            <tr>
                <td><form:label path="adress">Адреса</form:label></td>
                <td><form:input path="adress"/></td>
            </tr>
            <tr>
                <td><form:label path="phone">Телефон</form:label></td>
                <td><form:input path="phone"/></td>
            </tr>
            <tr>
                <td><form:label path="birth">Дата народження</form:label></td>
                <td><form:input path="birth"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Зберегти читача" />
                </td>
            </tr>
        </table>
    </form:form>
    <br>
    <table border="1">
        <thead><tr style='font-weight: bold; font-size: 16pt'><td colspan='7' style='text-align: center'>Читачі</td></tr></thead>
        <tr>
            <th>Ім'я</th>
            <th>Прізвище</th>
            <th>Адреса</th>
            <th>Телефон</th>
            <th>Дата народження</th>
            <th>Дата реєстрації</th>
            <th>Дії</th>
        </tr>

        <h2>${flag}</h2>
        <c:forEach var="reader" items="${readerList}">
        <c:choose>
            <c:when test="${flag == true && reader.idReader == readerId}">
                <tr>
                    <td><input type="text" value="${reader.name}"></td>
                    <td><input type="text" value="${reader.surname}"></td>
                    <td><input type="text" value="${reader.adress}"></td>
                    <td><input type="text" value="${reader.phone}"></td>
                    <td><input type="text" value="${reader.birth}"></td>
                    <td><input type="text" value="${reader.dateOfCreate}"></td>
                    <td><a href="delete/${reader.idReader}">Видалити</a><br>
                        <a href="save/${reader.idReader}">Зберегти</a></td>
                </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td>${reader.name}</td>
                        <td>${reader.surname}</td>
                        <td>${reader.adress}</td>
                        <td>${reader.phone}</td>
                        <td>${reader.birth}</td>
                        <td>${reader.dateOfCreate}</td>
                        <td><a href="delete/${reader.idReader}">Видалити</a><br>
                            <a href="edit/${reader.idReader}">Редагувати</a></td>
                    </tr>
                </c:otherwise>
        </c:choose>
        </c:forEach>
    </table>

</body>
</html>