function zhankai() {
    var zhankai = document.getElementById("zhankai");
    var xiangqing = document.getElementById("xiangqing");
    if (zhankai.innerText == "展开") {
        xiangqing.style.display = "block";
        zhankai.innerHTML = "收起";
    } else {
        if (zhankai.innerText == "收起") {
            xiangqing.style.display = "none";
            zhankai.innerHTML = "展开";
        }
    }
}

var kuang = document.getElementById("iframe");
function zdy() {
    kuang.setAttribute("src","toqingjing");
    // kuang.src ="https://www.baidu.com/"
}
function paper() {
//    kuang.src ="https://www.w3school.com.cn/";
    kuang.setAttribute("src","https://www.baidu.com/");
}
function basic() {
    //kuang.src ="https://www.w3school.com.cn/";
    kuang.setAttribute("src","https://www.w3school.com.cn/");
}
function zhanghao() {
    kuang.setAttribute("src","touser_admin");//touser_admin
}
function miyue() {
    kuang.setAttribute("src","tomiyue");
}

function clock(){
    var time =  document.getElementById("clock");
    var time2 = convert(new Date());
    time.value = time2;
    time.setAttribute("width","150px")

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
