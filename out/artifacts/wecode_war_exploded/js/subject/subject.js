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

// 收藏按钮的操作
// 加载操作系统的数据
$("#notChoose").click(function(){
    swal({
        title: "收藏成功",
        text: "要记得回顾哦！",
        icon: "success",
        button: false,
        timer: 1000,
    }).then(() => {
        $("#notChoose").hide();
        $("#isChoose").show();
    });
});

$("#isChoose").click(function(){
    $("#isChoose").hide();
    $("#notChoose").show();
});

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