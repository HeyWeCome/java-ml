window.onload = function () {
    loadAllQuestion();
}

// 加载数据结构的数据
$("#checkAll").click(function(){
    // 加载院校的题库
    $.ajax({
        url: "question/loadAllQuestion",
        type: "POST",
        dataType: "json",
        success: function (result) {
            $('#papper').bootstrapTable('load',result);
            $('#papper').bootstrapTable('hideColumn','id');
            $('#papper').bootstrapTable('refresh');
        },
        error: function () {
        }
    });
});

// 加载数据结构的数据
$("#dataStructure").click(function(){
    var info = {
        classify: "数据结构",
    };

    $.ajax({
        url: "question/loadQuestionByClassify",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            $('#papper').bootstrapTable('load',result);
            $('#papper').bootstrapTable('hideColumn','id');
            $('#papper').bootstrapTable('refresh');
        },
        error: function () {
        }
    });
});

// 加载计算机网络的数据
$("#network").click(function(){
    var info = {
        classify: "计算机网络",
    };

    $.ajax({
        url: "question/loadQuestionByClassify",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            $('#papper').bootstrapTable('load',result);
            $('#papper').bootstrapTable('hideColumn','id');
            $('#papper').bootstrapTable('refresh');
        },
        error: function () {
        }
    });
});

// 加载计算机组成原理的数据
$("#composition").click(function(){
    var info = {
        classify: "计算机组成原理",
    };

    $.ajax({
        url: "question/loadQuestionByClassify",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            $('#papper').bootstrapTable('load',result);
            $('#papper').bootstrapTable('hideColumn','id');
            $('#papper').bootstrapTable('refresh');
        },
        error: function () {
        }
    });
});

// 加载操作系统的数据
$("#opSystem").click(function(){
    var info = {
        classify: "操作系统",
    };

    $.ajax({
        url: "question/loadQuestionByClassify",
        type: "POST",
        dataType: "json",
        data: info,
        success: function (result) {
            $('#papper').bootstrapTable('load',result);
            $('#papper').bootstrapTable('hideColumn','id');
            $('#papper').bootstrapTable('refresh');
        },
        error: function () {
        }
    });
});

// 加载所有的题库信息
function loadAllQuestion() {
    // 加载院校的题库
    $.ajax({
        url: "question/loadAllQuestion",
        type: "POST",
        dataType: "json",
        success: function (result) {
            $('#papper').bootstrapTable('load',result);
            $('#papper').bootstrapTable('hideColumn','id');
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
        $.cookie('subjectId',row.id);
        location.href="subject.html";
        // alert("题目编号："+row.id);
    },
};

$('#papper').bootstrapTable({
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
        field: 'questionId',
        title: '序号',
        align: 'center',
        formatter: function (value, row, index) {
            //获取每页显示的数量
            // var pageSize = $('#table').bootstrapTable('getOptions').pageSize;
            // console.log("pagesize:"+pageSize);
            // //获取当前是第几页
            // var pageNumber = $('#table').bootstrapTable('getOptions').pageNumber;
            // console.log("pageNumber:"+pageNumber);
            //
            // //返回序号，注意index是从0开始的，所以要加上1
            // return pageSize * (pageNumber - 1) + index + 1;
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
        width: 120,
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

