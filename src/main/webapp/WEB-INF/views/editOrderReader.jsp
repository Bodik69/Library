<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="../../resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../resources/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../../resources/js/order/orderValidation.js"></script>
    <script src="../../resources/js/hideCheckBoxes.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Редагування журналу</title>
</head>
<body>
<form:form id="valideOrder" action="saveOrder/${id}" method="post"  modelAttribute="orderReader" commandName="orderReader">
    <h2>Редагування замовлення ${editOrderReader.reader.idReader}</h2>
    <table>
        <tr>
            <td><form:label path="copy.id">Інвентарний номер: </form:label></td>
            <td><form:input path="copy.id" value="${editOrderReader.copy.id}"/></td>
        </tr>
        <tr>
            <td><form:label path="reader.idReader">Читацький номер: </form:label></td>
            <td><form:input path="reader.idReader" value="${editOrderReader.reader.idReader}"/></td>
        </tr>
        <tr>
            <td><form:label path="dataOrder">Дата видачі: </form:label></td>
            <td><form:input path="dataOrder" value="${editOrderReader.dataOrder}"/></td>
        </tr>
        <tr>
            <td><form:label path="dataReturn">Дата повернення: </form:label></td>
            <td><form:input path="dataReturn" value="${editOrderReader.dataReturn}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Редагувати"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
