window.onload = function () {
    loadAllCorrect();
}

// 加载所有的员工信息
function loadAllCorrect() {
    // 加载所有的员工信息
    $.ajax({
        url: "../error/loadError",
        type: "POST",
        dataType: "json",
        success: function (result) {
            $('#correct').bootstrapTable('load',result);
            $('#correct').bootstrapTable('hideColumn','id');
        },
        error: function () {
        }
    });
}


/*每行表格尾部的小图标点击*/
window.operateEvents = {
    'click #refuse':function (e,value,row,index) {
        if (!confirm("是否确认驳回？"))
            return;

        var info = {
            id : row.id,
            status : "2"
        }

        $.ajax({
            url: "../error/modifyStatus",
            type: "POST",
            data: info,
            dataType: "json",
            success: function (result) {
                if(result == "1"){
                    swal({
                        title: "驳回成功",
                        icon: "success",
                        button: false,
                        timer: 1000,
                    }).then(() => {
                        loadAllCorrect();
                    });
                }else {
                    swal({
                        title: "驳回失败",
                        icon: "error",
                        button: false,
                        timer: 1000,
                    }).then(() => {
                        loadAllCorrect();
                    });
                }
            },
            error: function () {
            }
        });
    },
    'click #pass':function (e,value,row,index) {
        if (!confirm("是否确认通过？"))
            return;

        var info = {
            id : row.id,
            status : "1"
        }

        $.ajax({
            url: "../error/modifyStatus",
            type: "POST",
            data: info,
            dataType: "json",
            success: function (result) {
                if(result == "1"){
                    swal({
                        title: "通过成功",
                        icon: "success",
                        button: false,
                        timer: 1000,
                    }).then(() => {
                        loadAllCorrect();
                    });
                }else {
                    swal({
                        title: "通过失败",
                        icon: "error",
                        button: false,
                        timer: 1000,
                    }).then(() => {
                        loadAllCorrect();
                    });
                }

            },
            error: function () {
            }
        });
    },
    'click #delete':function (e,value,row,index) {
        if (!confirm("是否确认删除？"))
            return;

        var info = {
            id:row.id
        }

        $.ajax({
            url: "../error/delete",
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
                        loadAllCorrect();
                    });
                }else{
                    swal({
                        title: "删除失败",
                        icon: "error",
                        button: false,
                        timer: 1000,
                    }).then(() => {
                        loadAllCorrect();
                    });
                }
            },
            error: function () {
            }
        });
    },
};



// 删除按钮事件
$("#removeCorrect").on("click", function() {
    if (!confirm("是否确认删除？"))
        return;
    var rows = $("#correct").bootstrapTable('getSelections');// 获得要删除的数据
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
            url: "../error/delete",
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
            loadAllCorrect();
        });
    }else{
        swal({
            title: "删除失败",
            icon: "error",
            button: false,
            timer: 1000,
        }).then(() => {
            loadAllCorrect();
        });
    }
}

//操作栏的格式化
function actionFormatter(value, row, index) {
    return[
        '<a href="#" class="btn btn-outline-primary" id="refuse">驳回</a>',
        '<a href="#" class="btn btn-outline-primary" id="pass">通过</a>',
        '<a href="#" class="btn btn-outline-primary" id="delete"">删除</a>',
    ].join('');
}


$('#correct').bootstrapTable({
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
        field: 'title',
        title: '题目',
        width:350,
        align: 'center',
        valign: 'middle',
    },{
        field: 'reason',
        title: '纠错信息',
        align: 'center',
        valign: 'middle',
    },{
        field: 'name',
        title: '纠错人',
        align: 'center',
        valign: 'middle',
    },{
        field: 'time',
        title: '时间',
        align: 'center',
        valign: 'middle',
    },{
        field: 'status',
        title: '状态',
        align: 'center',
        valign: 'middle',
        formatter:function(value, row, index) {
            if(row.status == "1"){
                return[
                    '<span class="mr-2"><span class="badge-dot badge-success"></span>已处理</span>',
                ].join('');
            }else if(row.status == "0"){
                return[
                    '<span class="mr-2"><span class="badge-dot badge-primary"></span>待处理</span>',
                ].join('');
            }else{
                return[
                    '<span class="mr-2"><span class="badge-dot badge-danger"></span>无效</span>',
                ].join('');
            }
        }
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
