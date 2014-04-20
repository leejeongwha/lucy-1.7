<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<form action="./multi" method="POST" enctype="multipart/form-data">
		<input type="file" name="fileList[0]"/><br/>
		<input type="file" name="fileList[1]"/><br/>
		<input type="file" name="fileList[2]"/><br/>
		<input type="file" name="fileList[3]"/><br/>
		<input type="file" name="fileList[4]"/>
		<input type="submit"/>
	</form>
</body>
</html>