var timer = null;
window.onload = function () {

    $('#readUser').html("您好！"+$.cookie('userName'));    // 修改用户名称
    $('#userName').html($.cookie('userName'));

    var dairy ={
        userId: $.cookie('userId'),
    }
    console.log("dairy:"+dairy);

    // 倒计时模块
    var myDate = new Date();//获取到当前的时间
    var currentYear = myDate.getFullYear(); // 获取当前的年份
    var currentMonth = myDate.getMonth();   // 获取当前的月份
    var currentDay = myDate.getDay();       // 获取当前的日子

    if(currentMonth = 12 && currentDay >= 24){
        document.getElementById("spanTime").innerHTML = "0天";
    }else{
        var d1 = new Date();//获取到当前的时间
        var d1Ms = d1.getTime();
        var d2 = new Date(currentYear,12,24);
        var d2Ms = d2.getTime();
        var differMs = d2Ms-d1Ms;//相差的毫秒数
        var date = parseInt(differMs/(3600*24*1000));//天
        document.getElementById("spanTime").innerHTML += date+"天";
    }

    $.ajax({
        url: "sentence/loadSentence",
        type: "POST",
        dataType: "json",
        contentType:"application/json; charset=utf-8", //前后台格式一致 防止乱码
        success: function (result) {
            $("#sentence").text(result);
        },
        error: function () {
            $("#sentence").text("我需要，最狂的风，和最静的海");
        }
    });

    loadDairy($.cookie('userId'));
}

//实时监听字数变化
$(document).ready(function(){
    $('#inputMessage').on('input focus keyup',
        function(){
            var strs   = getByteLen($(this).val());
            remain = 120-strs.length;
            var content_msg = "还可以输入"+remain+'字';
            document.getElementById("remainWord").innerText=content_msg;
        }
    );
});

