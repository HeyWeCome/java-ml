window.onload = function () {
    loadAllModule();

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

// 加载所有的用户信息
function loadAllModule() {
    // 加载院校的题库
    $.ajax({
        url: "../module/loadAllModule",
        type: "POST",
        dataType: "json",
        success: function (result) {
            $('#module').bootstrapTable('load',result);
            $('#module').bootstrapTable('hideColumn','id');
        },
        error: function () {
        }
    });
}

//操作栏的格式化
function actionFormatter(value, row, index) {
    return[
        '<a href="#" class="btn btn-outline-primary" id="modify" data-toggle="modal" data-target="#modifyModule">编辑</a>',
        '<a href="#" class="btn btn-outline-primary" id="delete"">删除</a>',
    ].join('');

}

/*每行表格尾部的小图标点击*/
window.operateEvents = {
    'click #modify':function (e,value,row,index) {
        $('#moduleName').val(row.name);
        $('#description').val(row.description);
        $('#moduleId').html(row.id);
        if(row.status == "启用"){
            $("#work").prop("checked",true);
        }else {
            $("#work").prop("checked",true);
        }
    },
    'click #delete':function (e,value,row,index) {
        if (!confirm("是否确认删除？"))
            return;

        var info = {
            id: row.id
        }

        $.ajax({
            url: "../module/deleteModule",
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
                        loadAllModule();
                    });
                }
            },
            error: function () {
            }
        });
    },
};


// 更改模块的信息
$("#postModify").on("click", function() {
    var status;
    if($("#work").prop('checked')){
        status = "1";
    }

    if($("#stop").prop('checked')){
        status = "0";
    }

    var info = {
        id: $('#moduleId').html(),
        name: $('#moduleName').val(),
        status: status,
        description: $('#description').val()
    }

    $.ajax({
        url: "../module/modifyModule",
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
                    $('#modifyModule').modal('hide');
                    loadAllModule();
                });
            }
        },
        error: function () {
        }
    });
});

// 新增模块的信息
$("#postAdd").on("click", function() {
    var status;
    if($("#addWork").prop('checked')){
        status = "1";
    }

    if($("#addWork").prop('checked')){
        status = "0";
    }

    var info = {
        name: $('#addmoduleName').val(),
        status: status,
        description: $('#addDescription').val()
    }

    $.ajax({
        url: "../module/addModule",
        type: "POST",
        data: info,
        dataType: "json",
        success: function (result) {
            if(result == "1"){
                swal({
                    title: "新增成功",
                    icon: "success",
                    button: false,
                    timer: 1000,
                }).then(() => {
                    $('#addOneModule').modal('hide');
                    loadAllModule();
                });
            }
        },
        error: function () {
        }
    });
});

// 删除按钮事件
$("#removeModule").on("click", function() {
    if (!confirm("是否确认删除？"))
        return;
    var rows = $("#module").bootstrapTable('getSelections');// 获得要删除的数据
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
            url: "../module/deleteModule",
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
            loadAllModule();
        });
    }else{
        swal({
            title: "删除失败",
            icon: "error",
            button: false,
            timer: 1000,
        }).then(() => {
            loadAllModule();
        });
    }
}

// 状态的的格式化
function handleStatus(value, row, index) {
    if(row.status == "启用"){
        return[
            '<span class="mr-2"><span class="badge-dot badge-success"></span>启用</span>',
        ].join('');
    }else {
        return[
            '<span class="mr-2"><span class="badge-dot badge-danger"></span>禁用</span>',
        ].join('');
    }
}

$('#module').bootstrapTable({
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
        width: 40,
        align: 'center',
        formatter: function (value, row, index) {
            //获取每页显示的数量
            return index + 1;
        }
    },{
        field: 'name',
        title: '模块名称',
        align: 'center',
        valign: 'middle',
    },{
        field: 'description',
        title: '模块描述',
        align: 'center',
        valign: 'middle',
    },{
        field: 'status',
        title: '状态',
        align: 'center',
        valign: 'middle',
        formatter: handleStatus,
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
