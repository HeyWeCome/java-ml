$(document).ready(function(){
    // console.log("题目ID："+$.cookie('subjectId'));
    $('#readUser').html("您好！"+$.cookie('userName'));    // 修改用户名称
    console.log($.cookie("userName"));

    var info = {
        subjectId: $.cookie('subjectId'),
    };

    var noteInfo = {
        subjectId: $.cookie('subjectId'),
        userId: $.cookie('userId')
    }

    $.ajax({
        url: "subject/getSubjectById",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            if (result.type=="1"){
                $("#type").html("单选题");
            }else{
                $("#type").html("简答题");
            }
            // 改变题目的标题
            $("#title").html(result.title);
            $("#optionA").html("A."+result.optionA);
            $("#optionB").html("B."+result.optionB);
            $("#optionC").html("C."+result.optionC);
            $("#optionD").html("D."+result.optionD);
            $("#content").html(result.content);

            // 问题所属归类
            if(result.classify=="1"){
                $("#tag-label").html("数据结构");
            }else if (result.classify=="2"){
                $("#tag-label").html("计算机网络");
            }else if (result.classify=="3"){
                $("#tag-label").html("计算机组成原理");
            }else if (result.classify=="4"){
                $("#tag-label").html("操作系统");
            }else{
                $("#tag-label").html("全新习题");
            }

        },
        error: function () {
        }
    });

    $.ajax({
        url: "subject/loadNoteById",
        type: "POST",
        dataType: "json",
        data: noteInfo,
        success: function (result) {
            if(result.content != ""){
                $.cookie("noteId",result.id);
                $("#note").html(result.content);
                $("#doNote").val(result.content);
            }else {

            }
        },
        error: function () {
        }
    });

    // 检测是否已经收藏了
    whetherCollected();

    // 加载题目的收藏数
    loadCollectionCount();

    // 加载留言
    loadAllDiscuss_parent();

    // 实时检测输入框输入的字数
    checkCommentSize();
});

// 检测输入框输入的字数
function checkCommentSize() {
    var lenInput = $('.textarea-item').val().length;

    $(".textarea-item").keyup(function(){
        lenInput = $(this).val().length;
        if(lenInput>0 && lenInput<=300){
            $('.textareaInput').html(lenInput);
            $('.textarea-btn').attr('disabled',false);
        }else{
            $('.textarea-btn').attr('disabled',true);
        }
    });
}

// 添加笔记
$("#postNote").click(function(){
    if(whetherLogin()){
        // 判断输入框中是否有数据
        if($("#doNote").val() == ""){
            swal({
                text: "先在输入框内记录些内容吧！",
            });
        }else{
            var info = {
                subjectId: $.cookie('subjectId'),
                userId: $.cookie('userId'),
                content: $("#doNote").val()
            }

            if($.cookie('noteId') == ""){
                $.ajax({
                    url: "subject/addNote",
                    type: "POST",
                    dataType: "json",
                    data: info,
                    success: function (result) {
                        if (result == "1"){
                            swal({
                                title: "添加笔记成功",
                                text: "感谢您为社区做出的一份贡献",
                                icon: "success",
                                button: false,
                                timer: 1000,
                            }).then(() => {
                                $("#note").html($("#doNote").val());
                            });
                        }
                    },
                    error: function () {
                    }
                });
            }else{
                var info2 = {
                    id: $.cookie('noteId'),
                    content: $("#doNote").val()
                }
                $.ajax({
                    url: "subject/modifyNote",
                    type: "POST",
                    dataType: "json",
                    data: info2,
                    success: function (result) {
                        if (result == "1"){
                            swal({
                                title: "修改笔记成功",
                                text: "感谢您为社区做出的一份贡献",
                                icon: "success",
                                button: false,
                                timer: 1000,
                            }).then(() => {
                                $("#note").html($("#doNote").val());
                                $("#addNote").modal('hide');
                            });
                        }
                    },
                    error: function () {
                    }
                });
            }
        }
    }
});

