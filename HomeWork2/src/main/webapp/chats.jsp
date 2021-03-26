<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*, by.it_academy.jd2.core.dto.UserInMessenger, jakarta.servlet.http.*, by.it_academy.jd2.web.servlets.MessengerServlet" %>

<html>
 <head>
   <title>Сообщения</title>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                 <title>Welcome</title>
                 <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
              <link href="css/style.css" rel="stylesheet" type="text/css"/>
 </head>
 <body>
 <div class="container">
             <div class="regbox box">
    <h3>Сообщения</h3>

    <% ArrayList<String> messages = UserInMessenger.usersInMessenger.get(session.getAttribute("login")).getMessage(); %>

    <%= "Сообщение от " + session.getAttribute("login") + ":" %>

    <br>

    <%
    for(int i = 0; i < messages.size(); i++) {
        out.println(messages.get(i)); %>
        <br/>
    <%  }
    %>

    <br/>

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