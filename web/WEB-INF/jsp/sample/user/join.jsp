<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<form action="./join.nhn" method="POST">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td><input type="text" name="passwd"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"value="가입"></td>
			</tr>
		</table>
	</form>
</body>
</html>