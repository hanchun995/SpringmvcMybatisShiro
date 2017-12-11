<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		 <script type="text/javascript">
 		function hello(){ 
			location.href="<%=path%>/index"
			} 
			window.setTimeout(hello,3000); 
		</script> 
	</head>
		<style type="text/css">
		.error-page {
		    width: 800px;
		    text-align: center;
		    margin: 100px auto 0;
		    padding: 50px;
		    font-size: 18px;
		    line-height: 1.5;
		    color: #999;
		    border: 1px solid #e0e0e0;
		    background-color: #fff;
		}
		</style>
	</head>
	<body>
		<div id="tt404" class="error-page"> <h2>404</h2> <p>Page not found!3秒后返回首页</p></div>
	</body>
	</html>