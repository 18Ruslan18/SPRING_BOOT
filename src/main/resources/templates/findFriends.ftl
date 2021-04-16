<html>
<head>
    <style><#include "static/css/css/styles.css"></style>
    <style><#include "static/css/css/bootstrap.min.css"></style>
    <style><#include "static/css/css/headind.css"></style>
    <style><#include "static/css/css/button.css"></style>
    <style><#include "static/css/css/title1.css"></style>
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
<center>
    <div class="form-style-2">
        <div class="header-h1 header-h1-dark">
            <h1>Поиск друзей</h1>
        </div>
        <div>
                    <form method="get" action="/findFriends" >
                        <label>
                            <input type="text" name ="filter"  placeholder="Введите имя пользователя">
                        </label>
                        <button type="submit" class="glow-button"  ml-2>Поиск</button>
                    </form>

        </div>
        <#if flag??>
            <form method="post" action="/findFriends">
            <div class="six">

                    <h1 >${user.login} ${user.firstName} ${user.lastName}</h1>

            </div>

                <button type = "submit" class="glow-button">Добавить</button>
            </form>
        </#if>
        <a href="/logout">Выход</a>
        <button>
            <img src="image/logout.png"  alt="" style="vertical-align:middle">
            <a href="/logout"></a>
        </button>
    </div>
</center>
</body>
</html>