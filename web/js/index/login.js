/*动态监听事件，不断查看账号，密码是否符合规范*/
//监听用户名
$("#userAccount").bind("input propertychange", function() {
    var patrnOfAccount = /^[a-zA-Z0-9_-]{4,16}$/;
    if(!patrnOfAccount.test($("#userAccount").val())){
        $("#accountExist").hide();
        $("#accountOk").hide();
        $("#accountNotify").show();
    }else{
        $("#accountNotify").hide();

        var userAccount ={
            account: $("#userAccount").val(),
        }

        $.ajax({
            url: "user/checkAccount",
            type: "POST",
            dataType: "json",
            data: userAccount,
            // contentType:"application/json; charset=utf-8", //contentType很重要
            success: function (result) {
                if(result == 0){
                    // 还没人注册过
                    if(patrnOfAccount.test($("#userAccount").val())){
                        $("#accountExist").hide();
                        $("#accountOk").show();
                    }
                }else{
                    // 注册过了
                    $("#accountOk").hide();
                    $("#accountExist").show();
                }
            },
            error: function () {
            }
        });
    }

});

// 监听密码
$("#userPassword1").bind("input propertychange", function() {
    var patrnOfPassword = /^(\w){6,20}$/;

    if(!patrnOfPassword.test($("#userPassword1").val())){
        $("#passwordNotify1").show();
    }else{
        $("#passwordNotify1").hide();
    }
});

// 监听密码是否一致
$("#userPassword2").bind("input propertychange", function() {
    var password1 = $("#userPassword1").val();
    var password2 = $("#userPassword2").val();

    if(password1 != password2){
        $("#passwordNotify2").show();
    }else{
        $("#passwordNotify2").hide();
    }
});

// 监听用户名是否符合规范
$("#userName").bind("input propertychange", function() {
    // 校验用户名可以为中文，英文字母，数字及下划线组成，长度2-20位
    var preg = /^[\u4E00-\u9FA5\uF900-\uFA2D|\w]{2,20}$/

    if(!preg.test($("#userName").val())){
        $("#nameNotify").show();
    }else{
        $("#nameNotify").hide();
    }
});

// 点击登录按钮检测是否存在
$("#loginIn").click(function(){
    // 获取前台的用户名和密码
    var account = $('#account').val();
    var passW = $('#password').val();

    var user ={
        account: account,
        password: passW
    }

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
            url: "user/userLogin",
            type: "POST",
            dataType: "json",
            data: user,
            // contentType:"application/json; charset=utf-8", //contentType很重要
            success: function (result) {
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
                        console.log(result);
                        $.cookie('userName', result.name);
                        $.cookie('userId', result.id);
                        // 将当前的用户名和ID存起来
                        $(location).attr('href', 'index.html');
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


// 注册功能
$("#registerNow").click(function(){
    // 获取前台的用户名和密码
    var account = $('#userAccount').val();
    var passW = $('#userPassword1').val();
    var userName = $('#userName').val();

    var userPreg = /^[\u4E00-\u9FA5\uF900-\uFA2D|\w]{2,20}$/; // 用户名
    var patrnOfPassword = /^(\w){6,20}$/;                     // 密码
    var password1 = $("#userPassword1").val();
    var password2 = $("#userPassword2").val();
    var patrnOfAccount = /^[a-zA-Z0-9_-]{4,16}$/;

    if(patrnOfAccount.test($("#userAccount").val()) && userPreg.test($("#userName").val()) && password1 == password2) {
        var user ={
            account: account,
            password: passW,
            name:userName
        }

        $.ajax({
            url: "user/register",
            type: "POST",
            dataType: "json",
            data: user,
            // contentType:"application/json; charset=utf-8", //contentType很重要
            success: function (result) {
                if(result=="0"){
                    swal("注册失败", {
                        buttons: false,
                        icon: "error",
                        timer: 1000,
                    });
                }else{
                    swal({
                        title: "注册成功",
                        text: "你好！"+userName,
                        icon: "success",
                        button: false,
                        timer: 1000,
                    }).then(() => {
                        // $('#login').modal("hide");
                        $(location).attr('href', '../../index.html');
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
    }else{
        swal({
            title: "错误",
            text: "请检查所输入的内容",
            icon: "warning",
            buttons: false,
            // dangerMode: true,
            timer: 1000,
        })
    }
});

// 轮播图时间
$('.carousel').carousel({
    interval: 2500
})

// 忘记密码
$('#forgetPassWord').click(function () {
    swal({
        text: "为您提供两种方式：\n" +
            "1.联系邮箱：heywecome@163.com\n" +
            "2.联系人工客服：15102346379\n" +
            "提供相关的信息，工作人员为您提供服务！",
    });
});