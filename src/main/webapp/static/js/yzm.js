$(function(){

    /*仿刷新：检测是否存在cookie*/
    if($.cookie("captcha")){
        var count = $.cookie("captcha");
        var btn = $('#get_yanzhengm');
        btn.val(count+'秒后可重新获取').attr('disabled',true).css('cursor','not-allowed');
        var resend = setInterval(function(){
            count--;
            if (count > 0){
                btn.val(count+'秒后可重新获取').attr('disabled',true).css('cursor','not-allowed');
                $.cookie("captcha", count, {path: '/', expires: (1/86400)*count});
            }else {
                clearInterval(resend);
                btn.val("获取验证码").removeClass('disabled').removeAttr('disabled style');
            }
        }, 1000);
    }

    /*点击改变按钮状态，已经简略掉ajax发送短信验证的代码*/
    $('#get_yanzhengm').click(function(){//get_yanzhengm
        var mailadress =$("#mailadress").val();
        var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        // if (reg.test(mailadress)) {
        var btn = $(this);
        var count = 60;
        if (mailadress == "") {
            alert("请填写邮箱号")
            return false;
        }else {
            if(!reg.test(mailadress)){
                alert("请正确填写邮箱号");
                return false;
            }
        }

        var resend = setInterval(function(){
            count--;
            if (count > 0){
                btn.val(count+"秒后可重新获取");
                $.cookie("captcha", count, {path: '/', expires: (1/86400)*count});
            }else {
                clearInterval(resend);
                btn.val("获取验证码").removeAttr('disabled style');
            }
        }, 1000);
        btn.attr('disabled',true).css('cursor','not-allowed');

        $.ajax({
            type:"post",
            url:"SentMail.do",
            dataType:"json",
            data :{mailadress:mailadress},
            success : function(data){
                if(data =="success"){
                    var success =document.getElementById("suceess");
                    success.innerText ="验证码已发送，请注意查收";
                }
                else {
                    alert("验证码发送出现异常，")
                }
            }
        });
    });
});