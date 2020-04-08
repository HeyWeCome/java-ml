$(function() {
    // 将DOM层的元素赋予变量
    var $tasksList = $("#tasksList");
    var $taskInput = $("#taskInput");
    var $notification = $("#notification");

    // 计算列表中的待办个数
    // 展示或者隐藏通知
    var displayNotification = function() {
        if (!$tasksList.children().length) {
            //$notification.css("display", "block");
            $notification.fadeIn("fast");
        } else {
            $notification.css("display", "none")
        }
    }

    // 添加任务事件
    $("#taskAdd").on("click", function() {
        addTodo();
    })

    // 添加任务事件,绑定回车事件
    $("#taskInput").keydown(function(e) {
        if(e.keyCode == 13){
            addTodo();
        }
    });


    var addTodo = function () {
        // 如果输入是空的，返回false
        if (!$taskInput.val()) {
            return false;
        }

        // 将输入的值作为li加入，后续加入数据库
        $tasksList.append("<li>" + $taskInput.val() + "<button class='delete'>&#10006</button></li>");

        // 添加成功之后清空输入框
        $taskInput.val("");

        // 展示或者隐藏“今天还没添加计划哦”那个提示
        displayNotification();

        // 删除事件
        $(".delete").on("click", function() {

            //分配 "this" 给变量，如果它没有与setTimeout（）函数一起正常工作
            var $parent = $(this).parent();

            // 展示CSS动画
            $parent.css("animation", "fadeOut .2s linear");

            // 延时执行移除
            setTimeout(function() {
                $parent.remove();
                displayNotification();
            }, 200);
        })
    }
});