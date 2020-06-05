
function up_timer_to_chooseexe() {
    var zhineng2_1 = document.getElementById("zhineng2_1");
    var zhineng3=document.getElementById("zhineng3");
    var tosec =document.getElementById("tosec");
    var sub=document.getElementById("submitto");
    var exetimer =document.getElementById("exetimer");

    var test4=document.getElementById("test4");//输入时分秒
    var cron =document.getElementById("cron");//cron表达式输入框
    if( test4.value ==""){//cron.value =="" ||
        alert("请输入选择时间");
    } else {
        sub.setAttribute("onclick", "up_submittotimer()");
        tosec.setAttribute("value", "上一步1");
        exetimer.style.display ="none";
        zhineng2_1.style.display = "none";
        zhineng3.style.display = "block";
    }
}

function up_item_to_chooseexe() {
    var zhineng2_2 = document.getElementById("zhineng2_2");
    var zhineng3=document.getElementById("zhineng3");
    var tosec =document.getElementById("tosec");
    var sub=document.getElementById("submitto");
    // var test4=document.getElementById("item");//输入时分秒
    // var cron =document.getElementById("trigstatus");//cron表达式输入框
    // if(cron.value =="" || test4.value ==""){
    //     alert("请输入corn/选择时间");
    // } else {
    sub.setAttribute("onclick", "up_submittoitem()");
    tosec.setAttribute("value", "上一步2");
    zhineng2_2.style.display = "none";
    zhineng3.style.display = "block";
    // }
}

function up_submittoitem() {//返回填写名字
    var test =document.getElementById("test");
    var test2 =document.getElementById("test2");
    var  form =document.getElementById("form");
    if(test.value =="" || test2.value ==""){
        alert("请选择智能启动/结束时间");
    } else {
        form.action ="updateitemrules.do";
        form.submit();
    }
}

function up_submittotimer() {//提交到选择硬件，时间
    var test =document.getElementById("test");
    var test2 =document.getElementById("test2");
    var  form =document.getElementById("form");
    form.action = "updatetimerrules.do";
    form.submit();

}