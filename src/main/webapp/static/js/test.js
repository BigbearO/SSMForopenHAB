var i=0;

function check(str){
    return /^[\da-zA-Z]+$/i.test(str);//正则校验只含有数字和字母
}

function check_login_form(){
    var form = document.getElementById("login_form");
    var pass =document.getElementById("pass").value;
    var name =document.getElementById("xingming").value;
    var testinput =/^[0-9a-zA-Z]*$/g;
    if(pass=="" ||name==""){
        alert("您还有没有填写完整哦");
    }
    else{
        if(check(name) && check(pass)) {
            form.action = "login.do";
            form.submit();
        }
        else {
            alert("请不要输入特殊字符");
        }
    }
}
function check_miyue() {
    var form = document.getElementById("miyue_form");
    var miyue = document.getElementById("miyue").value;
    var testinput =/^[0-9a-zA-Z]*$/g;
    if (miyue == "") {
        alert("还没有填写密钥哦");
    } else {
        if(check(miyue)) {
            form.action = "TestMiyue.do";
            form.submit();
        }
        else {
            alert("请不要输入特殊字符");
        }

    }
}
function check_reg_form(){
    var repass =document.getElementById("repass").value;
    var form = document.getElementById("reg_form");
    var pass =document.getElementById("pass").value;
    var name =document.getElementById("xingming").value;
    if(pass=="" ||name==""|| repass==""){
        alert("您还有没有填写完整哦");
    }
    else{
        if(repass == pass ) {
            if (pass.length <6 || pass.length > 14) {
                alert(pass.length);
                confirm("密码长度应为6-14位");
            }
            else {
                if (/[a-zA-Z0-9_]+/.test(pass)){
                    form.action = "Reg";
                    form.submit();
                }else {
                    alert("密码只包含英文或数字");
                }
            }
        }
        else {
            alert("两次密码不一致");
            }

    }
}

function clock(){
    var time =  document.getElementById("clock");
    var time2 = convert(new Date());
    time.value = time2;

}var t = setInterval(clock,1000);
function convert(date) {
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    var h = date.getHours();
    h=h < 10 ? ('0' + h) : h;
    var minute = date.getMinutes();
    minute = minute < 10 ? ('0' + minute) : minute;
    var second=date.getSeconds();
    second=second < 10 ? ('0' + second) : second;
    return y + '-' + m + '-' + d+' '+h+':'+minute+':'+second;
}










