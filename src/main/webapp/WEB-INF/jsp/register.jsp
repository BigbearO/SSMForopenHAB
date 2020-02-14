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
<link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">

</head>
<body>
 	<div class="container-fluid"style=" background-image: url(static/images/123456789.png);height:800px ">
		<div style="height:150px"></div>
		<div class="row">
		   
		  
			<div class="col-md-4"></div>
			
			<div class="col-md-4">
			<form role="form"  name="form" id="form" method="post" >

					<div class="form-group row">
					
						<div class="col-sm-10">
						
							<input type="text" class="form-control" id="inputName"
								placeholder="用户名" name="name" >
						</div>
					</div>
					<div class="form-group row">
					
						<div class="col-sm-10">
							<input type="password" class="form-control" id="inputPass"
								placeholder="输入6-10位的密码" name="pass" minlength="6" maxlength="10">
						</div>
					</div>
					<div class="form-group row">
						
						<div class="col-sm-10">
							<input type="text" class="form-control" id="address"
								placeholder="地址" name="address">
						</div>
					</div>
					<div class="form-group row">
						
						<div class="col-sm-10">
							<input type="text" class="form-control" id="phone" placeholder="请输入电话号码"   name="phone" minlength="11"  oninput = "value=value.replace(/[^\d]/g,'')">
						</div>
					</div>

					<div class="form-group row">
						<div class="col-sm-10">
							<!--  <button type="submit" class="btn btn-primary" >注册</button>-->
							<input type="button" class="btn btn-primary btn-block" value="注册" onclick="CheckForm()" />
						</div>
					</div>
					<div>已经注册，去<a href="toLogin.do">登录</a></div>
					<div>
					 ${msg1}
						 ${msg }
					</div>
				</form>
			</div>
			<div class="col-md-4"></div>
				

			</div>
		</div>
	</div>
	
	
	<!-- 上面那个不行就用这个href="javascript:window.location.href='login.jsp'" -->
	
	
	
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script  type="text/javascript">
		function CheckForm()
		{	var form = document.getElementById("form");
			var phone= document.getElementById("phone").value;
			var pass =document.getElementById("inputPass").value;
			var name =document.getElementById("inputName").value;
			var address =document.getElementById("address").value;

			if(phone==""|| pass=="" ||name=="" ||address==""){
				alert("您还有信息没有填写哦");				
				}
			else{
			if (phone.length !=3 )
			{alert("请输入3位长度电话号码!");
			}
			else{
				form.action="Register";}
				form.submit();
			}
		}
</script>
	
	<script src="static/jquery/jquery-3.3.1.slim.min.js"></script>
	<script src="static/popper/popper.min.js"></script>
	<script src="static/bootstrap/js/bootstrap.min.js"></script>
	
</body>
</html>