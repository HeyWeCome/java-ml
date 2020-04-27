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

    // 加载数据结构
    loadDataStruct();
    // 加载计网
    loadNet();
    loadOrg();
    loadOp();
}

function loadDataStruct() {
    var info ={
        userId: $.cookie('userId'),
        classify: "1"
    }
    var count = 1;

    $.ajax({
        url: "subject/loadCollection",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            console.log(result);
            for(var i in result){
                var body =
                    "<a id=\""+ result[i].questionId+"\" onclick=\"loadSubject(this);\" class=\"list-group-item list-group-item-action\">"+(count++)+"."+result[i].title+"</a>";
                    $('#dataStructure').append(body);
            }
        },
        error: function () {
        }
    });
}

function loadNet() {
    var info ={
        userId: $.cookie('userId'),
        classify: "2"
    }
    var count = 1;

    $.ajax({
        url: "subject/loadCollection",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            console.log(result);
            for(var i in result){
                var body =
                    "<a id=\""+ result[i].questionId+"\" onclick=\"loadSubject(this);\" class=\"list-group-item list-group-item-action\">"+(count++)+"."+result[i].title+"</a>";
                $('#bet').append(body);
            }
        },
        error: function () {
        }
    });
}

function loadOrg() {
    var info ={
        userId: $.cookie('userId'),
        classify: "3"
    }
    var count = 1;

    $.ajax({
        url: "subject/loadCollection",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            console.log(result);
            for(var i in result){
                var body =
                    "<a id=\""+ result[i].questionId+"\" onclick=\"loadSubject(this);\" class=\"list-group-item list-group-item-action\">"+(count++)+"."+result[i].title+"</a>";
                $('#org').append(body);
            }
        },
        error: function () {
        }
    });
}

function loadOp() {
    var info ={
        userId: $.cookie('userId'),
        classify: "4"
    }
    var count = 1;

    $.ajax({
        url: "subject/loadCollection",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            console.log(result);
            for(var i in result){
                var body =
                    "<a id=\""+ result[i].questionId+"\" onclick=\"loadSubject(this);\" class=\"list-group-item list-group-item-action\">"+(count++)+"."+result[i].title+"</a>";
                $('#op').append(body);
            }
        },
        error: function () {
        }
    });
}

function loadSubject(subject) {
    console.log(subject.id);
    $.cookie('subjectId',subject.id);
    location.href="subject.html";
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