<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}">
<meta charset="UTF-8">
<title>登录页面</title>
<style type="text/css">
	.content{
		width: 600px;
		min-height: 200px;
		margin: 300px auto;
		text-align: center;
		line-height: 40px;
		background-color: red;
	}
</style>
</head>
<body>
	<div class="content">
		<div><h2>登录页面</h2></div>
		<form action="region/region.html" method="post">
			登录账号：<input type="text" name="name"><br/>
			登录密码：<input type="password" name="password"><br/>
			<input type="checkbox" name="auto">自动登录<br/>
			<input type="submit" value="登录">
		</form>
	</div>
</body>
</html>