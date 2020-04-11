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

            $('#birthOfUser').html(result.birthday);                  // 表单中查看用户出生年月
            $('#originalBirthday').val(result.birthday);            // 模态框里面的出生年月

            if (result.sex == "1"){
                $('#sexOfUser').html("男");                          // 表单中查看用户性别
            }else if(result.sex == "0"){
                $('#sexOfUser').html("女");
            }else {
                $('#sexOfUser').html("");
            }

            $('#emailOfUser').html(result.email);                    // 表单中查看用户邮箱
            $('#originalEmail').val(result.email);                   // 修改模态框中的值，用户密码


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
            $('#originalPhone').val(result.phoneNumber);              // 修改模态框中的值，用户电话号码

            $('#addressOfUser').html(result.address);                 // 表单中查看用户地址
            $("#originalAddress").val(result.address)                   // 修改模态框中的值，用户地址
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

/*表单更改用户的昵称的事件*/
$("#modifyUserName").click(function(){
    var user ={
        id: $.cookie('userId'),
        name: $("#originalName").val()
    }

    $.ajax({
        url: "user/modifyUserName",
        type: "POST",
        dataType: "json",
        data: user,
        success: function (result) {
            if (result == "1"){
                swal({
                    title: "修改成功",
                    text: "新昵称也很好听呢！",
                    icon: "success",
                    button: false,
                    timer: 1000,
                }).then(() => {
                    $('#changeUserName').modal('hide');                                    // 隐藏模态框
                    $('#readUser').html("您好！"+$("#originalName").val());                // 修改用户名称
                    $('#originalName').val($("#originalName").val());                     // 修改模态框中的值，用户名
                    $('#userName').html($("#originalName").val());                        // 修改用户名称
                    $('#nameOfUser').html($("#originalName").val());                      // 表单中修改用户名称
                });
            }else {
                swal("修改失败", {
                    buttons: false,
                    icon: "error",
                    timer: 1000,
                });
            }
        },
        error: function () {
            swal("系统暂时故障哦", {
                buttons: false,
                icon: "error",
                timer: 1000,
            });
        }
    });
});

/*表单更改用户的个性签名的事件*/
$("#modifyUserIntro").click(function(){
    var user ={
        id: $.cookie('userId'),
        introduction: $("#originalIntro").val()
    }

    $.ajax({
        url: "user/modifyUserIntro",
        type: "POST",
        dataType: "json",
        data: user,
        success: function (result) {
            if (result == "1"){
                swal({
                    title: "修改成功",
                    text: "个人简介很棒呢！",
                    icon: "success",
                    button: false,
                    timer: 1000,
                }).then(() => {
                    $('#changeUserIntro').modal('hide');                                          // 隐藏模态框
                    $('#originalIntro').val($("#originalIntro").val());                           // 修改模态框中的值，用户个性签名
                    $('#userIntro').html("个人简介："+$("#originalIntro").val());                  // 修改用户介绍
                    $('#introOfUser').html($("#originalIntro").val());                            // 修改表单中用户介绍
                });
            }else {
                swal("修改失败", {
                    buttons: false,
                    icon: "error",
                    timer: 1000,
                });
            }
        },
        error: function () {
            swal("系统暂时故障哦", {
                buttons: false,
                icon: "error",
                timer: 1000,
            });
        }
    });
});

/*表单更改用户的密码的事件*/
$("#modifyUserPassword").click(function(){
    // 验证下用户的密码是否符合规范
    var patrnOfPassword = /^(\w){6,20}$/;

    if(patrnOfPassword.test($("#originalPassWord").val())){
        var user ={
            id: $.cookie('userId'),
            password: $("#originalPassWord").val()
        }

        $.ajax({
            url: "user/modifyUserPassword",
            type: "POST",
            dataType: "json",
            data: user,
            success: function (result) {
                if (result == "1"){
                    swal({
                        title: "修改成功",
                        text: "新的密码要注意保管哦！",
                        icon: "success",
                        button: false,
                        timer: 1000,
                    }).then(() => {
                        $('#changeUserPassword').modal('hide');                        // 隐藏模态框
                        $('#passwordOfUser').val($("#originalPassWord").val());        // 表单中查看用户密码
                        $('#originalPassWord').val($("#originalPassWord").val());      // 修改模态框中的值，用户密码
                    });
                }else {
                    swal("修改失败", {
                        buttons: false,
                        icon: "error",
                        timer: 1000,
                    });
                }
            },
            error: function () {
                swal("系统暂时故障哦", {
                    buttons: false,
                    icon: "error",
                    timer: 1000,
                });
            }
        });
    }else{
        swal("请输入6-20个字母、数字、下划线", {
            buttons: false,
            icon: "error",
            timer: 1000,
        });
    }
});


