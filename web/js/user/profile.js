window.onload = function () {
    // 最开始就判断下，用户是否登录，否则直接返回至登陆页面
    if($.cookie('userName') == ""){
        swal("请先登录！", {
            buttons: false,
            icon: "error",
            timer: 1000,
        }).then(() => {
            $(location).attr('href', 'login.html');
        });
    }

    var user ={
        id: $.cookie('userId')
    }

    $.ajax({
        url: "user/userLoginById",
        type: "POST",
        dataType: "json",
        data: user,
        // contentType:"application/json; charset=utf-8", //contentType很重要
        success: function (result) {
            console.log(result);

            $('#readUser').html("您好！"+result.name);               // 修改用户名称
            $('#userName').html(result.name);                        // 修改用户名称
            $('#userIntro').html("个人简介"+result.introduction);    // 修改用户介绍
            $('#nameOfUser').html(result.name);                     // 表单中修改用户名称
        },
        error: function () {

        }
    });



}

/*注销登录，删除所有的cookie，并且返回主页面*/
var loginOut = function () {
    $.cookie('userName', "");
    $.cookie('userId', "");
    swal({
        title: "退出成功",
        text: "期待您的下次使用！",
        icon: "success",
        button: false,
        timer: 1000,
    }).then(() => {
        $(location).attr('href', 'login.html');
    });
}