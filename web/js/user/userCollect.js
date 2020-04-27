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
            $('#readUser').html("您好！"+result.name);                // 修改用户名称
            $('#userName').html(result.name);                        // 修改用户名称
            $('#userIntro').html("个人简介："+result.introduction);    // 修改用户介绍
        },
        error: function () {
        }
    });

    // 加载数据结构习题
    $.ajax({
        url: "subject/searchCountOfDS",
        type: "POST",
        dataType: "json",
        // data: user,
        // contentType:"application/json; charset=utf-8", //contentType很重要
        success: function (result) {
            $('#todoDataStruct').html(result);
        },
        error: function () {
        }
    });

    // 加载计算机网络
    $.ajax({
        url: "subject/searchCountOfNet",
        type: "POST",
        dataType: "json",
        // data: user,
        // contentType:"application/json; charset=utf-8", //contentType很重要
        success: function (result) {
            $('#todoNet').html(result);
        },
        error: function () {
        }
    });

    // 加载计算机组成原理
    $.ajax({
        url: "subject/searchCountOfOrg",
        type: "POST",
        dataType: "json",
        // data: user,
        // contentType:"application/json; charset=utf-8", //contentType很重要
        success: function (result) {
            $('#totalOrg').html(result);
        },
        error: function () {
        }
    });

    // 加载操作系统
    $.ajax({
        url: "subject/searchCountOfOp",
        type: "POST",
        dataType: "json",
        // data: user,
        // contentType:"application/json; charset=utf-8", //contentType很重要
        success: function (result) {
            $('#totalOp').html(result);
        },
        error: function () {
        }
    });

    var info1 = {
        userId: $.cookie('userId'),
        type: "1"
    }
    // 加载用户完成的习题
    $.ajax({
        url: "subject/searchCountNote",
        type: "POST",
        dataType: "json",
        data: info1,
        success: function (result) {
            $('#finishedDataStruct').html(result);
        },
        error: function () {
        }
    });

    var info2 = {
        userId: $.cookie('userId'),
        type: "2"
    }
    // 加载用户完成的习题
    $.ajax({
        url: "subject/searchCountNote",
        type: "POST",
        dataType: "json",
        data: info2,
        success: function (result) {
            $('#finishedNet').html(result);
        },
        error: function () {
        }
    });

    var info3 = {
        userId: $.cookie('userId'),
        type: "3"
    }
    // 加载用户完成的习题
    $.ajax({
        url: "subject/searchCountNote",
        type: "POST",
        dataType: "json",
        data: info3,
        success: function (result) {
            $('#finishedOrg').html(result);
        },
        error: function () {
        }
    });

    var info4 = {
        userId: $.cookie('userId'),
        type: "4"
    }
    // 加载用户完成的习题
    $.ajax({
        url: "subject/searchCountNote",
        type: "POST",
        dataType: "json",
        data: info4,
        success: function (result) {
            $('#finishedOp').html(result);
        },
        error: function () {
        }
    });
}