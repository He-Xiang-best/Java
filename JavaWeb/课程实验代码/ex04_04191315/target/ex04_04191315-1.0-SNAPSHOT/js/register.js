window.onload = function(){
    document.getElementById("form").onsubmit = function(){
        //验证用户名
        //验证密码
        //...
        //都成功则返回true
        //
        return checkUsername() && checkPassword() && checkConfirmpassword && checkEmail() && checkTelphone();
    }

    document.getElementById("username").onblur = checkUsername;
    document.getElementById("password").onblur = checkPassword;
    document.getElementById("confirmpassword").onblur = checkConfirmpassword;
    document.getElementById("email").onblur = checkEmail;
    document.getElementById("tel").onblur = checkTelphone;
}

function checkUsername(){
    var username = document.getElementById("username").value;
    var reg_username =/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{1,12}$/;
    var flag = reg_username.test(username);
    var s_username = document.getElementById("s_username");
    if(flag){
        s_username.innerHTML = "<img height='15' width='15' src='../img/gou.png'>"
    }else{
        s_username.innerHTML = "<img height='15' width='15' src='../img/error.png'>用户名要求只能为英文字母+数字";
    }
    return flag;
}

function checkPassword(){
    var password = document.getElementById("password").value;
    // var reg_password = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,}$/;
    var reg_password = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
    var flag = reg_password.test(password);
    var s_password = document.getElementById("s_password");
    if(flag){
        s_password.innerHTML = "<img height='15' width='15' src='../img/gou.png'>"
    }else{
        s_password.innerHTML = "<img height='15' width='15' src='../img/error.png'>密码需8位以上且有大小写和特殊字符";
    }
    return flag;
}

function checkConfirmpassword(){
    var inputPassword = document.getElementById("confirmpassword").value;
    var password = document.getElementById("password").value;
    if(password===inputPassword){
        s_comfirmpassword.innerHTML = "<img height='15' width='15' src='../img/gou.png'>"
    }else{
        s_comfirmpassword.innerHTML = "<img height='15' width='15' src='../img/error.png'>两次密码输入不一致！";
    }
    return password===inputPassword;
}


//校验Email
function checkEmail(){
    //1.获取Email的值
    var email = document.getElementById("email").value;
    //2.定义正则表达式
    var reg_email = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
    //3.判断值是否符合正则的规则
    var flag = reg_email.test(email);
    //4.提示信息
    var s_email = document.getElementById("s_email");

    if(flag){
        //提示绿色对勾
        s_email.innerHTML = "<img width='15' height='15' src='../img/gou.png'>";
    }else{
        //提示红色错误信息
        s_email.innerHTML = "<img height='15' width='15' src='../img/error.png'>请填写正确的邮箱格式";
    }
    return flag;
}

//校验手机号
function checkTelphone(){
    //1.获取手机号的值
    var telphone = document.getElementById("tel").value;
    //2.定义正则表达式
    var reg_telphone = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    //3.判断值是否符合正则的规则
    var flag = reg_telphone.test(telphone);
    //4.提示信息
    var s_telphone = document.getElementById("s_telphone");

    if(flag){
        //提示绿色对勾
        s_telphone.innerHTML = "<img width='15' height='15' src='../img/gou.png'>";
    }else{
        //提示红色错误信息
        s_telphone.innerHTML = "<img height='15' width='15' src='../img/error.png'>请输入11位有效手机号";
    }
    return flag;
}