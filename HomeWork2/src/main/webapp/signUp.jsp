<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <h1>Страница регистрации</h1>
<form action="reg" method="POST">
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