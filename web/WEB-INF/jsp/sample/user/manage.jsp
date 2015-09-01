<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lucy" uri="http://lucy.nhncorp.com/taglibs" %>
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
		<a class="btn_big" href="../board/list.nhn?id=${user.id}"><strong>게시판</strong></a>&nbsp;
		<a class="btn_big" href="../user/logout.nhn?id=${id}"><strong>로그아웃</strong></a>
	</div>
	
	<br>
	
	<div class="tbl_type1" style="width:800px;">
		<table width="100%" cellspacing="0">
		<col width="30%">
		<col width="30%">
		<col width="10%">
		<col width="20%">
		<col width="10%">
		
		<thead>
			<tr>
			<th>ID</th>
			<th>이름</th>
			<th>나이</th>
			<th>역활</th>
			<th>삭제</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach var="userItem" items="${userList}">
			<tr align="center">
				<td>${userItem.id}</td>
				<td>${userItem.userName}</td>
				<td>${userItem.age}</td>
				<td>${userItem.role}</td>
				<td><a class="btn_sml" href="./deleteUser.nhn?id=${user.id}&userId=${userItem.id}"><span>삭제</span></a></td>
			</tr>
		</c:forEach>
		</tbody>
		</table>
	</div>
	
	<br>
	<div align="center" style="width:800px;">
		<span class="paginate">
			<lucy:navigator pagerType="default">
				<lucy:first/>
				<lucy:prev/>
				<lucy:index/>
				<lucy:next/>
				<lucy:last/>
			</lucy:navigator>
		</span>
	</div>
</body>
</html>