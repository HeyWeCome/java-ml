window.onload = function () {
    loadAllEmployee();
    loadRoleListInAdd();

    var info = {
        id: $.cookie('employeeId')
    }

    console.log(info);

    $.ajax({
        url: "../user/loadModule",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            console.log(result);
            var flag = 0;
            $('#leftNav').find('li').each(function() {
                flag = 0;
                for(var i in result){
                    if (result[i] == $(this).attr("data-name")){
                        flag = 1;
                    }
                }
                if(flag == 0){
                    $(this).hide();
                }
            })
        },
        error: function () {

        }
    });
}

// 加载所有的员工信息
function loadAllEmployee() {
    // 加载所有的员工信息
    $.ajax({
        url: "../employee/loadAllEmployeeAndRole",
        type: "POST",
        dataType: "json",
        success: function (result) {
            $('#employee').bootstrapTable('load',result);
            $('#employee').bootstrapTable('hideColumn','id');
        },
        error: function () {
        }
    });
}

// 用户的时候选择加载角色
function loadRoleListInAdd() {
    // 加载所有的角色信息
    $.ajax({
        url: "../role/loadAllRole",
        type: "POST",
        dataType: "json",
        success: function (result) {

            for (var i in result) {
                var role =
                    "<option id=\"" + result[i].id + "\">" + result[i].name + "</option>";
                $('#roleList').append(role);
                $('#modifyRoleList').append(role);
            }
        },
        error: function () {
        }
    });
}

//操作栏的格式化
function actionFormatter(value, row, index) {
    return[
        '<a href="#" class="btn btn-outline-primary" id="modify" data-toggle="modal" data-target="#modifyEmployee">编辑</a>',
        '<a href="#" class="btn btn-outline-primary" id="delete"">删除</a>',
    ].join('');

}

/*每行表格尾部的小图标点击*/
window.operateEvents = {
    'click #modify':function (e,value,row,index) {
        $('#name').val(row.name);
        $('#account').val(row.account);
        $('#password').val(row.password);
        $('#sex').val(row.sex);
        $('#employeeId').html(row.id);
    },
    'click #delete':function (e,value,row,index) {
        var info = {
            id: row.id
        }

        $.ajax({
            url: "../employee/deleteEmployee",
            type: "POST",
            data: info,
            dataType: "json",
            success: function (result) {
                if(result == "1"){
                    swal({
                        title: "删除成功",
                        icon: "success",
                        button: false,
                        timer: 1000,
                    }).then(() => {
                        loadAllEmployee();
                    });
                }
            },
            error: function () {
            }
        });
    },
};

// 更改用户的信息
$("#postModify").on("click", function() {

    var sex;
    if($("#boy2").prop('checked')){
        sex = "1";
    }
    if($("#girl2").prop('checked')){
        sex = "0";
    }

    var info = {
        id: $('#employeeId').html(),
        name: $('#name').val(),
        account: $('#account').val(),
        password: $('#password').val(),
        sex: sex,
        role: $("#modifyRoleList option:selected").attr("id")
    }

    $.ajax({
        url: "../employee/modifyEmployee",
        type: "POST",
        data: info,
        dataType: "json",
        success: function (result) {
            if(result == "1"){
                swal({
                    title: "修改成功",
                    icon: "success",
                    button: false,
                    timer: 1000,
                }).then(() => {
                    $('#modifyEmployee').modal('hide');
                    loadAllEmployee();
                });
            }
        },
        error: function () {
        }
    });
});

// 新增员工
$('#postAdd').click(function () {
    var employeeName = $('#addName').val();
    var addAccount = $('#addAccount').val();
    var addPassword = $('#addPassword').val();
    var sex;
    var roleId = $("#roleList option:selected").attr("id");

    if($("#boy").prop('checked')){
        sex = "1";
    }
    if($("#girl").prop('checked')){
        sex = "0";
    }

    var info = {
        name:employeeName,
        account:addAccount,
        password:addPassword,
        sex:sex,
        role:roleId
    }

    $.ajax({
        url: "../employee/addEmployee",
        type: "POST",
        data: info,
        dataType: "json",
        success: function (result) {
            swal({
                title: "新增成功",
                icon: "success",
                button: false,
                timer: 1000,
            }).then(() => {
                $('#addEmployeeModal').modal('hide');
                loadAllEmployee();
            });
        },
        error: function () {
        }
    });
});

// 删除按钮事件
$("#removeEmployee").on("click", function() {
    if (!confirm("是否确认删除？"))
        return;
    var rows = $("#employee").bootstrapTable('getSelections');// 获得要删除的数据
    if (rows.length == 0) {// rows 主要是为了判断是否选中，下面的else内容才是主要
        alert("请先选择要删除的记录!");
        return;
    } else {
        var ids = new Array();// 声明一个数组
        $(rows).each(function() {// 通过获得别选中的来进行遍历
            ids.push(this.id);// cid为获得到的整条数据中的一列
        });
        deleteMs(ids);
    }
})

function deleteMs(ids) {
    var flag = 0;

    for(var i in ids){
        var info = {
            id: ids[i]
        }

        $.ajax({
            url: "../employee/deleteEmployee",
            type: "POST",
            data: info,
            dataType: "json",
            success: function (result) {
            },
            error: function () {
                flag = 1;
            }
        });
    }
    if(flag==0){
        swal({
            title: "删除成功",
            icon: "success",
            button: false,
            timer: 1000,
        }).then(() => {
            loadAllEmployee();
        });
    }else{
        swal({
            title: "删除失败",
            icon: "error",
            button: false,
            timer: 1000,
        }).then(() => {
            loadAllEmployee();
        });
    }
}


$('#employee').bootstrapTable({
    // url: "../../question/loadQuestionBySchool",
    // data: data,
    queryParams: "queryParams",
    toolbar: "#toolbar",
    // sidePagination: "true",
    striped: true, // 是否显示行间隔色
    search : "true",
    uniqueId: "id",
    pageNumber:1,               //初始化加载第一页，默认第一页
    pageSize: "5",
    pageList: [5,10,15,30],     //可供选择的每页的行数（*）
    pagination: true,           // 是否分页
    sortable: true,             // 是否启用排序
    clickToSelect: true,        // 是否启用点击选中行
    // showToggle: true, // 是否显示切换视图（table/card）按钮
    columns: [{
        checkbox:true
    },{
        field: 'id',
        title: '编号',
        align: 'center',
        valign: 'middle',
    },{
        field: '',
        title: '序号',
        width:20,
        align: 'center',
        formatter: function (value, row, index) {
            //获取每页显示的数量
            return index + 1;
        }
    },{
        field: 'name',
        title: '名称',
        align: 'center',
        valign: 'middle',
    },{
        field: 'account',
        title: '账号',
        width: 120,
        align: 'center',
        valign: 'middle',
    },{
        field: 'password',
        title: '密码',
        align: 'center',
        valign: 'middle',
    },{
        field: 'sex',
        title: '性别',
        align: 'center',
        valign: 'middle',
        formatter: function (value, row, index) {
            if(row.sex == "1"){
                return[
                    '男'
                ].join('');
            }else{
                return '女'
            }
        }
    },{
        field: 'roleName',
        title: '角色',
        align: 'center',
        valign: 'middle',
    },{
        field: 'todo',
        title: '操作',
        width: 120,
        align: 'center',
        valign: 'middle',
        events:operateEvents,
        formatter: actionFormatter,
    },
    ]
});
