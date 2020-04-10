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
            // console.log(result.address);

            $('#readUser').html("您好！"+result.name);                // 修改用户名称
            $('#originalName').val(result.name);                     // 修改模态框中的值，用户名
            $('#userName').html(result.name);                        // 修改用户名称
            $('#nameOfUser').html(result.name);                      // 表单中修改用户名称

            $('#originalIntro').val(result.introduction);            // 修改模态框中的值，用户个性签名
            $('#userIntro').html("个人简介"+result.introduction);    // 修改用户介绍
            $('#introOfUser').html(result.introduction);            // 修改表单中用户介绍

            $('#accountOfUser').html(result.account);               // 表单中查看用户账号
            $('#passwordOfUser').val(result.password);              // 表单中查看用户密码
            $('#originalPassWord').val(result.password);            // 修改模态框中的值，用户密码

            $('#ageOfUser').html(result.age);                       // 表单中查看用户年龄

            if (result.sex == "1"){
                $('#sexOfUser').html("男");                          // 表单中查看用户性别
            }else {
                $('#sexOfUser').html("女");
            }

            $('#emailOfUser').html(result.email);                    // 表单中查看用户邮箱

            // 通过用户查询出来的数据，动态加载院校信息。表单中查看用户院校
            var school ={
                schoolId: result.voluntarySchool
            }

            $.ajax({
                url: "school/searchSchoolById",
                type: "POST",
                dataType: "json",
                data: school,
                success: function (result) {
                    console.log(result.name);
                    $('#schoolOfUser').html(result.name);
                },
                error: function () {
                    $('#schoolOfUser').html("");
                }
            });

            $('#phoneOfUser').html(result.phoneNumber);               // 表单中查看用户电话
            $('#addressOfUser').html(result.address);                 // 表单中查看用户地址
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