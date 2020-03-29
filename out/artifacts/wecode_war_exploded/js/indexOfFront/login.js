$("#loginIn").click(function(){
    // 获取前台的用户名和密码
    var account = $('#account').val();
    var passW = $('#password').val();

    var user ={
        account: account,
        password: passW
    }

    console.log(user);
    if (account == "" && passW == ""){
        swal({
            text: "请输入账号和密码",
            button: "好的",
        });
    }else if(account == ""){
        swal({
            text: "请输入账号",
            button: "好的",
        });
    }else if(passW == ""){
        swal({
            text: "请输入密码",
            button: "好的",
        });
    }else{
        $.ajax({
            url: "../../user/userLogin",
            type: "POST",
            dataType: "json",
            data: user,
            // contentType:"application/json; charset=utf-8", //contentType很重要
            success: function (result) {
                console.log(result);

                if(result=="0"){
                    swal("用户名和密码错误", {
                        buttons: false,
                        icon: "error",
                        timer: 1000,
                    });
                }else{
                    swal({
                        title: "登录成功",
                        text: "你好！"+result.name,
                        icon: "success",
                        button: false,
                        timer: 1000,
                    }).then(() => {
                        $('#login').modal("hide");
                    });
                }
            },
            error: function () {
                swal({
                    title: "系统故障！",
                    text: "请稍后尝试！",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true,
                    timer: 1000,
                })
            }
        });
    }
});

$('.carousel').carousel({
    interval: 2500
})