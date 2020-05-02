window.onload = function () {
    loadAllSubject();
    // loadProvincialListInAdd();

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

// 加载所有的题目
function loadAllSubject() {
    $.ajax({
        url: "../question/loadAllQuestion",
        type: "POST",
        dataType: "json",
        success: function (result) {
            $('#subject').bootstrapTable('load',result);
            $('#subject').bootstrapTable('hideColumn','id');
        },
        error: function () {
        }
    });
}

/*每行表格尾部的小图标点击*/
window.operateEvents = {
    'click #look':function (e,value,row,index) {
        var info = {
            subjectId : row.id
        }

        if(row.type == "单选题"){
            $.ajax({
                url: "../subject/getSubjectById",
                type: "POST",
                data: info,
                dataType: "json",
                success: function (result) {
                    swal({
                        text: "题目："+result.title+"\n"
                              +"A："+result.optionA+"\n"
                              +"B："+result.optionB+"\n"
                              +"C："+result.optionC+"\n"
                              +"D："+result.optionD+"\n",
                    });
                },
                error: function () {
                }
            });
        }

        if(row.type == "简答题"){
            $.ajax({
                url: "../subject/getSubjectById",
                type: "POST",
                data: info,
                dataType: "json",
                success: function (result) {
                    swal({
                        text: "题目："+result.title+"\n"
                            +"问题："+result.content+"\n",
                    });
                },
                error: function () {
                }
            });
        }


    },
    'click #modify':function (e,value,row,index) {
        var info = {
            subjectId : row.id
        }

        if(row.type == "单选题"){
            $.ajax({
                url: "../subject/getSubjectById",
                type: "POST",
                data: info,
                dataType: "json",
                success: function (result) {
                    $("#choiceId").html(result.id);
                    $("#modifyOfAddContent").val(result.title);
                    $("#optionA1").val(result.optionA);
                    $("#optionB1").val(result.optionB);
                    $("#optionC1").val(result.optionC);
                    $("#optionD1").val(result.optionD);
                    $('#modifySingleChoiceModal').modal('show');
                },
                error: function () {
                }
            });
        }

        if(row.type == "简答题"){
            $.ajax({
                url: "../subject/getSubjectById",
                type: "POST",
                data: info,
                dataType: "json",
                success: function (result) {
                    $("#shortAnsId").html(result.id);
                    $("#modifyOfShortContent").val(result.title);
                    $("#modifyContent").val(result.content);
                    $('#modifyShortAnsModal').modal('show');
                },
                error: function () {
                }
            });
        }
    },
    'click #delete':function (e,value,row,index) {
        if (!confirm("是否确认删除？"))
            return;

        var info = {
            id: row.id
        }

        $.ajax({
            url: "../subject/deleteSubject",
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
                        loadAllSubject();
                    });
                }
            },
            error: function () {
            }
        });
    },
};

// 新增简答题
$("#postAddShortAns").on("click", function() {
    var info = {
        title: $("#shortAnsContent").val(),
        classify: $("#classifyList2 option:selected").attr("data-id"),
        type:"2",
        content: $("#contentOfShortAns").val()
    }


    $.ajax({
        url: "../subject/addShortAns",
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
                    $('#addShortAns').modal('hide');
                    loadAllSubject();
                });
            }
        },
        error: function () {
        }
    });
});

// 新增单选题
$("#postAddOneChoice").on("click", function() {
    var info = {
        title: $("#content").val(),
        classify: $("#classifyList option:selected").attr("data-id"),
        type:"1",
        optionA: $("#optionA").val(),
        optionB: $("#optionB").val(),
        optionC: $("#optionC").val(),
        optionD: $("#optionD").val()
    }

    $.ajax({
        url: "../subject/addOneChoice",
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
                    $('#addSingleChoiceModal').modal('hide');
                    loadAllSubject();
                });
            }
        },
        error: function () {
        }
    });
});

// 修改单选题
$('#modifyAddOneChoice').click(function () {

    var info = {
        id: $("#choiceId").html(),
        title: $("#modifyOfAddContent").val(),
        classify: $("#classifyList3 option:selected").attr("data-id"),
        optionA:$("#optionA1").val(),
        optionB:$("#optionB1").val(),
        optionC:$("#optionC1").val(),
        optionD:$("#optionD1").val()
    }

    $.ajax({
        url: "../subject/modifyOneChoice",
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
                    $('#modifySingleChoiceModal').modal('hide');
                    loadAllSubject();
                });
            }else{
                swal({
                    title: "修改失败",
                    icon: "error",
                    button: false,
                    timer: 1000,
                }).then(() => {
                    $('#modifySingleChoiceModal').modal('hide');
                    loadAllSubject();
                });
            }

        },
        error: function () {
        }
    });
});

// 修改简答题
$('#modifyAddShortAns').click(function () {

    var info = {
        id: $("#shortAnsId").html(),
        title: $("#modifyOfShortContent").val(),
        classify: $("#classifyList3 option:selected").attr("data-id"),
        content: $("#modifyContent").val()
    }

    $.ajax({
        url: "../subject/modifyShortAns",
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
                    $('#modifyShortAnsModal').modal('hide');
                    loadAllSubject();
                });
            }else{
                swal({
                    title: "修改失败",
                    icon: "error",
                    button: false,
                    timer: 1000,
                }).then(() => {
                    $('#modifyShortAnsModal').modal('hide');
                    loadAllSubject();
                });
            }

        },
        error: function () {
        }
    });
});

// 删除按钮事件
$("#removeSubject").on("click", function() {
    if (!confirm("是否确认删除？"))
        return;
    var rows = $("#subject").bootstrapTable('getSelections');// 获得要删除的数据
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
            url: "../subject/deleteSubject",
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
            loadAllSubject();
        });
    }else{
        swal({
            title: "删除失败",
            icon: "error",
            button: false,
            timer: 1000,
        }).then(() => {
            loadAllSubject();
        });
    }
}

//操作栏的格式化
function actionFormatter(value, row, index) {
    return[
        '<a href="#" class="btn btn-outline-primary" id="look">查看</a>',
        '<a href="#" class="btn btn-outline-primary" id="modify">编辑</a>',
        '<a href="#" class="btn btn-outline-primary" id="delete">删除</a>',
    ].join('');
}


$('#subject').bootstrapTable({
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
            return index + 1;
        }
    },{
        field: 'title',
        title: '题目',
        align: 'center',
        valign: 'middle',
    },{
        field: 'classify',
        title: '分类',
        align: 'center',
        valign: 'middle',
    },{
        field: 'type',
        title: '题型',
        align: 'center',
        valign: 'middle',
    },{
        field: 'heat',
        title: '热度',
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
