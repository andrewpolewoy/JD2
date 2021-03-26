<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="by.it_academy.jd2.core.dto.User"%>
<html>
 <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <title>LogIn Account</title>
           <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
 </head>
 <body>
  <div class="container">
              <div class="box">
                  <img class="avatar" src="img/user-avatar.png">
                  <h1>Войди в свой аккаунт</h1>

  <form action="login" method="post">
                     <p>Логин</p>
  <input type="text" placeholder="Логин" name="login" required>
                     <p>Пароль</p>
  <input type="password" placeholder="Пароль" name="password" required>
                     <input type="submit" value="Войти">
                     <a href="signUp">Создать нового пользователя</a>
                  </form>
  </div>
  </div>
  </body>
  </html>