window.onload = function () {
    // 加载所有的模块
    loadAllModule();
    // 加载所有的角色
    loadAllRole();
}


// 加载所有的角色
function loadAllRole() {
    $.ajax({
        url: "../role/loadAllRole",
        type: "POST",
        // data: info,
        dataType: "json",
        success: function (result) {
            var first =
                "<a onclick=\"loadPermission(this);\" class=\"list-group-item list-group-item-action active\" id=\""+result[0].id+"\" data-toggle=\"list\" href=\"#\" role=\"tab\">"+result[0].name+"</a>";
            $('#roleId').html(result[0].id);

            $('#listOfRole').append(first);

            if(result.length > 1){
                for(var i = 1; i < result.length; i++){
                    var item =
                        "<a onclick=\"loadPermission(this);\" class=\"list-group-item list-group-item-action\" id=\""+result[i].id+"\" data-toggle=\"list\" href=\"#\" role=\"tab\">"+result[i].name+"</a>";
                    $('#listOfRole').append(item);
                }
            }
        },
        error: function () {
        }
    });
}

// 加载所有的模块
function loadAllModule() {
    $.ajax({
        url: "../module/loadAllModule",
        type: "POST",
        // data: info,
        dataType: "json",
        success: function (result) {
            for (var i in result){
                var item =
                    "<label class=\"custom-control custom-checkbox\">" +
                    "<input onclick=\"modifyPermission(this);\" type=\"checkbox\" class=\"custom-control-input\" id=\""+result[i].id+"\"><span class=\"custom-control-label\">"+result[i].name+"</span>" +
                    "</label>";

                $('#listOfMudule').append(item);
            }
        },
        error: function () {
        }
    });
}

// 加载角色的权限
function loadPermission(subject) {
    removeAllChecked();
    $('#roleId').html(subject.id);
    $.ajax({
        url: "../permission/loadAllPermission",
        type: "POST",
        // data: info,
        dataType: "json",
        success: function (result) {
            for (var i in result){
                if(result[i].roleId == subject.id){
                    $("#"+result[i].moduleId).prop("checked", true);
                }
            }
        },
        error: function () {
        }
    });
    // alert(subject.id);
}

// 清空所有的checkbox选中
function removeAllChecked() {
    $("#listOfMudule input:checkbox").each(function () {
        $(this).prop("checked",false);
    });
}


function modifyPermission(subject) {
    if($("#"+subject.id).prop("checked")){
        var info = {
            roleId: $('#roleId').html(),
            moduleId: subject.id
        }

        $.ajax({
            url: "../permission/addPermission",
            type: "POST",
            data: info,
            dataType: "json",
            success: function (result) {
                $("#"+subject.id).prop("checked",true);
            },
            error: function () {
            }
        })

    }else{
        var info = {
            roleId: $('#roleId').html(),
            moduleId: subject.id
        }

        $.ajax({
            url: "../permission/deletePermission",
            type: "POST",
            data: info,
            dataType: "json",
            success: function (result) {
                $("#"+subject.id).prop("checked",false);
            },
            error: function () {
            }
        })
    }

}
