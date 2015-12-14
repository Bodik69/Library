<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Books</title>
</head>
<body>
<h2>
    Взяти книгу
</h2>
<form:form action="order" method="post" modelAttribute="orderReader" commandName="orderReader">
    <table border="1">
        <tr>
            <td><form:label path="copy.id">Інвентарний номер: </form:label></td>
            <td><form:input path="copy.id"/></td>
        </tr>
        <tr>
            <td><form:label path="reader.idReader">Читацький номер: </form:label></td>
            <td><form:input path="reader.idReader"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Додати"/>
            </td>
        </tr>
    </table>
</form:form>
<table border="1" cellspacing="0" cellpadding="5">
    <caption>
        <h2> Журнал бібліотеки</h2>
    </caption>
    <p>
    <tr>
        <th>Читач</th>
        <th>Книжка</th>
        <th>Інвентарний номер</th>
        <th>Дата видачі</th>
        <th>Дата повернення</th>
        <th>Дії</th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.reader.surname} ${order.reader.name}</td>
            <td>${order.copy.book.title}</td>
            <td>${order.copy.id}</td>
            <td>${order.dataOrder}</td>
            <td>${order.dataReturn}</td>
            <c set var test="null"/>
            <c:choose>
                <c:when test="${order.dataReturn != null}">
                    <td><a href="order/delete/${order.idOrder}">Видалити</a></td>
                </c:when>
                <c:otherwise>
                    <td><a href="order/return/${order.idOrder}">Здати книгу</a></td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
</table>
</body>
</html>
