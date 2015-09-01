<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript" src="../../js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="../../js/jquery-ui-1.8.14.custom.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../../css/lucy-1.7.css">
</head>
<body>
	<br>

	<div align="right" style="width:800px;">
	<c:if test="${user.role == 'ADMIN' }">
		<a class="btn_big" href="../user/manage.nhn?id=${user.id}"><strong>관리</strong></a>&nbsp;
	</c:if>
		<a class="btn_big" href="../user/logout.nhn?id=${user.id}"><strong>로그아웃</strong></a>&nbsp;
	</div>
	
	<br>
	
	<div align="right" style="width:800px;">
		<form id="boardForm" action="./registerSubmit.nhn" method="POST" enctype="multipart/form-data">
		<fieldset class="tbl_type3 tbl_forms">
			<table cellspacing="0" border="1">
				<col width="100px">
				<col width="700px">

				<tr>
					<th>글제목</th>
					<td><input type="text" name="title" class="input_txt" style="width:100%;"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" name="userName" class="input_txt" style="width:100%;" value="${user.userName}" readOnly/>
						<input type="hidden" name="writeId" value="${user.id}"/>
						<input type="hidden" name="id" value="${user.id}"/>
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="attachFile"/></td>
				</tr>
				<tr>
					<td colspan="2"><center><textarea name="content" style="width:100%;height:400px"></textarea></center></td>
				</tr>
			</table>
		</fieldset>
		
		<br>
		
		<div align="right">
			<a id="formSubmit" href="#" class="btn_big"><strong>등록</strong></a>&nbsp;
			<a id="formCancel" href="#" class="btn_big"><strong>취소</strong></a>
		</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	$("#formSubmit").click(function() {
		$("#boardForm").submit();
	});
	
	$("#formCancel").click(function() {
		history.go(-1);
	});
</script>
</html>