//获取除标点符号之外的字数
function getByteLen(val) {
    strs = val.replace(/[\ |\~|\`|\!|\@|\#|\$|\%|\^|\&|\*|\(|\)|\-|\_|\+|\=|\||\\|\[|\]|\{|\}|\;|\:|\"|\'|\,|\<|\.|\>|\/|\?|\，|\。|\？|\：|\；|\‘|\’|\”|\“|\、|\·|\！|\（|\）|\》|\《|\『|\』]/g,"");
    //let recxType = /^[0-9A-Za-z\u4e00-\u9fa5]{15,}$/;
    return strs;
}

// 用户发布动态
$("#post").click(function(){
    var dairy ={
        userId: $.cookie('userId'),
        content: $("#inputMessage").val()
    }

    $.ajax({
        url: "user/postDairy",
        type: "POST",
        dataType: "json",
        data: dairy,
        success: function (result) {
            if(result != null){
                swal({
                    title: "记录成功",
                    icon: "success",
                    button: false,
                    timer: 1000,
                })
                $(".userDiary").remove();   // 移除现有的用户所有日志
                $("#inputMessage").val(""); // 清空输入框
                loadDairy($.cookie('userId'));
            }
            console.log(result);
        },
        error: function () {
            console.log("失败");
        }
    });
});

// 根据用户ID加载日志
function loadDairy(userId) {
    var user ={
        userId: userId
    }

    $.ajax({
        url: "user/loadDairy",
        type: "POST",
        dataType: "json",
        data: user,
        success: function (userDairy) {
            // 移除现有的所有已加载的日记
            $(".daily").remove();

            // 动态添加div
            for (var i in userDairy){
                var oneDiary =
                    "<div class=\"userDiary\">" +
                    "<h6 class=\"diaryTime\">\n" +
                    "<svg t=\"1585637507526\" class=\"icon\" viewBox=\"0 0 1024 1024\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" p-id=\"6229\" width=\"16\" height=\"16\"><path d=\"M0 0m102.4 0l819.2 0q102.4 0 102.4 102.4l0 819.2q0 102.4-102.4 102.4l-819.2 0q-102.4 0-102.4-102.4l0-819.2q0-102.4 102.4-102.4Z\" fill=\"#FA6557\" p-id=\"6230\"></path><path d=\"M512.8704 591.2576c-4.4544 0.6784-30.8736 27.008-39.7952 23.2448-7.5392-3.072 4.4672-30.4256-2.048-39.3216-6.528-8.8832-56.9344 0.3456-75.8016 9.2288-18.5216 8.896-49.0496 33.5104-59.6864 66.3296-10.2912 32.128-9.2544 67.008 9.2672 82.7392 18.5216 15.7184 45.952 1.7024 45.952 1.7024s0.3456 38.976 25.3824 44.4416c24.704 5.4784 73.7536-7.8592 98.0992-46.4896 24.3584-38.2976 18.176-99.1488 13.7216-118.976-4.4544-20.1728-10.624-23.936-15.104-22.912z m217.4592-11.6352c-31.5648-26.6624-130.3424-47.8592-145.088-37.6064-15.104 10.2656 8.9216 35.2256 1.3696 39.3216-7.2064 4.4416-26.4064-16.7552-33.6128-14.016-7.2064 3.072-17.4976 61.8752-3.4304 98.112 14.0672 36.5824 66.5472 91.968 102.208 75.904 35.6736-16.064 30.8736-44.7872 30.8736-44.7872s48.3584 10.944 66.2016-19.1488c18.176-29.4016 6.1696-76.5824-18.5216-97.7792zM561.92 470.912c6.1696 4.7872 30.1824-5.8112 36.0064 0.3456 5.8368 6.144-31.2064 24.96-19.8912 38.976 11.3152 13.6704 102.5536 22.912 141.312 7.8592 34.6496-13.3376 65.856-47.1808 59.6864-88.2048-5.4912-34.1888-54.528-43.072-54.528-43.072s12.3392-37.2736-16.4736-51.6224c-50.7648-25.3056-87.808 16.4096-111.4752 54.3488-20.9152 33.5104-40.8192 76.5824-34.6368 81.3696z m-37.0432-226.6624c-34.9824-8.5504-61.7472 37.952-61.7472 37.952s-34.9824-6.1568-57.9584 15.3856c-28.1216 25.984-22.2976 63.9232 5.1456 99.4816 24.3456 31.4496 63.4496 57.4336 70.3104 54.016 6.8608-3.4176 6.1696-29.056 14.0672-31.4496 8.2304-2.7392 12.3392 36.9152 29.824 32.4736 17.5104-4.4416 61.7472-81.3696 62.0928-121.3696 1.024-35.5456-19.5456-76.2368-61.7344-86.4896zM366.0672 578.944c39.104-11.2768 87.808-25.6384 88.1536-39.3088 0.3328-12.992-41.1648-20.5184-37.3888-36.2496 2.048-7.8592 42.1888-1.7024 44.928-18.8032 2.4064-12.992-28.4672-49.2288-68.2496-68.7104-33.28-16.4096-87.4624-25.6384-111.1296 8.8832-19.8912 29.056 0.3456 60.864 0.3456 60.864s-34.6496 27.008-25.0496 56.3968c11.328 35.5584 63.808 49.5744 108.3904 36.928z\" fill=\"#FFFFFF\" p-id=\"6231\"></path></svg>\n" +
                    ""+userDairy[i].createTime +
                    "</h6>\n" +
                    "<p class=\"diaryContent\">" +
                    userDairy[i].content
                    +"</p><button type=\"button\" class=\"btn btn-dark deleteDiary\" id=\""+userDairy[i].id+"\">" +
                    "" +
                    "删除</button></div>";

                $("#diaryMain").append(oneDiary);

                $("#"+userDairy[i].id).bind("click",function (e) {
                    deleteDiary($(e.target).attr('id'));
                });
            }
        },
        error: function () {
            console.log("失败");
        }
    });
}

// 删除日志
function deleteDiary(diaryId){
    var user ={
        diaryId: diaryId,
        userId: $.cookie('userId')
    }

    console.log(user);

    $.ajax({
        url: "user/deleteDiary",
        type: "POST",
        dataType: "json",
        data: user,
        // contentType:"application/json; charset=utf-8", //contentType很重要
        success: function (result) {
            if (result == "1"){
                swal({
                    title: "删除成功",
                    text: "期待你的下一次记录生活",
                    icon: "success",
                    button: false,
                    timer: 1000,
                }).then(() => {
                    $(".userDiary").remove();
                    loadDairy($.cookie('userId'));
                });
            }else {
                swal("删除失败", {
                    buttons: false,
                    icon: "error",
                    timer: 1000,
                });
            }
            // console.log(result);
        },
        error: function () {
        }
    });
    // console.log(diaryId);
}

// 鼠标扫描头像出现框子选择
$(".user").mouseover(function () {
    $(".userInfo").show();
});

$(".userInfo").mouseleave(function () {
    $(".userInfo").hide();
});

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