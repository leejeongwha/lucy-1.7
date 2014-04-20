<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript" src="../../js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="../../js/jquery-ui-1.8.14.custom.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../../css/lucy-1.7.css">
</head>
<body>
	<div class="intro">
		<div class="login_box">
			<h1><img src="http://static.naver.com/groupware/2010/h_login_service.gif" width="400" height="24" alt="Lucy 1.7 Sample"></h1>
			
			<form id="loginForm" action="./login.nhn" method="POST">
				<fieldset>
					<legend>로그인</legend>
					
					<div class="forms">
						<label for=""><img src="http://static.naver.com/groupware/2010/label_intro_id.gif" width="10" height="8" alt="ID"></label>
						<input type="text" name="id" class="input_txt">
						<br>
						<label for=""><img src="http://static.naver.com/groupware/2010/label_intro_pw.gif" width="54" height="8" alt="PASSWORD"></label>
						<input type="password" name="passwd" class="input_txt">
					</div>
					<a id="formSubmit" href="#"><input type="image" src="http://static.naver.com/groupware/2010/btn_intro_login.gif" alt="로그인" class="btn"></a>
				</fieldset>
			</form>
		</div>
		
		<div class="functions">
			<div class="group">
				<span>
				<a href="./join.nhn"><img src="http://static.naver.com/groupware/2010/img_intro_reg.gif" width="42" height="10" alt="REGISTER"></a>
				</span>
			</div>
		</div>
		
		<p class="copyright">Copyright © <strong>NHN Corp.</strong> All Rights Reserved.</p>
	</div>
</body>
<script type="text/javascript">
	$("#formSubmit").click(function() {
		$("#loginForm").submit();
	});
</script>
</html>