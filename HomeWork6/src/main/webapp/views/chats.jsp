<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalDateTime, java.time.format.DateTimeFormatter" %>

<html>
 <head>
   <title>Сообщения</title>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                 <title>Welcome</title>
                 <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
              <link href="../css/style.css" rel="stylesheet" type="text/css"/>
 </head>
 <body>
 <div class="container">
             <div class="regbox box">
    <h3>Сообщения</h3>
    <table border="1">
                      <tr>
                            <th>Отправитель</th>
                            <th>Дата</th>
                            <th>Сообщение</th>
                       </tr>
                       <c:forEach items="${requestScope.chat}" var="message">
                           <td width="20%">${message.from}</td>
                           <td width="20%">${message.sendDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))}</td>
                           <td width="20%">${message.text}</td>
                       </tr>
                   </c:forEach>
    </table>

    <form action="message" method="GET">
                <input type="submit" value="Обратно в чат">
            </form>

    <form action="exit" method="GET">
                <input type="submit" value="Выход">
            </form>
            </div>
              </div>
 </body>
</html>