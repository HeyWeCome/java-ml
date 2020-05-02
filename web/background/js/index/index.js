window.onload = function () {
    $('#employeeName').html($.cookie('employeeName'));
    var info = {
        id: $.cookie('employeeId')
    }

    console.log(info);

    $.ajax({
        url: "../user/loadModule",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            console.log(result);
            var flag = 0;
            $('#leftNav').find('li').each(function() {
                flag = 0;
                for(var i in result){
                    if (result[i] == $(this).attr("data-name")){
                        flag = 1;
                    }
                }
                if(flag == 0){
                    $(this).hide();
                }
            })
        },
        error: function () {

        }
    });
    // 加载所有的用户
    loadAllUser();
    // 加载题目的个数
    loadAllQuestion();
    // 加载热度院校的个数
    loadSchool();
    // 加载所有的举报
    loadAllCorrect();
    // 加载所有的题目纠错信息
    loadAllQuestionCorrect();
}

// 加载所有的用户
function loadAllUser() {
    $.ajax({
        url: "../user/loadAllUser",
        type: "POST",
        dataType: "json",
        // data: user,
        success: function (result) {
            // 改变首页数据展示的用户个数
            $('#numOfUser').html(result.length);
            $("#recentUser").empty();

            var index = 1;
            for (var i in result){
                var sex;
                if(result[i].sex == "1"){
                    sex = "男";
                }else{
                    sex = "女";
                }
                var user =
                    "<tr>" +
                    "<td>"+(index++)+"</td>" +
                    "<td>" +
                    "<div class=\"m-r-10\"><img src=\"../"+result[i].photo+"\" alt=\"user\" class=\"rounded\" width=\"45\"></div>" +
                    "</td>\n" +
                    "<td>"+result[i].name+"</td>" +
                    "<td>"+result[i].account+"</td>" +
                    "<td>"+result[i].password+"</td>" +
                    "<td>"+result[i].email+"</td>" +
                    "<td>"+result[i].phoneNumber+"</td>" +
                    "<td>"+sex+"</td>" +
                    "<td><span class=\"badge-dot badge-primary mr-1\"></span>"+result[i].createTime+"</span></td>" +
                    "</tr>";

                $("#recentUser").append(user);

                if (index == 6){
                    break;
                }
            }
            var button = "<tr>" +
                "<td colspan=\"9\"><a href=\"#\" class=\"btn btn-outline-light float-right\">查看更多</a></td>" +
                "</tr>";
            $("#recentUser").append(button);
        },
        error: function () {

        }
    });
}

// 加载所有的习题
function loadAllQuestion() {
    $.ajax({
        url: "../question/loadAllQuestion",
        type: "POST",
        dataType: "json",
        success: function (result) {
            // 改变首页数据展示的题目个数
            $('#numOfSubject').html(result.length);
        },
        error: function () {
        }
    });
}

// 加载热度院校
function loadSchool() {
    $.ajax({
        url: "../school/loadAllSchool",
        type: "POST",
        dataType: "json",
        success: function (result) {
            // 先清空
            $('#school').empty();
            var index = 1;
            for (var i in result) {

                var school =
                    "<tr>" +
                    "<td class=\"text-center\">"+(index++)+"</td>" +
                    "<td>"+result[i].name+"</td>" +
                    "<td>"+result[i].heat+"</td>" +
                    "</tr>";

                $("#school").append(school);

                if (index == 6) {
                    break;
                }
            }
        },
        error: function () {
        }
    });
}

// 加载所有的举报
function loadAllCorrect() {
    $.ajax({
        url: "../discussCorrect/loadAllCorrect",
        type: "POST",
        dataType: "json",
        success: function (result) {
            $('#numOfDissCorrect').html(result.length);
        },
        error: function () {
        }
    });
}

// 加载所有的题目纠错信息
function loadAllQuestionCorrect() {
    $.ajax({
        url: "../error/loadAllError",
        type: "POST",
        dataType: "json",
        success: function (result) {
            $('#numOfQuestionError').html(result.length);
        },
        error: function () {
        }
    });
}