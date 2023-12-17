<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />

<style>
    @import url(//fonts.googleapis.com/css?family=Montserrat:300,400,500);
    .bform {
        font-family: "Montserrat", sans-serif;
        color: #8d97ad;
        font-weight: 300;
        overflow: hidden;
        position: relative;
    }

    .bform h1,
    .bform h2,
    .bform h3,
    .bform h4,
    .bform h5,
    .bform h6 {
        color: #3e4555;
    }


    .bform a {
        text-decoration: none;
    }

    .bform .btn-danger-gradiant {
        background: #ff4d7e;
        background: -webkit-linear-gradient(legacy-direction(to right), #ff4d7e 0%, #ff6a5b 100%);
        background: -webkit-gradient(linear, left top, right top, from(#ff4d7e), to(#ff6a5b));
        background: -webkit-linear-gradient(left, #ff4d7e 0%, #ff6a5b 100%);
        background: -o-linear-gradient(left, #ff4d7e 0%, #ff6a5b 100%);
        background: linear-gradient(to right, #ff4d7e 0%, #ff6a5b 100%);
    }

    .bform .btn-danger-gradiant:hover {
        background: #ff6a5b;
        background: -webkit-linear-gradient(legacy-direction(to right), #ff6a5b 0%, #ff4d7e 100%);
        background: -webkit-gradient(linear, left top, right top, from(#ff6a5b), to(#ff4d7e));
        background: -webkit-linear-gradient(left, #ff6a5b 0%, #ff4d7e 100%);
        background: -o-linear-gradient(left, #ff6a5b 0%, #ff4d7e 100%);
        background: linear-gradient(to right, #ff6a5b 0%, #ff4d7e 100%);
    }

    .bform .btn-md {
        padding: 15px 45px;
        font-size: 16px;
    }


    .bform .text-danger {
        color: #ff4d7e !important;
    }


    @media (max-width: 1023px) {
        .bform .contact-form {
            padding-left: 0;
            padding-right: 0;
        }
    }

    @media (max-width: 767px) {
        .bform .contact-form {
            padding-left: 15px;
            padding-right: 15px;
        }
    }


</style>

<div class="bform py-5">
    <!-- Row -->
    <div class="row">
        <div class="container">
            <div class="col-lg-6 align-justify-center pr-4 pl-0 contact-form">
                <div class="">
                    <h2 class="mb-3 font-weight-light">Регистрация</h2>
                    <form class="mt-3">
                        <div class="row">
<#--                            <script type="application/json" src = /js/signup.js></script>-->
<#--                            <script type="application/json" src = /js/handle.js></script>-->
<#--                            <script src = "/js/signup.js" type="application/json"></script>-->
<#--                            <script type="application/javascript" src ="/js/signup.js">-->
<#--                            </script>-->
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <input class="form-control" type="text" placeholder="Имя пользователя"
                                           onchange="">
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <input class="form-control" type="email" placeholder="Email">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <input class="form-control" type="password" placeholder="Пароль">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <input class="form-control" type="password" placeholder="Подтвердите пароль">
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <script src = "/js/handle.js" type="application/json"></script>
                                <button type="submit" class="btn btn-md btn-block btn-danger-gradiant text-white border-0"
                                onclick="handle()">
                                    <span>Зарегистрироваться</span></button>
                            </div>
                        </div>
                    </form>
                    <div class="row">
                        <div class="col-lg-12 text-center mt-4">
                            Уже есть аккаунт? <a href="/auth/signin" class="text-danger">Войдите</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
