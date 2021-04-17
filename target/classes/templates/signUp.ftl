
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
    <div class="alert alert-danger" role="alert">Пользователь с таким логином уже есть</div>
</#if>
<#if error1??>
    <div class="alert alert-danger" role="alert">Введенные пароли не совпадают</div>
</#if>
<#if error2??>
    <div class="alert alert-danger" role="alert">Заполнены не все поля</div>
</#if>
<center>

<div class="form-style-2">

    <form method="post" action="/signUp">
        <div class="header-h1 header-h1-dark">
            <h1>Зарегистрируйтесь!</h1>
        </div>
        <ul class="wrapper">
            <li class="form-row">
        <label for="login">Логин (email)</label>
            <input class="input-field" type="text" id="login" name="login" placeholder="Введите вашу почту">
            </li>

            <li class="form-row">
        <label for="password">Пароль</label>
            <input class="input-field" type="password" id="password" name="password" placeholder="Придумайте пароль">

            </li>

            <li class="form-row">
        <label for="passwordCheck">Повторите пароль</label>
            <input class="input-field" type="password" id="passwordCheck" name="passwordCheck" placeholder="Повторите введенный пароль">

            </li>

            <li class="form-row">
        <label for="first-name">Имя</label>
            <input class="input-field"  id="first-name" name="firstName" placeholder="Введите ваше имя">
            </li>
            <li class="form-row">
        <label for="last-name">Фамилия</label>
            <input class="input-field"  id="last-name" name="lastName" placeholder="Введите вашу фамилию">
            </li>
        </ul>
        <input type="submit"     value="   Зарегистрироваться   ">
        <br>
        <br>
        <form>
            <input type="button" value="Уже зарегестрированы?" onClick='location.href="/login"'>
        </form>
        <div class="header-h1 header-h1-dark">
            <h1>Мессенджер</h1>
        </div>
    </form>
</div>
    </center>
</body>
</html>