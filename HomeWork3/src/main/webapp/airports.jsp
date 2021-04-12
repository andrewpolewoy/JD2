<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
                    <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>AIRPORTS</title>
    </head>
    <body>
        <table border="3", align="center">
        <caption>Все аэропорты</caption>
          <tr>
            <th>Код</th>
            <th>Название</th>
            <th>Город</th>
            <th>Координаты</th>
            <th>Временная зона</th>
          </tr>
            <c:forEach items="${airports}" var="airport">
                <tr>
                    <td><c:out value="${airport.airport_code}" /></td>
                    <td><c:out value="${airport.airport_name}" /></td>
                    <td><c:out value="${airport.city}" /></td>
                    <td><c:out value="${airport.coordinates}" /></td>
                    <td><c:out value="${airport.timezone}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>