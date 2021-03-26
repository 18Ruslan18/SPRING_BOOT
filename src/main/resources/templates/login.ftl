<#ftl encoding='UTF-8'>
<html>
<head>
    <style><#include "static/css/css/styles.css"></style>
    <style><#include "static/css/css/bootstrap.min.css"></style>
    <style><#include "static/css/css/headind.css"></style>
    <style>
        .wrapper {
            background-color: whitesmoke;
            list-style-type: none;
            padding: 0;
            border-radius: 3px;
        }
        .form-row {
            display: flex;
            justify-content: flex-end;
            padding: .5em;
        }
        .form-row > label {
            padding: .5em 1em .5em 0;
            flex: 1;
        }
        .form-row > input {
            flex: 2;
        }
        .form-row > input,
        .form-row > button {
            padding: .5em;
        }
        .form-row > button {
            background: gray;
            color: white;
            border: 0;
        }
        .form-row > label {
            padding: .5em 1em .5em 0;
            flex: 1;
        }
        .form-row > input {
            flex: 2;
        }
    </style>
</head>
<body>
<#if error??>
    <div class="alert alert-danger" role="alert">Логин или пароль введены неверно</div>
</#if>
<center>
<div class="form-style-2">

    <form method="post" action="/login">
        <div class="header-h1 header-h1-dark">
            <h1>Вход в мессенджер</h1>
        </div>
        <ul class="wrapper">
        <li class="form-row">
        <label for="login">Логин (email) </label>
            <input class="input-field" type="text" id="login" name="login" placeholder="Введите вашу почту">
        </li>
        <li class="form-row">
        <label for="password">Пароль </label>
            <input class="input-field" type="password" id="password" name="password" placeholder="Введите ваш пароль">
        </li>
        </ul>
        <label for="remember-me">
            <input type="checkbox" id="remember-me" name="remember-me">Запомнить меня</label>
        <input type="submit"     value="       Войти       ">
        <form>
            <input type="button" value="Зарегистрироваться" onClick='location.href="/signUp"'>
        </form>
        <div class="header-h1 header-h1-dark">
            <h1>Мессенджер</h1>
        </div>
    </form>
</div>
    </center>
</body>
</html>