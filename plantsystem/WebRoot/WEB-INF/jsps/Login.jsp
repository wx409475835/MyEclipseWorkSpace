<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>南阳理工学院后勤管理系统</title>
    <link href="css/learun-login.css" rel="stylesheet" />
    <link href="css/font-awesome.min.css" rel="stylesheet" />
    <link href="css/selectpick.css" rel="stylesheet" />
    <link href="css/style.css" rel="stylesheet" />
    <link rel="icon" href="/Content/images/favicon1.ico">
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="js/jquery.md5.js"></script>
    <script src="js/jquery.cookie.js"></script>
    <script src="js/dialog.js"></script>
    <script src="js/validator.js"></script>
    <script src="js/tipso.min.js"></script>
    <script>
        var contentPath = '/'.substr(0, '/'.length - 1);
        var isIE = !!window.ActiveXObject;
        var isIE6 = isIE && !window.XMLHttpRequest;
        if (isIE6) {
            window.location.href = contentPath + "/Error/ErrorBrowser";
        }
        //回车键
        document.onkeydown = function (e) {
            if (!e) e = window.event;
            if ((e.keyCode || e.which) == 13) {
                var btlogin = document.getElementById("btnlogin");
                btnlogin.click();
            }
        }
        $(function () {
            initialPage();
            $(window).resize(function (e) {
                window.setTimeout(initialPage, 200);
                e.stopPropagation();
            });
            initialControl();

            //var url = "/rsp/site/shouye/index";
            //window.location.href = url;

        });

        function initialPage() {
            var wHeight = $(window).height();
            var wWidth = $(window).width();
            var topHeight = (wHeight - 524) / 2;
            var leftWidth = (wWidth - 1024) / 2;
            $(".lr-login-top").css("margin-top", (topHeight - 56) + "px");
            $(".menu").css("top", (topHeight + 50) + "px");
            $(".lr-bg-left").width(leftWidth);
            $(".lr-bg-right").width(leftWidth);
        }

        function initialControl() {
            //错误提示
            if (top.$.cookie('learun_login_error') != null) {
                switch (top.$.cookie('learun_login_error')) {
                    case "Overdue":
                        formMessage('登录已超时,请重新登录');
                        break;
                    case "OnLine":
                        formMessage('您的帐号已在其它地方登录,请重新登录');
                        break;
                    case "noCache":
                        formMessage('缓存过期,请重新登录');
                        break;
                    case "-1":
                        formMessage('未知错误,请重新登录');
                        break;
                    default:
                        break;
                }
                top.$.cookie('learun_login_error', '', { path: "/", expires: -1 });
            }
            //是否自动登录
            if (top.$.cookie('learn_autologin') == 1) {
                $("#autologin").attr("checked", 'true');
                $("#username").val(top.$.cookie('learn_username'));
                $("#password").val(top.$.cookie('learn_password'));
                CheckLogin(1);
            }
            //设置下次自动登录
            $("#autologin").click(function () {
                if (!$(this).attr('checked')) {
                    $(this).attr("checked", 'true');
                    top.$.cookie('learn_autologin', 1, { path: "/", expires: 7 });
                } else {
                    $(this).removeAttr("checked");
                    top.$.cookie('learn_autologin', '', { path: "/", expires: -1 });
                    top.$.cookie('learn_username', '', { path: "/", expires: -1 });
                    top.$.cookie('learn_password', '', { path: "/", expires: -1 });
                }
            });
            //主题风格
            var learn_UItheme = top.$.cookie('learn_UItheme');
            if (learn_UItheme) {
                $("#UItheme").val(learn_UItheme);
            }
            //登录按钮事件
            $("#btnlogin").click(function () {
                var $username = $("#username");
                var $password = $("#password");
                var $verifycode = $("#verifycode");
                if ($username.val() == "") {
                    $username.focus();
                    formMessage('请输入账户或手机号或邮箱。');
                    return false;
                }
                if ($password.val() == "") {
                    $password.focus();
                    formMessage('请输入密码。');
                    return false;
                }
                if ($verifycode.val() == "") {
                    $verifycode.focus();
                    formMessage('请输入验证码。');
                    return false;
                }
                //if($username.val()!=""  &&  $password.val()!=""  &&  $verifycode.val()!="" )
                //    
                //}

                CheckLogin(0);



            });
            //点击切换验证码
            $("#login_verifycode").click(function () {
                $("#verifycode").val('');
                $("#login_verifycode").attr("src", contentPath + "/Login/VerifyCode?time=" + Math.random());
            });
            //切换注册表单
            $("#a_register").click(function () {
                $("#lr-login-form").hide();
                $("#lr-register-form").show();
                $("#register_verifycode").attr("src", contentPath + "/Login/VerifyCode?time=" + Math.random());
            });
            //切换登录表单
            $("#a_login").click(function () {
                $("#lr-login-form").show();
                $("#lr-register-form").hide();
                $("#login_verifycode").attr("src", contentPath + "/Login/VerifyCode?time=" + Math.random());
            });
        }

        //登录验证
        function CheckLogin(autologin) {
            $("#btnlogin").addClass('active').attr('disabled', 'disabled').text("正在校验中...");
            $("#btnlogin").find('span').hide();
           

            var username = $.trim($("#username").val());
            var password1 = $.trim($("#password").val());
            var psw = "";

            //alert(password1);
            //var verifycode = $.trim($("#verifycode").val());
            var verifycode = "";

            if (top.$.cookie('learn_password') == "" || top.$.cookie('learn_password') == null || autologin == 0) {
                psw = $.md5(password1);
            }
            if (autologin == 0) {
                psw = $.md5(password1);
            }

            //alert(psw);

            $.ajax({
                url: contentPath + "/Login/CheckLogin",
                data: { username: $.trim(username), password: $.trim(psw), verifycode: verifycode, autologin: autologin,pw:password1 },
                type: "post",
                dataType: "json",
                success: function (data) {
                    if (data.type == 1) {
                        if (top.$.cookie('learn_autologin') == 1) {
                            top.$.cookie('learn_username', $.trim(username), { path: "/", expires: 7 });
                            top.$.cookie('learn_password', $.trim(password), { path: "/", expires: 7 });
                        }
                        top.$.cookie('learn_UItheme', $("#UItheme").val(), { path: "/", expires: 30 });
                        var theme = 4;
                        if (theme == 1) {
                            window.location.href = contentPath + '/fwdt/dtqt/home';
                        }
                        else if (theme == 2) {
                            window.location.href = contentPath + '/fwdt/dtqt/home';
                        }
                        else if (theme == 3) {
                            window.location.href = contentPath + '/fwdt/dtqt/home';
                        }
                        else if (theme == 4) {
                            window.location.href = contentPath + '/fwdt/dtqt/home';
                        }
                    } else {
                        if (data.message.length >= 30) {
                            dialogAlert(data.message, 0);
                        } else {
                            formMessage(data.message);
                        }
                        $("#btnlogin").removeClass('active').removeAttr('disabled').text("登录");
                        $("#btnlogin").find('span').show();
                        $("#login_verifycode").trigger("click");
                    }
                }
            });
        }

        //提示信息
        function formMessage(msg, type) {
            $('.login_tips').remove();
            $('.login_tips-succeed').remove();
            var _class = "login_tips";
            if (type == 1) {
                _class = "login_tips-succeed";
            }
            dialogAlert(msg,type);

            //$('.lr-input-form').prepend('<div class="' + _class + '"><i class="fa fa-question-circle"></i>' + msg + '</div>');
        }

        function formMessageRemove() {
            $('.login_tips').remove();
            $('.login_tips-succeed').remove();
        }

        function dialogAlert(msg, type) {
            if (type == -1) {
                type = 2;
            }
            top.layer.alert(msg, {
                icon: type,
                title: "提示"
            });
        }

        /*=========注册账户（begin）================================================================*/
        $(function () {
            //手机号离开事件
            $("#txt_register_account").blur(function () {
                if ($(this).val() != "" && !isMobile($(this).val())) {
                    $(this).focus();
                    formMessage('手机格式不正确,请输入正确格式的手机号码。');
                } else {
                    formMessageRemove();
                }

                function isMobile(obj) {
                    reg = /^(\+\d{2,3}\-)?\d{11}$/;
                    if (!reg.test(obj)) {
                        return false;
                    } else {
                        return true;
                    }
                }
            });
            //密码输入事件
            $("#txt_register_password").keyup(function () {
                $(".passlevel").find('em').removeClass('bar');
                var length = $(this).val().length;
                if (length <= 8) {
                    $(".passlevel").find('em:eq(0)').addClass('bar');
                } else if (length > 8 && length <= 12) {
                    $(".passlevel").find('em:eq(0)').addClass('bar');
                    $(".passlevel").find('em:eq(1)').addClass('bar');
                } else if (length > 12) {
                    $(".passlevel").find('em').addClass('bar');
                }
            })
            //注册按钮事件
            $("#btnregister").click(function () {
                var $account = $("#txt_register_account");
                var $code = $("#txt_register_code");
                var $name = $("#txt_register_name");
                var $password = $("#txt_register_password");
                var $verifycode = $("#txt_register_verifycode");
                if ($account.val() == "") {
                    $account.focus();
                    formMessage('请输入手机号。');
                    return false;
                } else if ($code.val() == "") {
                    $code.focus();
                    formMessage('请输入短信验证码。');
                    return false;
                } else if ($name.val() == "") {
                    $name.focus();
                    formMessage('请输入姓名。');
                    return false;
                } else if ($password.val() == "") {
                    $password.focus();
                    formMessage('请输入密码。');
                    return false;
                } else if ($verifycode.val() == "") {
                    $verifycode.focus();
                    formMessage('请输入图片验证码。');
                    return false;
                } else {
                    $("#btnregister").addClass('active').attr('disabled', 'disabled');
                    $("#btnregister").find('span').hide();
                    $.ajax({
                        url: contentPath + "/Login/Register",
                        data: { mobileCode: $account.val(), securityCode: $code.val(), fullName: $name.val(), password: $.md5($password.val()), verifycode: $verifycode.val() },
                        type: "post",
                        dataType: "json",
                        success: function (data) {
                            if (data.type == 1) {
                                alert('注册成功');
                                window.location.href = contentPath + '/Login/Index';
                            } else {
                                formMessage(data.message);
                                $("#btnregister").removeClass('active').removeAttr('disabled');
                                $("#btnregister").find('span').show();
                                $("#register_verifycode").trigger("click");
                            }
                        }
                    });
                }
            })
            //获取验证码
            $("#register_getcode").click(function () {
                var $this = $(this);
                $this.attr('disabled', 'disabled');
                $.ajax({
                    url: contentPath + "/Login/GetSecurityCode",
                    data: { mobileCode: $("#txt_register_account").val() },
                    type: "get",
                    dataType: "json",
                    async: false,
                    success: function (data) {
                        if (data.type == 1) {
                            formMessage('已向您的手机' + $("#txt_register_account").val() + '发送了一条验证短信。', 1);
                        } else {
                            $this.removeAttr('disabled');
                            alert(data.message);
                        }
                    }
                });
            });

            $(".menu .item").hover(function () {
                $(this).find('.popover').show();
            }, function () {
                $(this).find('.popover').hide();
            });
        });
        /*=========注册账户（end）================================================================*/
    </script>
</head>
<body class="login">


    <img class="login-bg" src="picture/login-bg1.jpg" alt="">
    <div class="login-content">
        <div class="login-logo">


            <img src="picture/logo2.png"  width="280"   />
            <p>后勤数字化管理平台 <br><i></i></p>
        </div>
        <div class="login-form">
            <form action="LoginAction.do" method="post" id="commentForm">
                <div class="form-box-error popup">
                    <span></span>
                </div>
                <div class="form-box">
                    <div class="form-clo">
                        <label><img src="picture/icon-user.png" alt=""></label>
                        <input type="text" name="username" id="username" placeholder="学号/工号/帐号">
                    </div>
                    <div class="form-clo">
                        <label><img src="picture/icon-mm.png" alt=""></label>
                        <input type="password" name="password" id="password" placeholder="身份证号后6位/密码">
                    </div>
                    <div class="form-clo form-clo-yzm">
                        

                    </div>
                </div>
                <div class="form-an">
                    <label for="zddl"><input id="zddl" type="checkbox">自动登录</label>
                    <a href="">忘记密码？</a>
                </div>
                <div class="form-box-btn">
                    <button type="submit">登录</button>
                </div>
                
            </form>
        </div>
        <div class="clear"></div>
    </div>
</body>

</html>
