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
    <script type="text/javascript" src="../../resources/js/book/formValidation.js"></script>
    <script src="../../resources/js/hideCheckBoxes.js"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="../../resources/js/book/formForAddingCopies.js"></script>
    <link href="../../resources/css/book.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Edit Book</title>
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
                <div class="panel-title">Редагувати</div>
            </div>
            <div style="padding-top:30px" class="panel-body">
                <form:form id="addBook" action="/book/edit/${book.idBook}" method="post" modelAttribute="book" commandName="book"
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
                        <div class="row">
                            <div class="col-sm-2" style="margin-bottom: 10px">
                                <input class="btn btn-success" type="submit" value="Редагувати"/>
                            </div>
                            <div class="col-sm-offset-2 col-sm-2">
                                <a href="/book" class="btn btn-primary">Повернутися</a>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
