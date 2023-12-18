<!DOCTYPE html>
<html>
<head>
    <title>Мои встречи</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        .navbar {
            height: 100vh;
            width: 200px;
            background-color: #f1f1f1;
            float: left;
        }

        .navbar ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }

        .navbar li {
            padding: 10px;
            cursor: pointer;
        }

        .content {
            margin-left: 200px;
            padding: 20px;
        }

        .meeting {
            margin-bottom: 20px;
            padding: 10px;
            background-color: #f9f9f9;
            border: 1px solid #ddd;
        }

        .meeting h2 {
            margin-top: 0;
        }
    </style>
</head>
<body>
<div class="navbar">
    <div style="height: 5%; align-items: center">
        MEETINGS
    </div>
    <ul>
        <li><a href="/secured/user">Профиль</a></li>
        <li><a href="/secured/meetings">Ваши встречи</a></li>
        <#if role == "ADMIN">
            <li><a href="/secured/manageusers">Пользователи</a></li>
        </#if>

        <li>
            <form action="/logout" method="post">
                <button class="btn" type="submit" style="font-weight: bold">
                    Выход
                </button>
            </form>
        </li>
    </ul>
</div>
<div class="content">
    <form action="/secured/edituser/${id}" method="post">
        <div>
<#--            <label>Id</label>-->
            <label>
                <span>ID</span>
                <input name = "ID" value="${id}" readonly>
            </label>
        </div>
        <div>
            <label>
                <span>Username</span>
                <input type="text" required name="username" value="${user.username}" readonly>
            </label>
        </div>
        <div>
            <label>
                <span>Email</span>
                <input type="text" name = "email" value="${user.email}" readonly>
            </label>
        </div>
        <div>
            <label>
                <span>Username</span>
<#--            <input type="" name = "role" required value="${user.role}">-->
                <select id = "role" name = "role">
                    <option value="ADMIN">Admin</option>
                    <option value="USER">User</option>
                </select>
            </label>
        </div>
        <div>
            <button type="submit">
                <span>Сохранить</span>
            </button>
        </div>
    </form>
</div>
</body>
</html>