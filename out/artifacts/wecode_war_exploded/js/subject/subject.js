$(document).ready(function(){

    console.log("题目ID："+$.cookie('subjectId'));
    var info = {
        subjectId: $.cookie('subjectId'),
    };

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
    swal({
        title: "取消收藏成功",
        text: "相信你已经学会了！",
        icon: "success",
        button: false,
        timer: 1000,
    }).then(() => {
        $("#isChoose").hide();
        $("#notChoose").show();
    });
});