function whetherLogin() {
    // 检测用户是否登录
    if (!$.cookie('userId')){
        swal({
            text: "请先登录吧！",
        }).then(() => {
            $(location).attr('href', 'login.html');
            return false;
        });
    }else {
        return true;
    }
}

// 用户收藏习题
$("#notChoose").click(function(){
    var info = {
        subjectId: $.cookie('subjectId'),
        userId: $.cookie('userId'),
    }

    $.ajax({
        url: "subject/addCollection",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            if (result == "1"){
                swal({
                    title: "收藏成功",
                    text: "已添加至您的收藏夹",
                    icon: "success",
                    button: false,
                    timer: 1000,
                }).then(() => {
                    // $("#note").html($("#doNote").val());
                    $("#notChoose").hide();
                    $("#isChoose").show();
                    loadCollectionCount();
                });
            }
        },
        error: function () {
        }
    });
});

// 用户取消收藏习题
$("#isChoose").click(function(){
    var info = {
        subjectId: $.cookie('subjectId'),
        userId: $.cookie('userId'),
    }

    $.ajax({
        url: "subject/deleteCollection",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            if (result > 0){
                // $("#note").html($("#doNote").val());
                $("#isChoose").hide();
                $("#notChoose").show();
                loadCollectionCount();
            }else{
                swal({
                    icon: "warning",
                    text: "取消收藏失败，请稍后重试",
                    button: false,
                    timer: 1000,
                });
            }
        },
        error: function () {
            swal({
                icon: "error",
                text: "系统故障",
                button: false,
                timer: 1000,
            });
        }
    });
});

// 检测用户是否已经收藏了这道题目
function whetherCollected() {
    var info = {
        subjectId: $.cookie('subjectId'),
        userId: $.cookie('userId'),
    }

    $.ajax({
        url: "subject/searchCollection",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            // console.log("查询结果："+result.id);
            if (result == 1){
                $("#notChoose").hide();
                $("#isChoose").show();
            }else{
                $("#isChoose").hide();
                $("#notChoose").show();
            }
        },
        error: function () {
            swal({
                icon: "error",
                text: "系统故障",
                button: false,
                timer: 1000,
            });
        }
    });
}

// 检测题目的收藏数
function loadCollectionCount() {
    var info = {
        questionId: $.cookie('subjectId'),
    }

    $.ajax({
        url: "questionDiscuss/loadCollectionCount",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            $("#totalCollectionCount").html(result+"收藏");
        },
        error: function () {
            $("#totalCollectionCount").html(0+"收藏");
        }
    });
}

// 纠错
$("#postError").click(function(){

    var info = {
        questionId: $.cookie('subjectId'),
        reporterId: $.cookie('userId'),
        reason: $("#modifyContent").val()
    }

    $.ajax({
        url: "error/addError",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            if (result > 0){
                swal({
                    title: "提交成功",
                    text: "感谢您为社区做出的贡献",
                    icon: "success",
                    button: false,
                    timer: 1000,
                }).then(() => {
                    $("#doModify").modal('hide');
                });
            }else{
                swal({
                    icon: "warning",
                    text: "提交失败，请稍后重试",
                    button: false,
                    timer: 1000,
                });
            }
        },
        error: function () {
            swal({
                icon: "error",
                text: "系统故障",
                button: false,
                timer: 1000,
            });
        }
    });
});

// 评论
$("#doPostComment").click(function(){
    var info = {
        questionId: $.cookie('subjectId'),
        userId: $.cookie('userId'),
        content: $("#commentContent").val(),
        parent: "0"
    }

    $.ajax({
        url: "questionDiscuss/addQuestionDiscuss",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            if (result > 0){
                swal({
                    title: "评论成功",
                    text: "感谢您为社区做出的贡献",
                    icon: "success",
                    button: false,
                    timer: 1000,
                }).then(() => {
                    $("#commentContent").val("");
                    $("#allDiscuss").find(".answer-body").remove();
                    loadAllDiscuss_parent();
                });
            }else{
                swal({
                    icon: "warning",
                    text: "评论失败，请稍后重试",
                    button: false,
                    timer: 1000,
                });
            }
        },
        error: function () {
            swal({
                icon: "error",
                text: "系统故障",
                button: false,
                timer: 1000,
            });
        }
    });
});

