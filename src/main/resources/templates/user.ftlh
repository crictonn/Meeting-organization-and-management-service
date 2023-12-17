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
    <ul>
        <li>Мои встречи</li>
        <li>Настройки</li>
        <li>Выход</li>
    </ul>
</div>

<div class="content">
    <h1>Мои встречи</h1>

    <div class="meeting">
        <h2>Встреча 1</h2>
        <p>Описание встречи 1</p>
    </div>

    <div class="meeting">
        <h2>Встреча 2</h2>
        <p>Описание встречи 2</p>
    </div>

    <div class="meeting">
        <h2>Встреча 3</h2>
        <p>Описание встречи 3</p>
    </div>

    <!-- Добавьте здесь дополнительные встречи, связанные с текущим пользователем -->
</div>
</body>
</html>