<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="../../resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../resources/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../../resources/js/hideCheckBoxes.js"></script>
    <script type="text/javascript" src="../../resources/js/reader/readerFormValidation.js"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <link href="../../resources/css/reader.css" rel="stylesheet">
    <title>Менеджер читачів</title>
</head>
<body>
<c:if test="${exist == true}">
    <div id="error-container" class="alert alert-danger col-md-8 col-md-offset-2">
        <span>Такий читач вже зареєстрований в бібіліотеці!</span>
    </div>
    <script>showAlert();</script>
</c:if>
<c:if test="${canDelete == false}">
    <div id="error-container" class="alert alert-danger col-md-8 col-md-offset-2">
        <span>Деяких читачів неможливо видалити, бо вони ще не здали всі книги!</span>
    </div>
    <script>showAlert();</script>
</c:if>

<div class="container">
    <div id="addingbox" style="margin-top:30px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Додати читача</div>
            </div>
            <div style="padding-top:30px" class="panel-body">
                <form:form id="addReader" action="add" method="post" modelAttribute="reader" commandName="reader" role="form">
                    <div style="margin-bottom: 5px" class="group">
                        <div class="form-group row">
                            <div class="col-md-4">
                                <form:label path="name">Ім'я: </form:label>
                            </div>
                            <div class="col-md-8">
                                <form:input class="form-control" path="name"/>
                            </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 5px" class="group">
                        <div class="form-group row">
                            <div class="col-md-4">
                                <form:label path="surname">Прізвище: </form:label>
                            </div>
                            <div class="col-md-8">
                                <form:input class="form-control" path="surname"/>
                            </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 5px" class="group">
                        <div class="from-group row">
                            <div class="col-md-4">
                                <form:label path="adress">Адреса: </form:label>
                            </div>
                            <div class="col-md-8">
                                <form:input class="form-control" path="adress"/>
                            </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 5px" class="group">
                        <div class="form-group row">
                            <div class="col-md-4">
                                <form:label path="phone">Телефон: </form:label>
                            </div>
                            <div class="col-md-8">
                                <form:input class="form-control" path="phone"/>
                            </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 5px" class="group">
                        <div class="from-group row">
                            <div class="col-md-4">
                                <form:label path="birth">Дата народження: </form:label>
                            </div>
                            <div class="col-md-8">
                                <form:input class="form-control" path="birth"/>
                            </div>
                        </div>
                    </div>
                    <div style="margin-top:10px" class="form-group">
                        <div class="col-sm-2" style="margin-bottom: 10px">
                            <input class="btn btn-success" type="submit" value="Додати читача"/>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<div class="list-books col-md-10 col-md-offset-1" style="margin-bottom: 30px; margin-top: 15px">
    <form id="deleteReaders" action="reader/delete" method="post">
        <table class="table table-hover">
            <caption>Читачі бібліотеки</caption>
            <tr>
                <th>Вибір</th>
                <th>Номер</th>
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
                    <td><input type="checkbox" class="checkbox" name="idlist" value="${reader.idReader}"/></td>
                    <td>${reader.idReader}</td>
                    <td>${reader.name}</td>
                    <td>${reader.surname}</td>
                    <td>${reader.adress}</td>
                    <td>${reader.phone}</td>
                    <td>${reader.birth}</td>
                    <td>${reader.dateOfCreate}</td>
                    <td><a href="delete/${reader.idReader}"
                           onclick="if (confirm('Ви дійсно бажаєте видалити даного читача?')) return true; else return false;">Видалити</a><br>
                        <a href="edit/${reader.idReader}">Редагувати</a></td>
                </tr>
            </c:forEach>
        </table>
        <input id="deleteChecked" type="submit" class="btn btn-warning" value="Видалити обране"
               onclick="if (confirm('Ви дійсно бажаєте видалити цих читачів?')) return true; else return false;"/>
    </form>
</div>
<div class="row">
    <div style="margin-bottom:10px;" class="col-sm-offset-5 col-sm-2 text-center">
        <a href="/" class="btn btn-primary">На головну</a>
    </div>
</div>
</body>
</html>