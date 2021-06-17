window.onload = function(){


    document.getElementById("form").onsubmit = function(){
        return checkUsername();
    }

    document.getElementById("username").onblur = checkUsername;

}

function checkUsername(){
    var username = document.getElementById("username").value;
    var s_username = document.getElementById("s_username");
    var flag = (username!=="")&&username>0;
    if(flag){
        s_username.innerHTML = "<img height='15' width='15' src='/test06/static/img/gou.png'>"
    }else{
        s_username.innerHTML = "<img height='15' width='15' src='/test06/static/img/error.png' >填写的计算税额不能为空且需大于0！";
    }
    return flag;
}




