<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登陆</title>
</head>
<body>
<!--Wia86200037  -->
<form action="${pageContext.request.contextPath }/login.action" method="post">
用户账号：<input type="text" name="username" value="86200037" /><br/>
用户密码 ：<input type="text" name="password" value="Wia86200037"/><br/>
<input type="submit" value="登陆"/>
</form>
</body>
</html>