layui.use('laydate', function() {
    var laydate = layui.laydate;
    laydate.render({
        elem: '#test4'
        , type: 'time'
        ,format: 'HH:mm:ss'
    });
});

layui.use('laydate', function() {
    var laydate = layui.laydate;
    laydate.render({
        elem: '#test'
        , type: 'time'
        ,format: 'HH:mm:ss'
    });
});
layui.use('laydate', function() {
    var laydate = layui.laydate;
    laydate.render({
        elem: '#test2'
        , type: 'time'
        ,format: 'HH:mm:ss'
    });
});

function JTrim(s)
{
    return s.replace(/(^\s*)|(\s*$)/g, "");
}

function next_first() {//填写名字之后下一步
    var textname =document.getElementById("zhineng_name").value;
    var zhineng2_1 = document.getElementById("zhineng2_1");
    var zhineng1=document.getElementById("zhineng1");
    if(JTrim(textname) == "") {
        alert("请填写场景名,再点击进入下一步");
    }else {
        // $("#zhineng1").hide();
        //  $("#zhhineng2_1").show();
        var none ="none";
        var block ="block";
        if ( zhineng1.style.display !="none"){
            zhineng1.style.display ="none";
        }
        if(zhineng2_1.style.display !="block") {
            zhineng2_1.style.display = "block";
        }
    }
}
function next_second() {//填写名字之后下一步
    var textname =document.getElementById("zhineng_name").value;
    var zhineng2_2 = document.getElementById("zhineng2_2");
    var zhineng1=document.getElementById("zhineng1");
    if(textname == "") {
        alert("请填写场景名,再点击进入下一步");
    }else {
        // alert("t");
        zhineng1.style.display ="none";
        zhineng2_2.style.display = "block";
    }
}
function timer_to_chooseexe() {
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
        sub.setAttribute("onclick", "submittotimer()");
        tosec.setAttribute("value", "上一步1");
        exetimer.style.display ="none";
        zhineng2_1.style.display = "none";
        zhineng3.style.display = "block";
    }
}

function item_to_chooseexe() {
    var zhineng2_2 = document.getElementById("zhineng2_2");
    var zhineng3=document.getElementById("zhineng3");
    var tosec =document.getElementById("tosec");
    var sub=document.getElementById("submitto");
    // var test4=document.getElementById("item");//输入时分秒
    // var cron =document.getElementById("trigstatus");//cron表达式输入框
    // if(cron.value =="" || test4.value ==""){
    //     alert("请输入corn/选择时间");
    // } else {
        sub.setAttribute("onclick", "submittoitem()");
        tosec.setAttribute("value", "上一步2");
        zhineng2_2.style.display = "none";
        zhineng3.style.display = "block";
    // }
}
function item_to_fenlei() {//返回选择大类
    var zhineng2_2 = document.getElementById("zhineng2_2");
    var zhineng1=document.getElementById("zhineng1");
    zhineng2_2.style.display ="none";
    zhineng1.style.display ="block";
}
function timer_to_fenlei() {//返回选择大类
    var zhineng2_1 = document.getElementById("zhineng2_1");
    var zhineng1=document.getElementById("zhineng1");
    zhineng2_1.style.display ="none";
    zhineng1.style.display ="block";
}
function tosecond() {
        var tosec =document.getElementById("tosec");
        var zn3 =document.getElementById("zhineng3");
        //alert(tosec.value);
        if(tosec.value =="上一步1"){
            var zhineng2_1=document.getElementById("zhineng2_1");
            zn3.style.display="none";
            zhineng2_1.style.display="block";
        }else{
            if(tosec.value =="上一步2") {
                var zhineng2_2 = document.getElementById("zhineng2_2");
                zhineng2_2.style.display = "block";
                zn3.style.display = "none";
            }
        }
}

function submittoitem() {//返回填写名字
    var test =document.getElementById("test");
    var test2 =document.getElementById("test2");
    var  form =document.getElementById("form");
    if(test.value =="" || test2.value ==""){
            alert("请选择智能启动/结束时间");
    } else {
        form.action ="addtoitem.do";
        form.submit();
    }

  /*  $.ajax({
        type:"GET",
        async : false,
        cache : false,
        url:"addtoaddtoitem.do",
        data: $('#form').serialize(),
        dataType:"json",
        success:function(data){
            if (data == "验证码发送成功，请注意查收"){
            }else {
                alert("发送失败");
            }
        }
    });*/
}

