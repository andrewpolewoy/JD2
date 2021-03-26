<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>

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

    <h1>Отправь сообщение: </h1>
    <form action="mess" method="POST">
        <p>Отправить кому:</p>
     <input type="text" name="login" required>
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