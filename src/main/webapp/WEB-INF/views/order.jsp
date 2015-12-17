<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <script src="../../resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../resources/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../../resources/js/order/orderValidation.js"></script>
    <script src="../../resources/js/hideCheckBoxes.js"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link href="../../resources/css/order.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Orders</title>
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
                <div class="panel-title">Взяти книгу: </div>
            </div>
            <div style="padding-top:30px" class="panel-body">
                <form:form id="valideOrder" method="post" action="addOrder" modelAttribute="orderReader" commandName="orderReader"
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
                                <form:label path="reader.idReader">Видавництво: </form:label>
                            </div>
                            <div class="col-md-8">
                                <form:input class="form-control" path="reader.idReader"/>
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
<form id="deleteOrders" action="order/delete" method="post">
<table class="table table-hover">
    <caption>
        <h2> Журнал бібліотеки</h2>
    </caption>
    <p>
    <tr>
        <th>Вибір</th>
        <th>Читач</th>
        <th>Книжка</th>
        <th>Інвентарний номер</th>
        <th>Дата видачі</th>
        <th>Дата повернення</th>
        <th>Дії</th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td><input type="checkbox" class="checkbox" name="idlist" value="${order.idOrder}" /></td>
            <td>${order.reader.surname} ${order.reader.name}</td>
            <td>${order.copy.book.title}</td>
            <td>${order.copy.id}</td>
            <td>${order.dataOrder}</td>
            <td>${order.dataReturn}</td>
            <c set var test="null"/>
            <c:choose>
                <c:when test="${order.dataReturn != null}">
                    <td><a href="order/delete/${order.idOrder}">Видалити</a><br>
                </c:when>
                <c:otherwise>
                    <td><a href="order/return/${order.idOrder}">Здати книгу</a><br>
                </c:otherwise>
            </c:choose>
            <a href="editOrder/${order.idOrder}">Редагувати</a></td>
        </tr>
    </c:forEach>
</table>
    <input id="deleteChecked" type="submit" value="Видалити записи"
    onclick="if (confirm('Ви дійсно бажаєте видалити ці записи?')) return true; else return false;"/>
</form>
    </div>
</body>
</html>