function submittotimer() {//提交到选择硬件，时间
    var test =document.getElementById("test");
    var test2 =document.getElementById("test2");
    var  form =document.getElementById("form");
    form.action = "addtotimer.do";
    form.submit();

}

var items= {
    "Xiaomi_Mi_Wireless_Switch": {"低电量模式": "7"},
    "Xiaomi_Mi_Smart_Home_Gateway":
        {
            "开启声音": "8",
            "灯光颜色": "11",// color
            "灯光亮度调节": "12", //s三个都是DImmer
            "色温调节": "13",
            "体积": "14"
        },
    "Xiaomi_Door_Window_Sensor":{
        "门窗开关状态":"17", //contact
        "低电量模式":"18"// switch·
    },
    "Xiaomi_Mi_Motion_Sensor":{
        "低电量模式":"3",//-switch
        "监控走动":"5"// switch
    },
    "Xiaomi_Mi_Smart_Socket_Plug":{
        "是否在用 -inuse":"22",// 开关
        "供电":"23" // switch
    }
};

var itemofdevice =[
    [ {低电量模式: "2"}],
    [
        { 门窗开关状态:"12"} ,{ 低电量模式:"16"}//contact，和switch
    ],
    [
        { 低电量模式:"7"},{ 监控走动:"11"}//-switch
    ],
    [{ 是否在用:"3"},{供电:"4"}]//都是开关
]

var menchuangtri =[{ 省电模式:"1"},{门窗开关状态:"4"} ,{报警时长:"2"},{电量等级:"5"}]

var menchuangexe=[{ 省电模式:"1"}]//[{ 省电模式:"1"},{网关声音：}]

var shuzu1 =[

    [{状态改变:"changed"},{变为开启:"changed to on"},{变为关闭:"changed to off"},{从开到关:"changed from on to off"},{从关到开:"changed from off to on"}],
    [{状态改变:"changed"},{变为开启:"changed to OPEN"},{变为关闭:"changed to CLOSED"}],
    [{状态改变:"changed"}]
    [{状态改变:"changed"}]
]

var shuzu2 =[
    [{状态改变:"changed"},{变为开启:"changed to on"},{变为关闭:"changed to off"},{从开到关:"changed from on to off"},{从关到开:"changed from off to on"}],
]
function changestatus(){
    var firstchoose =document.getElementById('when_item_id');
    var soc = document.getElementById('when_item_status');
    var choice =shuzu1[firstchoose.selectedIndex];
    //  alert(choice);
    soc.options.length=0;
    //现在获取到了json的数组，目前要，将json格式化
    for(var i=0;i<choice.length;i++){
        for(var key in choice[i]){
            // alert(key+""+choice[i][key]);
            soc[i]=new Option(key,choice[i][key]);//text,value
        }
    }
}

function testjson(){
    var firstchoose =document.getElementById('device_name');
    var soc = document.getElementById('exeitem');
    var choice =menchuangtri[firstchoose.selectedIndex];
    //  alert(choice);
    soc.options.length=0;
    //现在获取到了json的数组，目前要，将json格式化
    for(var i=0;i<choice.length;i++){
        for(var key in choice[i]){
            // alert(key+""+choice[i][key]);
            soc[i]=new Option(key,choice[i][key]);//text,value
        }
    }
}


function testjson2(){
    var firstchoose =document.getElementById('when_device_name');
    var soc = document.getElementById('when_item_id');
    var choice =menchuangexe[firstchoose.selectedIndex];
    //  alert(choice);
    soc.options.length=0;
    //现在获取到了json的数组，目前要，将json格式化
    for(var i=0;i<choice.length;i++){
        for(var key in choice[i]){
            // alert(key+""+choice[i][key]);
            soc[i]=new Option(key,choice[i][key]);//text,value
        }
    }
}
$(function() {
//在这里将item
});