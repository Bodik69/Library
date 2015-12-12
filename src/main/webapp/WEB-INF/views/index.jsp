<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<html>
<body>
<h2>Виберіть сутність, яку хочете переглянути</h2>
<form action="/reader" method="GET">
    <input type="submit" value="Читачі">
</form>
<form action="/book" method="GET">
    <input type="submit" value="Книжки">
</form>
<form action="/author" method="GET">
    <input type="submit" value="Автори">
</form>
</body>
</html>
