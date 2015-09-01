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
		<fieldset class="tbl_type3 tbl_forms">
			<table cellspacing="0" border="1">
				<col width="100px">
				<col width="500px">

				<tr>
					<th>글제목</th>
					<td>${boardInfo.title}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${boardInfo.writeName}</td>
				</tr>
				<tr>
					<th>작성일시</th>
					<td>${boardInfo.registerYmdt}</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><a href="../fileDownload?fileRealName=${boardInfo.fileRealName}">${boardInfo.fileName}</a></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<div style="width:100%;height:400px;">
							<pre>${boardInfo.content}</pre>
						</div>
					</td>
				</tr>
			</table>
		</fieldset>
		
		<br>
		
		<div align="right">
		<c:if test="${boardInfo.writeId == user.id}">
			<a class="btn_big" href="./modify.nhn?id=${user.id}&seq=${boardInfo.seq}"><strong>수정</strong></a>&nbsp;
			<a class="btn_big" href="./delete.nhn?id=${user.id}&seq=${boardInfo.seq}"><strong>삭제</strong></a>&nbsp;
		</c:if>
			<a class="btn_big" href="./list.nhn?id=${user.id}"><strong>목록</strong></a>
		</div>
	</div>
</body>
</html>