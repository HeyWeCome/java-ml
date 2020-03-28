$("#login").click(function(){
    // 获取前台的用户名和密码
    var user ={
        userName: $('#userName').val(),
        password: $('#password').val()
    }

    console.log(user);

    $.ajax({
            url: "login/userLogin",
            type: "POST",
            dataType: "json",
            data: user,
            // contentType:"application/json; charset=utf-8", //contentType很重要
            success: function (result) {
                console.log(result);
            },
            error: function () {
                console.log("失败");
            }
        });
});

$('.carousel').carousel({
    interval: 2500
})