<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="../../resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../resources/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../../resources/js/order/EditOrderValidation.js"></script>
    <script src="../../resources/js/hideCheckBoxes.js"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>c
    <link href="../../resources/css/order.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Редагування журналу</title>
</head>
<body>
<c:if test="${check == false}">
    <div id="error-container" class="alert alert-danger col-md-8 col-md-offset-2">
        <span>Ви не можете взяти книгу!</span>
    </div>
    <script>showAlert();</script>
</c:if>
<c:if test="${flag == false}">
    <div id="error-container" class="alert alert-danger col-md-8 col-md-offset-2">
        <span>Інвентарний номер або користувач не знайдено!</span>
    </div>
    <script>showAlert();</script>
</c:if>
<div class="container">
    <div id="addingbox" style="margin-top:30px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Редагувати журнал</div>
            </div>
            <div style="padding-top:30px" class="panel-body">
                <form:form id="valideOrderEdit" action="saveOrder/${id}" method="post" modelAttribute="orderReader" commandName="orderReader"
                           role="form">
                    <div style="margin-bottom: 5px" class="group">
                        <div class="form-group row">
                            <div class="col-md-4">
                                <form:label path="copy.id">Інвентарний номер: </form:label>
                            </div>
                            <div class="col-md-8">
                                <form:input class="form-control" path="copy.id"/>
                            </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 5px" class="group">
                        <div class="form-group row">
                            <div class="col-md-4">
                                <form:label path="reader.idReader">Читацький номер: </form:label>
                            </div>
                            <div class="col-md-8">
                                <form:input class="form-control" path="reader.idReader"/>
                            </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 5px" class="group">
                        <div class="from-group row">
                            <div class="col-md-4">
                                <form:label path="dataOrder">Дата видачі: </form:label>
                            </div>
                            <div class="col-md-8">
                                <form:input class="form-control" path="dataOrder"/>
                            </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 5px" class="group">
                        <div class="form-group row">
                            <div class="col-md-4">
                                <form:label path="dataReturn">Дата повернення: </form:label>
                            </div>
                            <div class="col-md-8">
                                <form:input class="form-control" path="dataReturn"/>
                            </div>
                        </div>
                    </div>

                    <div style="margin-top:10px" class="form-group">
                        <div class="row">
                            <div class="col-sm-2" style="margin-bottom: 10px">
                                <input class="btn btn-success" type="submit" value="Редагувати"/>
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
