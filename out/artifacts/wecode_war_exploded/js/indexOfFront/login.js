$("#loginIn").click(function(){
    // 获取前台的用户名和密码
    var name = $('#account').val();
    var passW = $('#password').val();

    var user ={
        userName: name,
        password: passW
    }

    console.log(user);
    if (name == "" && passW == ""){
        swal({
            text: "请输入账号和密码",
            button: "好的",
        });
    }else if(name == ""){
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
            url: "../../login/userLogin",
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
    }
});

$('.carousel').carousel({
    interval: 2500
})