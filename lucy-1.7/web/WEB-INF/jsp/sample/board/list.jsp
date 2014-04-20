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
	<c:if test="${user.role == 'ADMIN' }">
		<a class="btn_big" href="../user/manage.nhn?id=${id}"><strong>관리</strong></a>&nbsp;
	</c:if>
		<a class="btn_big" href="../board/myList.nhn?id=${id}"><strong>내글</strong></a>&nbsp;
		<a class="btn_big" href="../user/logout.nhn?id=${id}"><strong>로그아웃</strong></a>&nbsp;
	</div>
	
	<br>
	
	<div class="tbl_type1" style="width:800px;">
		<table width="100%" cellspacing="0">
		<col width="10%">
		<col width="60%">
		<col width="10%">
		<col width="10%">
		<col width="10%">
		
		<thead>
			<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach var="boardItem" items="${boardList}">
			<tr align="center">
				<td>${boardItem.seq}</td>
				<td><a href="./detail.nhn?id=${id}&seq=${boardItem.seq}">${boardItem.title}</a></td>
				<td>${boardItem.writeName}</td>
				<td>${boardItem.registerYmdt}</td>
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
	
	<div align="right" style="width:800px;">
		<a class="btn_big" href="./register.nhn?id=${id}"><strong>글쓰기</strong></a>
	</div>
</body>
</html>