<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <script src="../../resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../resources/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../../resources/js/book/formValidation.js"></script>
    <script src="../../resources/js/hideCheckBoxes.js"></script>
    <link href="../../resources/css/book.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Books</title>
</head>
<body>
<c:if test="${not empty error}">
    <div id="error-container" class="alert alert-danger">
        <span>${error}</span>
    </div>
    <script>showAlert();</script>
</c:if>
<form:form id="addBook" action="book" method="post" modelAttribute="book" commandName="book">
    <table>
        <tr class="group">
            <td><form:label path="title">Назва</form:label></td>
            <td><form:input path="title"/></td>
        </tr>
        <tr class="group">
            <td><form:label path="edition">Видавництво: </form:label></td>
            <td><form:input path="edition"/></td>
        </tr>
        <tr class="group">
            <td><form:label path="year">Рік: </form:label></td>
             <td><form:input path="year"/></td>
        </tr>
        <tr class="group">
            <td><form:label path="pages">К-ть сторінок: </form:label></td>
            <td><form:input path="pages"/></td>
        </tr>
        <tr class="group">
            <td><form:label path="copyCount">К-ть копій: </form:label></td>
            <td><form:input path="copyCount"/></td>
        </tr>
        <tr class="group">
            <td><form:label path="author.firstName">Ім'я автора: </form:label></td>
            <td><form:input path="author.firstName"/></td>
        </tr>
        <tr class="group">
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
<form id="deleteBookd" action="book/delete" method="post">
<table>
    <caption>Список книг у бібліотеці</caption>
    <tr>
        <th>-</th>
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
            <td><input type="checkbox" class="checkbox" name="idlist" value="${book.idBook}" /></td>
            <td>${book.title}</td>
            <td>${book.author.firstName} ${book.author.lastName}</td>
            <td>${book.edition}</td>
            <td>${book.year}</td>
            <td>${book.pages}</td>
            <td>${book.copyCount}</td>
            <td>
                <a id="${book.idBook}" class="addCopy" title="Додати копію книги">+</a>
                <a href="book/edit/${book.idBook}" title="Редагувати інформацію про книгу">Редагувати</a>
                <a href="book/remove/${book.idBook}" title="Вилучити книгу з бібліотеки">Вилучити</a>
            </td>
        </tr>
    </c:forEach>
</table>
    <input id="deleteChecked" type="submit" value="Submit now" />
</form>
<script>
    $(document).ready(function() {
        var clicked = null;
       $(".addCopy").click(function() {
           if($(this).text() === "-") {
               clicked.html("+");
               clicked = null;
               $(".countForm").remove();
           } else {
               if (clicked !== null) {
                   clicked.html("+");
                   $(".countForm").remove();
               }
               clicked = $(this);
               var url = "book/add/" + $(this).attr('id');
               $(this).html("-");
               $(this).after("<span class='countForm group'>"
                + "<form id='count-copy-form' action=" + url + " method='post'>"
                +       "<input type='text' name='count'><input type='submit' value='Додати'>"
                + "</form></span>");
           }
       });
    });
</script>
</body>
</html>
