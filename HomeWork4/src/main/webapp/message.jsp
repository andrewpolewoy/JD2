<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
 <head>
   <title>Messenger</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
              <title>Welcome</title>
              <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
           <link href="css/style.css" rel="stylesheet" type="text/css"/>
 </head>
 <body>
       <div class="container">
            <div class="regboxx box">
                <img class="avatar" src="img/collaboration.png">
    <h1><c:choose>
      <c:when test="${requestScope.error}">
          <p style="color:white;">${requestScope.message}</p>
      </c:when>
      <c:otherwise>
          <p>Отправь сообщение:</p>
      </c:otherwise>
                    </c:choose></h1>
    <form action="message" method="POST">
        <p>Отправить кому:</p>
     <input type="text" name="recipient" required>
        <p>Сообщение:</p>
     <input type="textarea" name="message" required>
     <input type="submit" value="Отправить">
    </form>
        <br>
        <br>
    <form action="chats" method="GET">
        <input type="submit" value="Мои сообщения">
    </form>
    <br>
    <form action="exit" method="GET">
            <input type="submit" value="Выход">
        </form>
        </div>
          </div>
 </body>
</html>