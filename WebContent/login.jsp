<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/login.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/user/login.js"></script>
<link rel="stylesheet" href="css/toastr.css">
<script src="js/toastr.js"></script>
</head>
<body>
<div class="contain center-block">
	<div class="left">
		<div class="login-left center-block">
		<h1 style="color: white; font-size: 50px;">人创天地有限公司</h1>
		<h2 style="color: white; font-size: 30px;">——<B>账目管理系统</B></h2>
	<br>
		<div class="login-input-area ">
			<div class="input-group input-group-lg" >
			  	<span class="input-group-addon bg-info" id="basic-addon1" style="color: #285E8E;"><span class=" glyphicon glyphicon-user "></span> 账户：</span>
			 	<input id="login_username" type="text" class="form-control" placeholder="请输入用户名">
			</div>
	<br>
			<div class="input-group input-group-lg">
				<span class="input-group-addon" id="basic-addon2" style="color: #285E8E;"><span class="glyphicon glyphicon-lock"></span> 密码：</span>
				<input id="login_password" type="password" class="form-control" placeholder="请输入密码">
			</div>
		</div>
	<br>
	 	<!--按钮-->
	 	<div class="login-button" style="left: -10px">
	 		<button style="margin: 10px;" class="btn btn-default btn-lg btn-info" onclick="login()">确认登录</button>
	 		<button style="margin: 10px;" class="btn btn-default btn-lg btn-info" onclick=$('#login_username,#login_password').val(''),toastr.info("已重置");>重置信息</button>
	 	</div>
	    </div>		
	</div>
	<div class="right">
		<div class="login-right center-block">	
			<div class="picture"></div>
		</div>
	</div>
</div>
</body>
</body>
</html>