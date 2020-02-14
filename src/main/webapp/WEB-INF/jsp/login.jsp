<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%request.setCharacterEncoding("utf-8"); %>	
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<style>
#form{
 position: absolute;
left:600px;
top:240px;
}

</style>
<!-- <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">  -->
</head>
<body>
	
			
			<div class="col-md-4">
			<form role="form"  action="login" method="post" id="form">

					
							<input type="text" class="form-control" id="inputName"
								placeholder="邮箱号" name="name"  value="${name }">
							&nbsp;&nbsp;&nbsp;
							<select  class="form-control">
   								 <option value ="@xhf.com">@xhf.com</option>
							</select>&nbsp;&nbsp;&nbsp;${msg}
						<br/><br/>
					
							<input type="password" class="form-control" id="inputPass"
								placeholder="密码" name="pass"><br/><br/>
					

							<input type="button" class="form-control" value="登录"
							 onclick="CheckForm()"/>
					<br/><br/>
					<div class="form-control">没有账号？去<a href="toRegister.do">注册</a></div>
					
				</form>

			</div>

	
	
	<!-- 上面那个不行就用这个href="javascript:window.location.href='register.jsp'" -->
	<script  type="text/javascript">
		function CheckForm()
		{	var form = document.getElementById("form");
			var pass =document.getElementById("inputPass").value;
			var name =document.getElementById("inputName").value;

			if(pass=="" ||name=="" ){
				alert("您还有信息没有填写哦");				
				}
			else{			
				form.action="login";}
				form.submit();
		}
</script>
	
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS 
	<script src="staticsource/jquery/jquery-3.3.1.slim.min.js"></script>
	<script src="staticsource/popper/popper.min.js"></script>
	<script src="staticsource/bootstrap/js/bootstrap.min.js"></script>
	-->
</body>
</html>