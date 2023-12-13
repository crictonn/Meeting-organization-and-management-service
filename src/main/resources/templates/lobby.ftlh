<!DOCTYPE html>
<html>
<head>
    <title>Preview страницы</title>
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
    </style>
</head>
<body>
<div class="preview-container">
    <h1>Заголовок страницы</h1>
    <p>Текст и содержимое страницы будут отображаться здесь.</p>
    <div class="button-container">
        <a href="/auth/signin" class="button">Login</a>
        <a href="/auth/signup" class="button">Signup</a>
    </div>
</div>
</body>
</html>