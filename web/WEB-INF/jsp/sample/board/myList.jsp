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
		<a class="btn_big" href="../board/list.nhn?id=${id}"><strong>게시판</strong></a>&nbsp;
		<a class="btn_big" href="../board/xml/${id}.nhn?id=${id}"><strong>XML</strong></a>&nbsp;
		<a class="btn_big" href="../user/logout.nhn?id=${id}"><strong>로그아웃</strong></a>&nbsp;
	</div>
	
	<br>
	
	<div align="right" style="width:800px;">
	<c:forEach var="boardItem" items="${boardList}">
		<fieldset class="tbl_type3 tbl_forms">
			<table cellspacing="0" border="1">
				<col width="100px">
				<col width="500px">
	
				<tr>
					<th>글제목</th>
					<td>${boardItem.title}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${boardItem.writeName}</td>
				</tr>
				<tr>
					<th>작성일시</th>
					<td>${boardItem.registerYmdt}</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><a href="../fileDownload?fileRealName=${boardItem.fileRealName}">${boardItem.fileName}</a></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<div style="width:100%;height:400px;">
							<pre>${boardItem.content}</pre>
						</div>
					</td>
				</tr>
			</table>
		</fieldset>
		<br>
	</c:forEach>
	</div>
	
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