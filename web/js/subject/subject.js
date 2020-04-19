$(document).ready(function(){

    var lenInput = $('.textarea-item').val().length;

    $(".textarea-item").keyup(function(){
        lenInput = $(this).val().length;
        if(lenInput>0 && lenInput<=300){
            $('.textareaInput').html(lenInput);
            $('.textarea-btn').attr('disabled',false);
        }else{
            $('.textarea-btn').attr('disabled',true);
        }
    });
});