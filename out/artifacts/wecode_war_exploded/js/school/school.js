window.onload = function () {
    // 加载所有的省份
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

    // console.log(school);

    $.ajax({
        url: "school/loadSchoolByProvincial",
        type: "POST",
        dataType: "json",
        data: school,
        success: function (schools) {
            $("#result").empty();

            // 动态添加div
            for (var i in schools){
                var school =
                "<div class=\"itemSchool\" id=\""+schools[i].id+"\" onclick=\"loadSchoolDeatil(this);\">" +
                "<h6>"+schools[i].name+"</h6>" +
                "<p>共289套真题</p>" +
                "</div>";

                $("#result").append(school);

                console.log(schools[i]);
            }
        },
        error: function () {
        }
    });
}

// 点击搜索，模糊搜索院校信息
$("#doSearch").click(function(){
    var school ={
        keyword: $("#schoolName").val(),
    }

    if($("#schoolName").val() != "") {
        $.ajax({
            url: "school/searchSchool",
            type: "POST",
            dataType: "json",
            data: school,
            success: function (schools) {
                $("#dynamicSearch").empty();

                // 动态添加div
                for (var i in schools) {
                    var school =
                        "<div class=\"itemSchool\" id=\""+schools[i].id+"\" onclick=\"loadSchoolDeatil(this);\">" +
                        "<h6>" + schools[i].name + "</h6>" +
                        "<p>共289套真题</p>" +
                        "</div>";
                    $("#dynamicSearch").append(school);
                }
            },
            error: function () {
            }
        });
    }
});

// 不点击按钮，直接动态Ajax请求获取院校
// 监听用户名
$("#schoolName").bind("input propertychange", function() {

    var school ={
        keyword: $("#schoolName").val(),
    }

    if($("#schoolName").val() != ""){
        $.ajax({
            url: "school/searchSchool",
            type: "POST",
            dataType: "json",
            data: school,
            success: function (schools) {
                $("#dynamicSearch").empty();

                // 动态添加div
                for (var i in schools){
                    var school =
                        "<div class=\"itemSchool\" id=\""+schools[i].id+"\" onclick=\"loadSchoolDeatil(this);\">" +
                        "<h6>"+schools[i].name+"</h6>" +
                        "<p>共289套真题</p>" +
                        "</div>";

                    $("#dynamicSearch").append(school);
                }
            },
            error: function () {
            }
        });
    }
});

// 通过给div添加点击事件，加载院校信息
function loadSchoolDeatil(e){
    $.cookie('schoolId', e.id);
    location.href = "html/school/detail.html";
}