function loadAllDiscuss_parent() {
    var info = {
        questionId: $.cookie('subjectId'),
    }

    $.ajax({
        url: "questionDiscuss/loadQuestionDiscuss",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            $("#totalAnswer").html(result.length+"个心得");
            $("#totalDiscuss").html(result.length+"个讨论");

            for(var i in result){
                var flagOfClass = "";

                var temp = {
                    questionDiscussId: result[i].id,
                    userId: $.cookie('userId')
                }

                $.ajax({
                    url: "questionDiscuss/checkUserPrefer",
                    type: "POST",
                    dataType: "json",
                    data: temp,
                    async:false,
                    success: function (result) {
                        if (result > 0){
                            flagOfClass = "btnOfPassOnClick";
                        }
                    },
                    error: function () {
                    }
                });

                console.log("flagOfClass:"+flagOfClass);

                // alert(flagOfClass);

                // 头部
                var head =
                    "<div class=\"answer-body\">" +
                    "<div class=\"row\">";

                // 左侧的赞同和不赞同
                var agreeAndDisagreeContent =
                    "<div class=\"passAndNo col-lg-1\">" +
                    "<div id=\""+result[i].id+"agree\" onclick=\"addAgree(this);\" class=\"pass\">" +
                    "<button data-id=\"971334911\" class=\"btnOfPass btn btn-light\" title=\"赞同\">" +
                    "<svg t=\"1587200678135\" class=\"icon\" viewBox=\"0 0 1024 1024\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" p-id=\"3580\" width=\"20\" height=\"20\"><path d=\"M511.051852 128c51.863704 0 102.115556 10.145185 149.428148 30.151111 45.700741 19.342222 86.755556 47.028148 122.026667 82.299259s62.957037 76.325926 82.299259 122.026667c20.100741 47.407407 30.245926 97.659259 30.245926 149.522963s-10.145185 102.115556-30.151111 149.428148c-19.342222 45.700741-47.028148 86.755556-82.29926 122.026667s-76.325926 62.957037-122.026666 82.299259c-47.407407 20.100741-97.659259 30.245926-149.522963 30.245926-51.863704 0-102.115556-10.145185-149.428148-30.151111-45.700741-19.342222-86.755556-47.028148-122.026667-82.299259s-62.957037-76.325926-82.299259-122.026667c-20.100741-47.407407-30.245926-97.659259-30.245926-149.522963s10.145185-102.115556 30.151111-149.428148c19.342222-45.700741 47.028148-86.755556 82.299259-122.026667s76.325926-62.957037 122.026667-82.299259c47.407407-20.100741 97.659259-30.245926 149.522963-30.245926m0-42.666667C275.437037 85.333333 84.385185 276.385185 84.385185 512s191.051852 426.666667 426.666667 426.666667 426.666667-191.051852 426.666667-426.666667S746.666667 85.333333 511.051852 85.333333z\" p-id=\"3581\" fill=\"#FFA800\"></path><path d=\"M512.094815 721.161481c-65.706667 0-119.087407-53.475556-119.087408-119.087407 0-11.757037 9.576296-21.333333 21.333334-21.333333s21.333333 9.576296 21.333333 21.333333c0 42.192593 34.322963 76.420741 76.420741 76.420741 42.192593 0 76.420741-34.322963 76.420741-76.420741 0-11.757037 9.576296-21.333333 21.333333-21.333333s21.333333 9.576296 21.333333 21.333333c0.094815 65.706667-53.380741 119.087407-119.087407 119.087407zM306.725926 376.414815c-19.626667 0-35.555556 15.928889-35.555556 35.555555s15.928889 35.555556 35.555556 35.555556 35.555556-15.928889 35.555555-35.555556-15.928889-35.555556-35.555555-35.555555zM718.222222 376.414815c-19.626667 0-35.555556 15.928889-35.555555 35.555555s15.928889 35.555556 35.555555 35.555556 35.555556-15.928889 35.555556-35.555556-15.928889-35.555556-35.555556-35.555555z\" p-id=\"3582\" fill=\"#FFA800\"></path></svg>" +
                    "<span class=\"count "+flagOfClass+"\">"+result[i].agree+"</span>" +
                    "</button>" +
                    "</div>" +
                    "</div>";

                var responseBody =
                    "<div class=\"reportBody col-lg-11\">" +
                        "<div class=\"reportHead col-lg-6\">" +
                            "<img class=\"userPhoto\" src=\""+result[i].photo+"\">" +
                            "<span class=\"reporterName\">"+result[i].userName+"</span>\n" +
                        "</div>" +
                        "<div class=\"reportContent\">" +
                            "<span class=\"comment\">"+result[i].content+"</span>" +
                        "</div>" +
                    "<div class=\"answer-legend\">" +
                        "<span class=\"answer-time\">编辑于"+ result[i].time+"</span>" +
                        "<a id=\""+result[i].id+"correct\" onclick=\"postCorrect(this);\" data-discussId=\""+result[i].id+"\">反馈</a>"
                    "</div>" +
                    "</div>";

                var tail =
                    "</div>" +
                    "</div>";

                var discuss = head+agreeAndDisagreeContent+responseBody+tail;

                $("#allDiscuss").append(discuss);
            }
        },
        error: function () {
        }
    });
}

