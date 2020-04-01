window.onload = function () {
    // 加载所有的院校
    $.ajax({
        url: "provincial/loadProvincial",
        type: "POST",
        dataType: "json",
        contentType:"application/json; charset=utf-8", //前后台格式一致 防止乱码
        success: function (provincial) {
            // 动态添加div
            for (var i in provincial){
                var provincialItem = "<a class=\"provinceItem\"  id=\""+provincial[i].id+"\">" +
                    provincial[i].name +
                    "</a>"

                $("#province").append(provincialItem);

                $("#"+provincial[i].id).bind("click",function (e) {
                    loadSchoolByProvincial($(e.target).attr('id'));
                });
            }
        },
        error: function () {
            // $("#sentence").text("我需要，最狂的风，和最静的海");
        }
    });
}

// 根据省份查询学校
function loadSchoolByProvincial(provincialId){
    var school ={
        provincialId: provincialId,
    }

    console.log(school);

    $.ajax({
        url: "school/loadSchoolByProvincial",
        type: "POST",
        dataType: "json",
        data: school,
        success: function (result) {
            console.log(result);
        },
        error: function () {
        }
    });
}