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

        .meetings {
            width: 60%;
            margin-bottom: 20px;
            padding: 10px;
            background-color: #f9f9f9;
            border: 1px solid #ddd;
            display: table;
        }
        .meetingElement{
            display: table-cell;
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
    <div>
        <h1>Пользователи</h1>
    </div>
    <div>
        <#list users as user>
            <script>
                function areYouSure(/*user*/) {
                    let youSure = confirm("Вы уверены, что хотите пользователя ${user.username}?");
                    // if(!youSure){
                    //     user.id = null;
                    // }
                }
            </script>
            <div class = "meetings">
                <div>
                    <h2>${user.id}</h2>
                </div>
                <div class="meetingElement">
                    ${user.username}
                </div>
                <div class="meetingElement">
                    ${user.email}
                </div>
                <div class="meetingElement">
                    ${user.role}
                </div>
                <div class="meetingElement">
                    <a href="/secured/edituser/${user.id}">Изменить</a>
                </div>
                <#if role == "ADMIN" && user.username != username>
                    <div class="meetingElement">
                        <form action="/secured/manageusers" method="post">
                            <button onclick="areYouSure()">Удалить</button>
                            <input name="id" hidden="hidden" value="${user.id}">
                        </form>
                    </div>
                </#if>
            </div>

        </#list>
    </div>
</div>

</div>
</body>
</html>