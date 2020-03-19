window.onload = function () {
    // 天气模块
    var weather = new Array("rain","storm","sunny","snow");
    var number = Math.floor(Math.random()*4);
    document.getElementById('weather').className = weather[number];

    $.ajax({
        url: "sentence/loadSentence",
        type: "POST",
        dataType: "json",
        // data: user,
        contentType:"application/json; charset=utf-8", //contentType很重要
        success: function (result) {
            console.log(result);
            $("#sentence").text(result);
        },
        error: function () {
            console.log("失败");
        }
    });
}