// 提交纠错信息,打开模态框
function postCorrect(subject) {
    $("#postCorrect").data("data-discussId", $("#"+subject.id).attr('data-discussId'));
    $("#correctDiscuss").modal();
}

$("#postCorrect").click(function () {

    var info = {
        discussId: $("#postCorrect").data("data-discussId"),
        reporterId: $.cookie('userId'),
        content: $("#correctDiscussContent").val()
    };

    console.log(info);

    $.ajax({
        url: "discussCorrect/addDisscussCorrection",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            if (result > 0){
                swal({
                    icon: "success",
                    text: "提交成功！感谢您做出的贡献！",
                    button: false,
                    timer: 1000,
                }).then(() => {
                    $("#correctDiscuss").modal('hide');
                });
            }
        },
        error: function () {
        }
    });
})

// 点击赞
function addAgree(subject) {

    var id = subject.id;
    var count = parseInt($("#"+id).find("span").html()) +1;

    if(!$("#"+id).find("span").hasClass("btnOfPassOnClick")){
        // 修改数据库，1：添加用户和赞的关联，2：修改回答的赞
        var info = {
            id: subject.id,
            agree: count,
            userId: $.cookie('userId')
        }

        $.ajax({
            url: "questionDiscuss/addAgree",
            type: "POST",
            dataType: "json",
            data: info,
            success: function (result) {
                if (result > 0){
                    $("#"+id).find("span").html(count);
                    $("#"+id).find("span").addClass('btnOfPassOnClick');
                }else{
                    swal({
                        icon: "warning",
                        text: "点赞失败，请稍后重试",
                        button: false,
                        timer: 1000,
                    });
                }
            },
            error: function () {
                swal({
                    icon: "error",
                    text: "系统故障",
                    button: false,
                    timer: 1000,
                });
            }
        });
    }else{
        // 取消赞
        // 修改数据库，1：添加用户和赞的关联，2：修改回答的赞
        var info = {
            id: subject.id,
            agree: count-2,
            userId: $.cookie('userId')
        }

        $.ajax({
            url: "questionDiscuss/deleteAgree",
            type: "POST",
            dataType: "json",
            data: info,
            success: function (result) {
                if (result > 0){
                    $("#"+id).find("span").html(count-2);
                    $("#"+id).find("span").removeClass('btnOfPassOnClick');
                }else{
                }
            },
            error: function () {
            }
        });
    }

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