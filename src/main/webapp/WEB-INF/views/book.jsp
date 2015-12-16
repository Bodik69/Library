<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <script src="../../resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../resources/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../../resources/js/book/formValidation.js"></script>
    <script src="../../resources/js/hideCheckBoxes.js"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="../../resources/js/book/formForAddingCopies.js"></script>
    <link href="../../resources/css/book.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Books</title>
</head>
<body>
<c:if test="${not empty error}">
    <div id="error-container" class="alert alert-danger col-md-8 col-md-offset-2">
        <span>${error}</span>
    </div>
    <script>showAlert();</script>
</c:if>
<div class="container">
    <div id="addingbox" style="margin-top:30px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Додати книгу</div>
            </div>
            <div style="padding-top:30px" class="panel-body">
                <form:form id="addBook" action="book" method="post" modelAttribute="book" commandName="book"
                           role="form">
                    <div style="margin-bottom: 5px" class="group">
                        <div class="form-group row">
                            <div class="col-md-4">
                            <form:label path="title">Назва: </form:label>
                            </div>
                            <div class="col-md-8">
                            <form:input class="form-control" path="title"/>
                            </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 5px" class="group">
                        <div class="form-group row">
                            <div class="col-md-4">
                            <form:label path="edition">Видавництво: </form:label>
                                </div>
                            <div class="col-md-8">
                            <form:input class="form-control" path="edition"/>
                                </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 5px" class="group">
                        <div class="from-group row">
                            <div class="col-md-4">
                            <form:label path="year">Рік: </form:label>
                                </div>
                                <div class="col-md-8">
                            <form:input class="form-control" path="year"/>
                                    </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 5px" class="group">
                        <div class="form-group row">
                            <div class="col-md-4">
                            <form:label path="pages">К-ть сторінок: </form:label>
                                </div>
                            <div class="col-md-8">
                            <form:input class="form-control" path="pages"/>
                                </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 5px" class="group">
                        <div class="from-group row">
                            <div class="col-md-4">
                            <form:label path="copyCount">К-ть копій: </form:label>
                                </div>
                            <div class="col-md-8">
                            <form:input class="form-control" path="copyCount"/>
                                </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 5px" class="group">
                        <div class="from-group row">
                            <div class="col-md-4">
                            <form:label path="author.firstName">Ім'я автора: </form:label>
                                </div>
                            <div class="col-md-8">
                            <form:input class="form-control" path="author.firstName"/>
                                </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 5px" class="group">
                        <div class="from-group row">
                            <div class="col-md-4">
                            <form:label path="author.lastName">Прізвище автора: </form:label>
                                </div>
                            <div class="col-md-8">
                            <form:input class="form-control" path="author.lastName"/>
                                </div>
                        </div>
                    </div>
                    <div style="margin-top:10px" class="form-group">
                        <div class="col-sm-2" style="margin-bottom: 10px">
                            <input class="btn btn-success" type="submit" value="Додати"/>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<div class="list-books col-md-10 col-md-offset-1" style="margin-bottom: 30px; margin-top: 15px">
    <form id="deleteBook" action="book/delete" method="post">
        <table class="table table-hover">
            <caption>Список книг у бібліотеці</caption>
            <tr>
                <th>Вибір</th>
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
                    <td><input type="checkbox" class="checkbox" name="idlist" value="${book.idBook}"/></td>
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
        <input id="deleteChecked" class="btn-warning" type="submit" value="Видалити відмічені"/>
    </form>
</div>
</body>
</html>
