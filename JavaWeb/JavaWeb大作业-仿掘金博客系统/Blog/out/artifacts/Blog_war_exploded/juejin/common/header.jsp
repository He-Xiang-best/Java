<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="header">
    <header>
        <div class="container">
            <a href="#" class="logo">
                <img src="${pageContext.request.contextPath}/static/JueJin/imgs/logo.a7995ad.svg" alt="">
            </a>
            <nav class="main-nav">
                <ul class="nav-list">
                    <li class="main-list-nav">
                        <ul>
                            <li class="nav-item active">
                                <a href="#">首页</a>
                            </li>
                            <li class="nav-item">
                                <a href="#">沸点</a>
                            </li>
                            <li class="nav-item">
                                <a href="#">话题</a>
                            </li>
                            <li class="nav-item">
                                <a href="#">小册</a>
                            </li>
                            <li class="nav-item">
                                <a href="#">活动</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-item search">
                        <div class="search-form">
                            <input id="search" type="text" placeholder="搜索内容">
                            <img src="${pageContext.request.contextPath}/static/JueJin/imgs/juejin-search-icon.6f8ba1b.svg" alt="">
                        </div>
                    </li>
                    <li class="list-item submit" >
                        <img src="${pageContext.request.contextPath}/static/JueJin/imgs/submit-icon.53f4253.svg" alt="">
                        <span id="writeAr">写文章</span>
                    </li>

                        <c:choose>
                            <c:when test="${empty sessionScope.userInfo}">
                                <li class="list-item auth">
                                <span class="login">登录</span>
                                </li>
                                <li class="list-item auth">
                                <span class="register" >注册</span>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="list-item auth">
                              <span class="userlogin">${sessionScope.userInfo.userName}[<a href="${pageContext.request.contextPath}/admin/logout">退出</a>]</span>
                                </li>
                    <li class="list-item auth">
                                <a href="${pageContext.request.contextPath}/login"><span style="color:
                                rgb(33,137,255);">后台管理</span></a>
                    </li>
                            </c:otherwise>
                        </c:choose>

                </ul>
            </nav>
        </div>
    </header>
</div>



<div style="display: none" class="login-pop" id="signIn">
    <div class="layer">
      <button style="margin-left: 300px" id="signIn_close">
          <span class="icon-close2"></span>
      </button>
        <div class="panel">
            <h1>登录</h1>
            <div class="input-group">
                <div class="input-box">
                    <input id="userphone" class="test_login" type="text" placeholder="输入用户名" onblur="changePanda()"
                           onfocus="changePanda('https://b-gold-cdn.xitu.io/v3/static/img/greeting.1415c1c.png')">
                </div>
                <div class="input-box">
                    <input id="userpassword" class="test_login" type="password" placeholder="请输入密码" onblur="changePanda()"
                           onfocus="changePanda('https://b-gold-cdn.xitu.io/v3/static/img/blindfold.58ce423.png')">
                </div>
            </div>
            <div class="btn" id="user_in">登录</div>
            <div class="prompt-box">
                没有账号?
                <a style="float: right" href="#" id="to_register">注册</a>
                <a href="#">忘记密码</a>
            </div>
            <div class="login-way">
                <div style="text-align: center">第三方账号登录</div>
                <ul class="login-list">
                    <li>
                        <img src="${pageContext.request.contextPath}/static/JueJin/imgs/weibo.fa758eb.svg" alt="">
                    </li>
                    <li>
                        <img src="${pageContext.request.contextPath}/static/JueJin/imgs/wechat.e0ff124.svg" alt="">
                    </li>
                    <li>
                        <img src="${pageContext.request.contextPath}/static/JueJin/imgs/github.547dd8a.svg" alt="">
                    </li>
                </ul>
                <div>注册登录即表示同意 <a href="#">用户协议</a>、<a href="#">隐私政策</a></div>
            </div>
        </div>
        <div class="panda-img">
            <img src="${pageContext.request.contextPath}/static/JueJin/imgs/normal.0447fe9.png" alt="">
        </div>
    </div>
</div>



