window.onload = function () {
    loadAllUser();
}

// 加载所有的用户信息
function loadAllUser() {
    // 加载院校的题库
    $.ajax({
        url: "../user/loadAllUser",
        type: "POST",
        dataType: "json",
        success: function (result) {
            $('#user').bootstrapTable('load',result);
            $('#user').bootstrapTable('hideColumn','id');
        },
        error: function () {
        }
    });
}

//操作栏的格式化
function actionFormatter(value, row, index) {
    return[
        '<a href="#" class="btn btn-outline-primary" id="modify" data-toggle="modal" data-target="#modifyUser">编辑</a>',
        '<a href="#" class="btn btn-outline-primary" id="delete"">删除</a>',
    ].join('');

}

/*每行表格尾部的小图标点击*/
window.operateEvents = {
    'click #modify':function (e,value,row,index) {
        $('#userName').val(row.name);
        $('#account').val(row.account);
        $('#password').val(row.password);
        $('#email').val(row.email);
        $('#phoneNumber').val(row.phoneNumber);
        $('#address').val(row.address);
        $('#userId').html(row.id);
    },
    'click #delete':function (e,value,row,index) {
        var info = {
            id: row.id
        }

        $.ajax({
            url: "../user/deleteUser",
            type: "POST",
            data: info,
            dataType: "json",
            success: function (result) {
                console.log(result);
                if(result == "1"){
                    swal({
                        title: "删除成功",
                        icon: "success",
                        button: false,
                        timer: 1000,
                    }).then(() => {
                        loadAllUser();
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
    var info = {
        id: $('#userId').html(),
        name: $('#userName').val(),
        account: $('#account').val(),
        password: $('#password').val(),
        email: $('#email').val(),
        phoneNumber: $('#phoneNumber').val(),
        address: $('#address').val()
    }

    $.ajax({
        url: "../user/modifyUser",
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
                    $('#modifyUser').modal('hide');
                    loadAllUser();
                });
            }
        },
        error: function () {
        }
    });
});


// 删除按钮事件
$("#removeUser").on("click", function() {
    if (!confirm("是否确认删除？"))
        return;
    var rows = $("#user").bootstrapTable('getSelections');// 获得要删除的数据
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
            url: "../user/deleteUser",
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
            loadAllUser();
        });
    }else{
        swal({
            title: "删除失败",
            icon: "error",
            button: false,
            timer: 1000,
        }).then(() => {
            loadAllUser();
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
        field: 'email',
        title: '邮箱',
        align: 'center',
        valign: 'middle',
    },{
        field: 'phoneNumber',
        title: '手机号码',
        align: 'center',
        valign: 'middle',
    },{
        field: 'address',
        title: '地址',
        align: 'center',
        valign: 'middle',
    },{
        field: 'createTime',
        title: '创建时间',
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
