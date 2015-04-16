<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>测试springmvc上传功能</title>
</head>
<body>
		<form action="upload.html" method="post" enctype="multipart/form-data">
		文件名：<input type="text" name="fileName"/>
		添加文件：<input type="file" name="file"/>
		<input type="submit"/>
		</form>
</body>
</html>