<div style="display: none" class="right login-pop" id="register">
    <div class="layer">
        <button style="float: right" id="register_close">
            <span class="icon-close2"  ></span>
        </button>
        <div class="panel">
            <div class="login">
                <div class="title">掘金 - 注册页面</div>
                <div class="slogan">一个帮助开发者成长的社区</div>
                <div class="input-group">
                    <div class="input-box">
                        <input class="test_register" id="reg_name" type="text" placeholder="用户名">
                    </div>
                    <div class="input-box">
                        <input type="text" id="reg_mail" class="test_register" placeholder="邮箱">
                    </div>
                    <div class="input-box">
                        <input type="password" id="reg_password" class="test_register" placeholder="密码">
                    </div>
                </div>
                <div class="btn" id="user_register">注册</div>
                <div class="other-way">第三方登录:
                    <img src="${pageContext.request.contextPath}/static/JueJin/imgs/weibo.fa758eb.svg" alt="">
                    <img src="${pageContext.request.contextPath}/static/JueJin/imgs/github.547dd8a.svg" alt="">
                    <img src="${pageContext.request.contextPath}/static/JueJin/imgs/wechat.e0ff124.svg" alt="">
                    <a style="float: right;color: #007fff" id="to_login" href="#">账号登入</a>
                </div>
                <div class="argen-box">
                    注册登录即表示同意<a href="#">用户协议</a>、<a href="#">隐私政策</a>
                </div>
            </div>
        </div>
    </div>

</div>

<script>

    $('#writeAr').click(function () {
        <c:choose>
        <c:when test="${empty sessionScope.userInfo}">
        javaex.tip({
            mode : "message",
            content : "登入后才能发表文章！",
            type : "error"
        });
        </c:when>
        <c:otherwise>
       window.location.href = "${pageContext.request.contextPath}/admin/jump_write";
        </c:otherwise>
        </c:choose>

    });

    $('#to_register').click(function () {
        $('#signIn').css('display', 'none');
        $('#register').removeAttr('style');
    });
    $('#to_login').click(function () {
        $('#register').css('display', 'none');
        $('#signIn').removeAttr('style');
    });

    $('#user_register').click(function () {
        var isFillInfo =true;
        $('.test_register').each(function () {
            if($(this).val()===''){
                javaex.tip({
                    mode : "message",
                    content : "请输入完整信息后再注册！",
                    type : "error"
                });
                isFillInfo=false;
               return false;
            }
        });
        if(isFillInfo){
            var path = "${pageContext.request.contextPath}"+"/user/register";
            $.ajax({
                type:"post",
                url : path,
                data:{reg_name:$('#reg_name').val(),reg_mail:$('#reg_mail').val(),reg_password:$('#reg_password').val()},
                success: function (res) {
                    if(res["type"]==='error'){
                        javaex.tip({
                            mode : "message",
                            content : res["msg"],
                            type : "error"
                        });
                    }
                    else{
                        javaex.tip({
                            content : res["msg"],
                            type : "success"
                        });
                        // 建议延迟加载
                        setTimeout(function() {
                            // 刷新页面
                            window.location.reload();
                            // 跳转页面
                        }, 1000);
                    }
                }

            });
        }

    });

    $('#user_in').click(function () {
        var isFillInfo =true;
        $('.test_login').each(function () {
            if($(this).val()===''){
                javaex.tip({
                    mode : "message",
                    content : "请输入完整信息后再登入！",
                    type : "error"
                });
                isFillInfo=false;
               return false;
            }
        });

        if(isFillInfo){
            console.log(isFillInfo)
            var path = "${pageContext.request.contextPath}"+"/user/login";
            console.log(path);
            $.ajax({
                type:"post",
                url : path,
                data:{username:$('#userphone').val(),password:$('#userpassword').val()},
                success: function (res) {
                    if(res["type"]==='error'){
                        javaex.tip({
                            mode : "message",
                            content : res["msg"],
                            type : "error"
                        });
                    }
                    else{
                        javaex.tip({
                            content : res["msg"],
                            type : "success"
                        });
                        // 建议延迟加载
                        setTimeout(function() {
                            // 刷新页面
                            window.location.reload();
                            // 跳转页面
                        }, 1000);
                    }
                }

            });


        }

    });

</script>
