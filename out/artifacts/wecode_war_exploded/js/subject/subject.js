$(document).ready(function(){
    // console.log("题目ID："+$.cookie('subjectId'));
    var info = {
        subjectId: $.cookie('subjectId'),
    };

    var noteInfo = {
        subjectId: $.cookie('subjectId'),
        userId: $.cookie('userId')
    }

    $.ajax({
        url: "../../subject/getSubjectById",
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
        url: "../../subject/loadNoteById",
        type: "POST",
        dataType: "json",
        data: noteInfo,
        success: function (result) {
            if(result.content != ""){
                $.cookie("noteId",result.id);
                $("#note").html(result.content);
                $("#doNote").val(result.content);
            }
        },
        error: function () {
        }
    });

    // 检测是否已经收藏了
    whetherCollected();

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
                    url: "../../subject/addNote",
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
                    url: "../../subject/modifyNote",
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
        url: "../../subject/addCollection",
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
        url: "../../subject/deleteCollection",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            if (result > 0){
                // $("#note").html($("#doNote").val());
                $("#isChoose").hide();
                $("#notChoose").show();
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
        url: "../../subject/searchCollection",
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


// 纠错
$("#postError").click(function(){
    alert("ddddd");
    var info = {
        questionId: $.cookie('subjectId'),
        reporterId: $.cookie('userId'),
        reason: $("#modifyContent").val()
    }

    $.ajax({
        url: "../../error/addError",
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