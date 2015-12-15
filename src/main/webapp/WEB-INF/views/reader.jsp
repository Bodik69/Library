<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="../../resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../resources/js/hideCheckBoxes.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Менеджер читачів</title>
</head>
<body>

    <h2>
        Менеджер читачів
    </h2>
    <form:form method="post" action="add" modelAttribute="reader" commandName="reader">
        <table>
            <tr>
                <td><form:label path="name">Ім'я</form:label></td>
                <td><form:input path="name" /></td>
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
    <c:if test="${exist == true}">
        <h3 style="color: red;">Такий читач вже зареєстрований в бібіліотеці!</h3>
    </c:if>
    <br>
    <form id="deleteReaders" action="reader/delete" method="post">
    <table border="1">
        <thead><tr style='font-weight: bold; font-size: 16pt'><td colspan='8' style='text-align: center'>Читачі бібліотеки</td></tr></thead>
        <tr>
            <th>Вибір</th>
            <th>Ім'я</th>
            <th>Прізвище</th>
            <th>Адреса</th>
            <th>Телефон</th>
            <th>Дата народження</th>
            <th>Дата реєстрації</th>
            <th>Дії</th>
        </tr>

        <c:forEach var="reader" items="${readerList}">
            <tr>
                <td><input type="checkbox" class="checkbox" name="idlist" value="${reader.idReader}" /></td>
                <td>${reader.name}</td>
                <td>${reader.surname}</td>
                <td>${reader.adress}</td>
                <td>${reader.phone}</td>
                <td>${reader.birth}</td>
                <td>${reader.dateOfCreate}</td>
                <td><a href="delete/${reader.idReader}" onclick="if (confirm('Ви дійсно бажаєте видалити даного читача?')) return true; else return false;">Видалити</a><br>
                <a href="edit/${reader.idReader}">Редагувати</a></td>
            </tr>
        </c:forEach>
    </table>
    <input id="deleteChecked" type="submit" value="Видалити обране" />
    </form>
</body>
</html>