/*表单更改用户的邮箱的事件*/
$("#modifyUserEmail").click(function(){
    // 验证下用户的邮箱是否符合规范
    var reg = /^(([^()[\]\\.,;:\s@\"]+(\.[^()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    if(reg.test($("#originalEmail").val())){
        var user ={
            id: $.cookie('userId'),
            email: $("#originalEmail").val()
        }

        console.log(user);

        $.ajax({
            url: "user/modifyUserEmail",
            type: "POST",
            dataType: "json",
            data: user,
            success: function (result) {
                if (result == "1"){
                    swal({
                        title: "修改成功",
                        text: "邮箱地址已经保存了！",
                        icon: "success",
                        button: false,
                        timer: 1000,
                    }).then(() => {
                        $('#changeUserEmail').modal('hide');                        // 隐藏模态框
                        $('#emailOfUser').html($("#originalEmail").val());        // 表单中查看用户邮箱
                        $('#originalEmail').val($("#originalEmail").val());       // 修改模态框中的值，用户密码
                    });
                }else {
                    swal("修改失败", {
                        buttons: false,
                        icon: "error",
                        timer: 1000,
                    });
                }
            },
            error: function () {
                swal("系统暂时故障哦", {
                    buttons: false,
                    icon: "error",
                    timer: 1000,
                });
            }
        });
    }else{
        swal("请输入正确的邮箱地址", {
            buttons: false,
            icon: "error",
            timer: 1000,
        });
    }
});

/*表单更改用户的电话号码的事件*/
$("#modifyUserPhone").click(function(){
    // 验证下用户的电话是否符合规范
    var reg = /^1[3456789]\d{9}$/;

    if(reg.test($("#originalPhone").val())){
        var user ={
            id: $.cookie('userId'),
            phoneNumber: $("#originalPhone").val()
        }

        $.ajax({
            url: "user/modifyUserPhone",
            type: "POST",
            dataType: "json",
            data: user,
            success: function (result) {
                if (result == "1"){
                    swal({
                        title: "修改成功",
                        text: "手机号码已经保存了！",
                        icon: "success",
                        button: false,
                        timer: 1000,
                    }).then(() => {
                        $('#changeUserPhone').modal('hide');                        // 隐藏模态框
                        $('#phoneOfUser').html($("#originalPhone").val());        // 表单中查看用户邮箱
                        $('#originalPhone').val($("#originalPhone").val());       // 修改模态框中的值，用户密码
                    });
                }else {
                    swal("修改失败", {
                        buttons: false,
                        icon: "error",
                        timer: 1000,
                    });
                }
            },
            error: function () {
                swal("系统暂时故障哦", {
                    buttons: false,
                    icon: "error",
                    timer: 1000,
                });
            }
        });
    }else{
        swal("请输入正确的手机号码", {
            buttons: false,
            icon: "error",
            timer: 1000,
        });
    }
});

/*表单更改用户的地址的事件*/
$("#modifyUserAddress").click(function(){

    var user ={
        id: $.cookie('userId'),
        address: $("#originalAddress").val()
    }

    $.ajax({
        url: "user/modifyUserAddress",
        type: "POST",
        dataType: "json",
        data: user,
        success: function (result) {
            if (result == "1"){
                swal({
                    title: "修改成功",
                    text: "地址已经保存了！",
                    icon: "success",
                    button: false,
                    timer: 1000,
                }).then(() => {
                    $('#changeUserAddress').modal('hide');                                   // 隐藏模态框
                    $('#addressOfUser').html($("#originalAddress").val());                   // 表单中查看用户地址
                    $("#originalAddress").val($("#originalAddress").val())                   // 修改模态框中的值，用户地址
                });
            }else {
                swal("修改失败", {
                    buttons: false,
                    icon: "error",
                    timer: 1000,
                });
            }
        },
        error: function () {
            swal("系统暂时故障哦", {
                buttons: false,
                icon: "error",
                timer: 1000,
            });
        }
    });
});

/*选择用户的性别*/
$('#boy').click(function(){
    $('#girl').css("background-color","rgb(186,196,197)");
    $('#boy').css("background-color","#1c7430");
    $('#flag').html("1");
});

$('#girl').click(function(){
    $('#girl').css("background-color","#EED5D2");
    $('#boy').css("background-color","rgb(186,196,197)");
    $('#flag').html("0");
});

/*表单更改用户的地址的事件*/
$("#modifyUserSex").click(function(){

    var user ={
        id: $.cookie('userId'),
        sex: $("#flag").html()
    }

    console.log(user);
    $.ajax({
        url: "user/modifyUserSex",
        type: "POST",
        dataType: "json",
        data: user,
        success: function (result) {
            if (result == "1"){
                swal({
                    title: "修改成功",
                    text: "性别已经保存了！",
                    icon: "success",
                    button: false,
                    timer: 1000,
                }).then(() => {
                    $('#changeUserSex').modal('hide');                                       // 隐藏模态框
                    if($("#flag").html() == "1"){// 男生
                        $('#sexOfUser').html("男");                                          // 表单中查看用户性别
                    }else if($("#flag").html() == "0"){ // 女生
                        $('#sexOfUser').html("女");                                          // 表单中查看用户性别
                    }
                });
            }else {
                swal("修改失败", {
                    buttons: false,
                    icon: "error",
                    timer: 1000,
                });
            }
        },
        error: function () {
            swal("系统暂时故障哦", {
                buttons: false,
                icon: "error",
                timer: 1000,
            });
        }
    });
});

// 编辑志愿学校，动态加载院校信息
$("#addSchool").bind("input propertychange", function() {

    var school ={
        keyword: $("#addSchool").val(),
    }

    if($("#addSchool").val() != ""){
        $.ajax({
            url: "school/searchSchool",
            type: "POST",
            dataType: "json",
            data: school,
            success: function (schools) {
                $("#source").empty();

                // 动态添加div
                for (var i in schools){
                    var school =
                        "<option id =\""+ schools[i].id +"\" value=\""+schools[i].name+"\">";
                    $("#source").append(school);
                }
            },
            error: function () {
            }
        });
    }
});

/*表单更改用户的地址的事件*/
$("#modifyUserSchool").click(function(){
    var selectSchool = $("#addSchool").val();
    var schoolID = "";
    var schoolName = "";

    for(var i=0;i<$("option").length;i++){
        var optionValue = $("option").eq(i).attr('value');

        if(selectSchool==optionValue){
            schoolName = optionValue
            schoolID = $("option").eq(i).attr('id');
            break;
        }
    }

    var user ={
        id: $.cookie('userId'),
        voluntarySchool: schoolID
    }

    console.log(user);
    $.ajax({
        url: "user/modifyUserSchool",
        type: "POST",
        dataType: "json",
        data: user,
        success: function (result) {
            if (result == "1"){
                swal({
                    title: "修改成功",
                    text: "加油！"+schoolName+"在等你！",
                    icon: "success",
                    button: false,
                    timer: 1500,
                }).then(() => {
                    $('#changeUserSchool').modal('hide'); // 隐藏模态框
                    $("#addSchool").val(schoolName);      // 修改模态框中的院校信息
                    $("#schoolOfUser").html(schoolName);  // 修改表单中用户的信息
                });
            }else {
                swal("修改失败", {
                    buttons: false,
                    icon: "error",
                    timer: 1000,
                });
            }
        },
        error: function () {
            swal("系统暂时故障哦", {
                buttons: false,
                icon: "error",
                timer: 1000,
            });
        }
    });
});

/*表单更改用户的出生年月的事件*/
$("#modifyUserBirth").click(function(){
    var user ={
        id: $.cookie('userId'),
        birthday: $("#originalBirthday").val()
    }

    // console.log(user);
    $.ajax({
        url: "user/modifyUserBirthDay",
        type: "POST",
        dataType: "json",
        data: user,
        success: function (result) {
            if (result == "1"){
                swal({
                    title: "修改成功",
                    text: "wecode记住了您的生日哦！",
                    icon: "success",
                    button: false,
                    timer: 1500,
                }).then(() => {
                    $('#changeUserBirth').modal('hide');                           // 隐藏模态框
                    $("#originalBirthday").val($("#originalBirthday").val());      // 修改模态框中的生日信息
                    $('#birthOfUser').html($("#originalBirthday").val());                       // 表单中查看用户出生年月
                });
            }else {
                swal("修改失败", {
                    buttons: false,
                    icon: "error",
                    timer: 1000,
                });
            }
        },
        error: function () {
            swal("系统暂时故障哦", {
                buttons: false,
                icon: "error",
                timer: 1000,
            });
        }
    });
});