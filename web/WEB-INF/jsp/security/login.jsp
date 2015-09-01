<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<form id="loginForm" action="./login" method="POST">
		ID : <input type="text" name="id" class="input_txt"><br/>
		PASSWD : <input type="text" name="passwd" class="input_txt"><br/>
		<select name="role">
			<option value="ADMIN">ADMIN</option>
			<option value="MEMBER">MEMBER</option>
		</select><br/>
		<input type="submit"/>
	</form>
</body>
</html>