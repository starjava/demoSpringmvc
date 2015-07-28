<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello World! 404 pages !!!</h2>
	<center>
		User :${requestScope.u} Login Success!!!<br>
		Password:${requestScope.p} 
		<br> <br> 
		${requestScope.success}
		${sessionScope.rand}
	</center>
	跳转至上传页面:
	<a href="#" onclick="javascript:history.go(-1);">上传页面</a>
</body>
</html>