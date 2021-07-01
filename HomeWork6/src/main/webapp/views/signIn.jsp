<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
 <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <title>LogIn Account</title>
           <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
 </head>
 <body>
  <div class="container">
              <div class="box">
                  <img class="avatar" src="../img/user-avatar.png">
                  <h1><c:choose>
                  <c:when test="${requestScope.error}">
                    <p style="color:black;">${requestScope.message}</p>
                      </c:when>
                           <c:otherwise>
                                 <p>Войди в свой аккаунт</p>
                  </c:otherwise>
                        </c:choose>
                  </h1>
  <form action="signIn" method="POST">
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