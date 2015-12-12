<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Менеджер читачів</title>
</head>
<body>

    <h2>
        Менеджер читачів
    </h2>

    <table border="1">
        <thead><tr style='font-weight: bold; font-size: 16pt'><td colspan='6' style='text-align: center'>Читачі</td></tr></thead>
        <tr>
            <th>Ім'я</th>
            <th>Прізвище</th>
            <th>Адреса</th>
            <th>Телефон</th>
            <th>Дата народження</th>
            <th>Дата реєстрації</th>
        </tr>
        <tr>
            <td>${reader.name}</td>
            <td>${reader.surname}</td>
            <td>${reader.adress}</td>
            <td>${reader.phone}</td>
            <td>${reader.birth}</td>
            <td>${reader.dateOfCreate}</td>
        </tr>
    </table>

</body>
</html>