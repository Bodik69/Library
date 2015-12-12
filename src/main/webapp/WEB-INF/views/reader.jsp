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
    <form method="post" action="add">
        <table>
            <tr>
                <td>Ім'я</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Прізвище</td>
                <td><input type="text" name="surname"></td>
            </tr>
            <tr>
                <td>Адреса</td>
                <td><input type="text" name="address"></td>
            </tr>
            <tr>
                <td>Телефон</td>
                <td><input type="text" name="phone"></td>
            </tr>
            <tr>
                <td>Дата народження</td>
                <td><input type="text" name="birth"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Зберегти читача" />
                </td>
            </tr>
        </table>
    </form>
    <br>
    <table border="1">
        <thead><tr style='font-weight: bold; font-size: 16pt'><td colspan='7' style='text-align: center'>Читачі</td></tr></thead>
        <tr>
            <th>Ім'я</th>
            <th>Прізвище</th>
            <th>Адреса</th>
            <th>Телефон</th>
            <th>Дата народження</th>
            <th>Дата реєстрації</th>
            <th>&nbsp;</th>
        </tr>
        <tr>
            <td>${reader.name}</td>
            <td>${reader.surname}</td>
            <td>${reader.adress}</td>
            <td>${reader.phone}</td>
            <td>${reader.birth}</td>
            <td>${reader.dateOfCreate}</td>
            <td><a href="delete/${reader.idReader}">Видалити</a></td>
        </tr>
    </table>

</body>
</html>