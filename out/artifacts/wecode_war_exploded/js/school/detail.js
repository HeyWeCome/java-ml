window.onload = function () {
    loadSchoolInfo();
}

// 加载院校信息和题库
function loadSchoolInfo() {
    var schoolInfo = {
        schoolId: $.cookie('schoolId'),
    };

    console.log(schoolInfo);

    // 加载院校信息
    $.ajax({
        url: "school/searchSchoolById",
        type: "POST",
        dataType: "json",
        data: schoolInfo,
        success: function (result) {
            $('#nameOfSchool').html(result.name);                           // 赋值学校名称
            $('#websiteOfSchool').html(result.introduction);                // 赋值学校网站
            $('#websiteOfSchool').attr('href',result.introduction);         // 修改href
            $('#schoolAddress').html("地址："+result.location);              // 修改学校地址
            $('#postCode').html("邮编："+result.postcode);                   // 修改学校邮编
            $('#heat').html("热度："+result.heat);                           // 修改学校热度
            $('#photo').css("background-image","url(img/school/"+result.photo+")");   // 修改学校的头像

            console.log(result);
        },
        error: function () {
        }
    });

    // 加载院校的题库
    $.ajax({
        url: "question/loadQuestionBySchool",
        type: "POST",
        dataType: "json",
        data: schoolInfo,
        success: function (result) {
            $('#papper').bootstrapTable('load',result);
            $('#papper').bootstrapTable('hideColumn','id');
            console.log(result);
        },
        error: function () {
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

