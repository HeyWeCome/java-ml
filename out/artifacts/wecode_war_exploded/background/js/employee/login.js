$('#login').click(function () {

    var info ={
        account: $('#account').val(),
        password: $("#password").val()
    }

    $.ajax({
        url: "../employee/login",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            swal({
                title: "登录成功",
                text: "您好！"+result.name,
                icon: "success",
                button: false,
                timer: 1000,
            }).then(() => {
                if($("#rememberMe").is(':checked')){
                    $.cookie('employeeId', result.id);
                    $.cookie('employeeName', result.name);
                    $.cookie('employeeRole', result.roleId);

                    location.href="index.html";
                }else{
                    $.cookie('employeeId', result.id);
                    $.cookie('employeeName', result.name);
                    $.cookie('employeeRole', result.roleId);

                    location.href="index.html";
                }

            });
        },
        error: function () {
        }
    });
})