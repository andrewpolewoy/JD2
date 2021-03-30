<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Account</title>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="regbox box">
                <img class="avatar" src="img/collaboration.png">
                <h1><c:choose>
                    <c:when test="${requestScope.error}">
                        <p style="color:white;">${requestScope.message}</p>
                    </c:when>
                    <c:otherwise>
                        <p>Страница регистрации</p>
                    </c:otherwise>
                </c:choose></h1>
                <form action="signUp" method="POST">
                   <p>ФИО</p>
<input type="text" placeholder="Введите имя" name="name" required>
                   <p>Логин</p>
<input type="text" placeholder="Введите логин" name="login" required>
                   <p>Пароль</p>
<input type="password" placeholder="Введите пароль" name="password" required>
                   <p>Дата Рождения</p>
<input type="date" placeholder="Введите дату рождения" name="birth_day" required>
                   <input type="submit" value="Регистрация">
                   <a href="signIn">Есть аккаунт?</a>
                </form>

</div>
</div>
</body>
</html>