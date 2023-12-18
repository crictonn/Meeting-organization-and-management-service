<!DOCTYPE html>
<html>
<head>
    <title>Лобби встреч</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }
        h1 {
            font-size: 24px;
        }
        p {
            font-size: 16px;
            line-height: 1.5;
        }
        .preview-container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #f7f7f7;
            border: 1px solid #e1e1e1;
            padding: 20px;
        }
        .button-container {
            margin-top: 20px;
            display:table;
            width: 80%;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            font-size: 16px;
            
        }
        .test{
            display: table-cell;
            justify-content: center;	/* horizontal, when using flex-direction: row; */
            align-items: center; 
        }
    </style>
</head>
<body>
<div class="preview-container">
    <h1>Сервис управления встречами</h1>
    <p>Здравствуйте! Пожалуйста, зарегистрируйтесь или войдите в аккаунт</p>
    <div class="button-container">
        <div class = "test">
            <a href="/auth/signin" class="button">Вход</a>
        </div>
        <div class = "test">
            <a href="/auth/signup" class="button">Регистрация</a>
        </div>
    </div>
</div>
</body>
</html>