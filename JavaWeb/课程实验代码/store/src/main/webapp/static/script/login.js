window.onload = function(){
    //1.获取图片对象
    var img = document.getElementById("verificationCode");
    //2.绑定图片单击事件
    img.onclick = function () {
        //加时间戳
        var date = new Date().getTime();
        //加时间戳，防止浏览器利用缓存
        img.src = "/store/VerificationCode?" + date;
    }
    //绑定链接点击事件
    // var ahref = document.getElementById("change");
    //
    // ahref.onclick = function () {
    //     var date = new Date().getTime();
    //     img.src = "/store/VerificationCode?" + date;
    // }
    document.getElementById("form").onsubmit = function(){
        //验证用户名
        //验证密码
        //...
        //都成功则返回true
        //
        return checkUsername() && checkPassword() ;
    }

    document.getElementById("username").onblur = checkUsername;
    document.getElementById("password").onblur = checkPassword;

}

function checkUsername(){
    var username = document.getElementById("username").value;
    var s_username = document.getElementById("s_username");
    var flag = (username!=="");
    if(flag){
        s_username.innerHTML = "<img height='15' width='15' src='/store/static/img/gou.png'>"
    }else{
        s_username.innerHTML = "<img height='15' width='15' src='/store/static/img/error.png'>用户名不能为空！";
    }
    return flag;
}

function checkPassword(){
    var password = document.getElementById("password").value;
    var s_password = document.getElementById("s_password");
    var flag = (password!=="");
    if(flag){
        s_password.innerHTML = "<img height='15' width='15' src='/store/static/img/gou.png'>"
    }else{
        s_password.innerHTML = "<img height='15' width='15' src='/store/static/img/error.png'>密码不能为空！";
    }
    return flag;
}


