window.onload = function () {
    var schoolInfo = {
        schoolId:"e15ecd64cb3946b68cff742c38392220"
    };

    // 加载所有的省份
    $.ajax({
        url: "../../question/loadQuestionBySchool",
        type: "POST",
        dataType: "json",
        data: schoolInfo,
        contentType:"application/json; charset=utf-8", //前后台格式一致 防止乱码
        success: function (result) {
            $('#papper').bootstrapTable('load',result);
            $('#papper').bootstrapTable('hideColumn','id');
            console.log(result);
        },
        error: function () {
            // $("#sentence").text("我需要，最狂的风，和最静的海");
        }
    });
}

//操作栏的格式化
function actionFormatter(value, row, index) {
    return[
        '<a id="look"">查看</a>',
    ].join('');

}

/*每行表格尾部的小图标点击*/
window.operateEvents = {
    'click #look':function (e,value,row,index) {
        //alert("进入查看弹框")
        //将该行数据填入模态框中
        alert("试卷编号："+row.id);
    },
};

$('#papper').bootstrapTable({
    // url: "../../question/loadQuestionBySchool",
    // data: data,
    // queryParams: "queryParams",
    // toolbar: "#toolbar",
    // sidePagination: "true",
    striped: true, // 是否显示行间隔色
    // search : "true",
    uniqueId: "ID",
    // pageSize: "5",
    // pagination: true, // 是否分页
    sortable: true, // 是否启用排序
    columns: [{
        field: 'id',
        title: '编号',
        align: 'center',
        valign: 'middle',
    },
    {
        field: 'year',
        title: '年份',
        align: 'center',
        valign: 'middle',
    },
    {
        field: 'name',
        title: '学校',
        width: 120,
        align: 'center',
        valign: 'middle',
    },
    {
        field: 'codeId',
        title: '专业代码',
        align: 'center',
        valign: 'middle',
    },
    {
        field: 'heat',
        title: '热度指数',
        align: 'center',
        valign: 'middle',
    },
    {
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

