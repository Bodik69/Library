<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Books</title>
</head>
<body>
<form:form action="order" method="post" modelAttribute="orderReader" commandName="orderReader">
    <table>
        <tr>
            <td><form:label path="copy.id">Інвентарний номер: </form:label></td>
            <td><form:input path="copy.id"/></td>
        </tr>
        <tr>
            <td><form:label path="reader.idReader">Читацький номер: </form:label></td>
            <td><form:input path="reader.idReader"/></td>
        </tr>
        <tr>
            <td><form:label path="dataOrder">Дата видачі: </form:label></td>
            <td><form:input path="dataOrder"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Додати"/>
            </td>
        </tr>
    </table>
</form:form>
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
            <td>${order.copy.id}</td>
            <td>${order.dataOrder}</td>
            <td>${order.dataReturn}</td>
            <c set var test="null"/>
            <c:if test="${order.dataReturn == null}">
                <td><a href="order/return/${order.idOrder}">Здати книгу</a></td>
            </c:if>

        </tr>
    </c:forEach>
</table>
</body>
</html>
