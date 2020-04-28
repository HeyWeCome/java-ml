window.onload = function () {
    loadAllUser();
}

// 加载所有的题库信息
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
        '<a id="look"">查看</a>',
    ].join('');

}

/*每行表格尾部的小图标点击*/
window.operateEvents = {
    'click #look':function (e,value,row,index) {
        //alert("进入查看弹框")
        //将该行数据填入模态框中
        // $.cookie('subjectId',row.id);
        // location.href="subject.html";
        alert("用户ID："+row.id);
    },
};

$('#user').bootstrapTable({
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
