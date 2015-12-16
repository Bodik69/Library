<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="../../resources/js/jquery.min.js"></script>
    <script type = "text/javascript" src="../../resources/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../../resources/js/hideCheckBoxes.js"></script>
    <script type="text/javascript" src="../../resources/js/reader/readerFormValidation.js"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>c
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <link href="../../resources/css/reader.css" rel="stylesheet">
    <title>Редагування читача</title>
</head>
<body>
<div class="container">
    <div id="addingbox" style="margin-top:30px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Редагувати читача</div>
            </div>
            <div style="padding-top:30px" class="panel-body">
                <form:form id="addReader" action="save/${id}" method="post" modelAttribute="reader" commandName="reader" role="form">
                    <div style="margin-bottom: 5px" class="group">
                        <div class="form-group row">
                            <div class="col-md-4">
                                <form:label path="name">Ім'я: </form:label>
                            </div>
                            <div class="col-md-8">
                                <form:input class="form-control" path="name" value="${editReader.name}"/>
                            </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 5px" class="group">
                        <div class="form-group row">
                            <div class="col-md-4">
                                <form:label path="surname">Прізвище: </form:label>
                            </div>
                            <div class="col-md-8">
                                <form:input class="form-control" path="surname" value="${editReader.surname}"/>
                            </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 5px" class="group">
                        <div class="from-group row">
                            <div class="col-md-4">
                                <form:label path="adress">Адреса: </form:label>
                            </div>
                            <div class="col-md-8">
                                <form:input class="form-control" path="adress" value="${editReader.adress}"/>
                            </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 5px" class="group">
                        <div class="form-group row">
                            <div class="col-md-4">
                                <form:label path="phone">Телефон: </form:label>
                            </div>
                            <div class="col-md-8">
                                <form:input class="form-control" path="phone" value="${editReader.phone}"/>
                            </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 5px" class="group">
                        <div class="from-group row">
                            <div class="col-md-4">
                                <form:label path="birth">Дата народження: </form:label>
                            </div>
                            <div class="col-md-8">
                                <form:input class="form-control" path="birth" value="${editReader.birth}"/>
                            </div>
                        </div>
                    </div>
                    <div style="margin-top:10px" class="form-group">
                        <div class="col-sm-2" style="margin-bottom: 10px">
                            <input class="btn btn-success" type="submit" value="Зберегти зміни"/>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
