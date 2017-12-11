<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录界面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.loginform{
position: absolute;/*绝对定位*/
width: 300px;
height: 200px;
border: 1px solid red;
text-align: center;/*(让div中的内容居中)*/
top: 50%;
left: 50%;
margin-top: -200px;
margin-left: -150px;
}
</style>
<script type="text/javascript">
	//窗体改变大小时触发事件  
	window.onresize = setViewSize;
	var marginLeft = 0;
	var marginTop = 0;
	//设置画布大小，登录页面显示在屏幕最中间  
	function setViewSize() {
		//计算屏幕大小  
		var w = window.innerWidth || document.documentElement.clientWidth
				|| document.body.clientWidth;
		var h = window.innerHeight || document.documentElement.clientHeight
				|| document.body.clientHeight;
		//设置登陆div的位置  
		marginLeft = (w - 468) / 2;
		marginTop = (h - 262) / 2;
		document.getElementById("loginFormMain").style.marginLeft = marginLeft;
		document.getElementById("loginFormMain").style.marginTop = marginTop;
	}

	//默认聚焦在用户名输入框上  
	function focusOnUsername() {
		//调整画布大小和登陆框位置  
		setViewSize();
		//默认聚焦在输入框上  
		if (document.loginForm) {
			var usernameInput = document.loginForm.username;
			if (usernameInput) {
				usernameInput.focus();
			}
		}
		return;
	}

	//检查用户输入  
	function checkLogin() {
		if (checkUsername() && checkPassword()) {
			return true;
		}
		return false;
	}
	//检查登录用户名  
	function checkUsername() {
		var username = document.loginForm.username;
		if (username.value.length != 0) {
			return true;
		} else {
			alert("请输入用户名");
			return false;
		}
	}
	//检查登录密码  
	function checkPassword() {
		var password = document.loginForm.password;
		if (password.value.length != 0) {
			return true;
		} else {
			alert("请输入密码");
			return false;
		}
	}
</script>
</head>

<body bgcolor="#1E81C2" onload="javascript:focusOnUsername();">
	<form action="${pageContext.request.contextPath }/mydemo/login" name="loginForm" class="loginform" method="post">
		<div id="loginFormMain">
			<table style="width: 468px; height: 262px; background-color: gray; text-align: center;">
				<tr>
					<th colspan="2" align="center">管理系统登录</th>
				</tr>
				<tr>
					<td>用户名:<input type="text" style="width: 200px; height: 30px;" name="username"></td>
				</tr>
				<tr>
					<td>密 码:<input type="password" style="width: 200px; height: 30px;" name="password"></td>
				</tr>
				<tr>
					<td align="center"><input formmethod="post" type="submit" style="cursor: pointer; font-style: inherit;" name="submit" onclick="return checkLogin();" value="登录"> <input type="reset" style="cursor: pointer;" name=reset value="重置"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
