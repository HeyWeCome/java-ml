window.onload = function () {
    loadAllDiscuss();

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

// 加载所有的留言
function loadAllDiscuss() {
    // 加载所有的员工信息
    $.ajax({
        url: "../questionDiscuss/loadAllQuestionDiscuss",
        type: "POST",
        dataType: "json",
        success: function (result) {
            $('#discuss').bootstrapTable('load',result);
            $('#discuss').bootstrapTable('hideColumn','id');
        },
        error: function () {
        }
    });
}

/*每行表格尾部的小图标点击*/
window.operateEvents = {
    'click #modify':function (e,value,row,index) {
        $('#discussId').html(row.id);
        $('#modifyContent').val(row.discussContent);
    },
    'click #delete':function (e,value,row,index) {
        if (!confirm("是否确认删除？"))
            return;

        var info = {
            id: row.id
        }

        $.ajax({
            url: "../questionDiscuss/deleteQuestionDiscuss",
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
                        loadAllDiscuss();
                    });
                }
            },
            error: function () {
            }
        });
    },
};

// 更改留言的信息
$("#postModify").on("click", function() {
    var info = {
        id: $('#discussId').html(),
        content: $('#modifyContent').val()
    }

    $.ajax({
        url: "../questionDiscuss/modifyDiscussContent",
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
                    $('#modifyDiscuss').modal('hide');
                    loadAllDiscuss();
                });
            }
        },
        error: function () {
        }
    });
});


// 删除按钮事件
$("#removeDiscuss").on("click", function() {
    if (!confirm("是否确认删除？"))
        return;
    var rows = $("#discuss").bootstrapTable('getSelections');// 获得要删除的数据
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
            url: "../questionDiscuss/deleteQuestionDiscuss",
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
            loadAllDiscuss();
        });
    }else{
        swal({
            title: "删除失败",
            icon: "error",
            button: false,
            timer: 1000,
        }).then(() => {
            loadAllDiscuss();
        });
    }
}

//操作栏的格式化
function actionFormatter(value, row, index) {
    return[
        '<a href="#" class="btn btn-outline-primary" id="modify" data-toggle="modal" data-target="#modifyDiscuss">编辑</a>',
        '<a href="#" class="btn btn-outline-primary" id="delete"">删除</a>',
    ].join('');
}


$('#discuss').bootstrapTable({
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
        field: 'questionContent',
        title: '留言所属题目内容',
        width:400,
        align: 'center',
        valign: 'middle',
    },{
        field: 'userName',
        title: '用户名',
        align: 'center',
        valign: 'middle',
    },{
        field: 'discussContent',
        title: '留言内容',
        align: 'center',
        valign: 'middle',
    },{
        field: 'time',
        title: '留言时间',
        width:100,
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
