<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎登录后台管理系统</title>
    <link href="/static/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="/static/js/jquery.js" type="text/javascript"></script>
    <script src="/static/js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });

        function checkInfo() {
            var username = $("#username").val();
            var password = $("#password").val();
            if (username.length > 0 && password.length >0 ) {
                $("#userForm").submit();
            } else {
                $("#tips").text("用户名或密码不能为空！");
                return;
            }
        }
    </script>

</head>

<body style="background-color:#1c77ac; background-image:url(/static/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">


<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录后台管理界面平台</span>
    <ul>
        <li><a href="#">回首页</a></li>
        <li><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
    </ul>
</div>

<div class="loginbody">

    <span class="systemlogo"></span>

    <div class="loginbox">
        <form id="userForm" action="/login/checkInfo" method="post">
            <ul>
                <li><input id="username" name="username" type="text" class="loginuser" value="${username}"
                           onclick="JavaScript:this.value=''"/></li>
                <li><input id="password" name="password" type="text" class="loginpwd" value=""
                           onclick="JavaScript:this.value=''"/></li>
                <li><input type="button" class="loginbtn" value="登录" onclick="checkInfo();"/>
                </li>
                <li><span id="tips" style="color:red">${tips}</span></li>

            </ul>
        </form>

    </div>

</div>


<div class="loginbm">版权所有 2013 .com 仅供学习交流，勿用于任何商业用途</div>
</body>
</html>

