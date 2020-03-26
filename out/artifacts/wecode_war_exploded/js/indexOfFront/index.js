var timer = null;
window.onload = function () {
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
        document.getElementById("spanTime").innerHTML = date+"天";
    }

    // 天气模块
    var weather = new Array("rain","storm","sunny","snow");
    var number = Math.floor(Math.random()*4);
    document.getElementById('weather').className = weather[number];

    $.ajax({
        url: "sentence/loadSentence",
        type: "POST",
        dataType: "json",
        // data: user,
        contentType:"application/json; charset=utf-8", //前后台格式一致 防止乱码
        success: function (result) {
            $("#sentence").text(result);
        },
        error: function () {
            $("#sentence").text("我需要，最狂的风，和最静的海");
        }
    });

    loadDairy("1");
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
        userId: "1",
        content: $("#inputMessage").val()
    }

    console.log(dairy);
    $.ajax({
        url: "user/postDairy",
        type: "POST",
        dataType: "json",
        data: dairy,
        success: function (result) {
            if(result != null){
                alert("插入成功");
                loadDairy("1");
            }
            console.log(result);
        },
        error: function () {
            console.log("失败");
        }
    });
});

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
            console.log("查询出来的日志为");
            console.log(userDairy);
            // 移除现有的所有已加载的日记
            $(".daily").remove();

            // 动态添加div
            for (var i in userDairy){
                var oneDiary =
                    "<div class=\"daily\" id=\""+userDairy[i].id+"\" >" +
                    " <div class=\"card dailyCard text-sm-left\">" +
                    " <div class=\"card-body\">" +
                    "<p class=\"card-text\">" +
                        userDairy[i].content+
                    "</p>" +
                    "</div>" +
                    "<div class=\"card-footer text-muted text-sm-right\">\n" +
                    "发布于"+userDairy[i].createTime +
                    "</div>" +
                    "</div>";
                $(".middleBody").append(oneDiary);

                console.log(oneDiary);
            }
        },
        error: function () {
            console.log("失败");
        }
    });
}