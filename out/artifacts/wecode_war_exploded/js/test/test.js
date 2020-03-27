$("#upload").click(function () {
    var fileName=$("#fileName").val();
    var formData = new FormData($('#uploadForm')[0]);//序列化表单，将上传类型设置为文件对象
    if(fileName==""){
        alert("请选择文件进行上传");
        return false;
    }else{
        $.ajax({
            type: 'post',
            url: "user/uploadPhoto",
            data: formData,
            cache: false,//文件不设置缓存
            processData: false,//数据不被转换为字符串
            contentType: false,//上传文件时使用，避免 JQuery 对其操作
            success: function (data) {
                alert("上传成功");
                $("img").empty();
                $('body').append('<img src='+ data + ' width=\"85px\" height=\"100px\">');//将图片显示出来
            },
            error: function () {
                alert("上传失败");
            }
        });

    }
});

function upImg(){
    var formData = new FormData();
    formData.append("ymimg", document.getElementById("file").files[0]);
                          // ↑与图片的字段名保持一致
    $.ajax({type:"post",
        url:"user/uploadPhoto",
        //控制层请求得方法
        data:formData,
        contentType: false,// 	必须是false （固定）
        processData: false,//  必须是false（固定）
        success:function(msg){
            var str = "<img src='${pageContext.request.contextPath }/"+msg+"' width='100px' height='100px'>"
            $("#showimg").html(str)//将获取到的图片路径放入上方定义的div中
            $("#imghd").val(msg)//添加的name传值
        }
    })
}
