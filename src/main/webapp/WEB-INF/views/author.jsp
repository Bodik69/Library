<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Authors</title>
</head>
<body>
<table>
  <tr>
    <th>Прізвище</th>
    <th>Ім'я</th>
  </tr>
  <c:forEach var="author" items="${authors}">
    <tr>
      <td>${author.firstName}</td>
      <td>${author.lastName}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
