<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
	$(document).ready(function(){
		$("#insert").click(function(){
			$(location).attr("href", "BoardInsert.jsp");
		})
	})
</script>
</head>
<body>
	<table border=1>
		<tr style="background-color: gray">
			<td id="seq">No.</td>
			<td id="title">제목</td>
			<td id="writer">작성자</td>
			<td id="count">조회</td>
		</tr>
		<c:choose>
			<c:when test="${result.size() > 0}">
				<c:forEach var="item" items="${result}">
					<tbody id="body_a">
						<tr>
							<td id="seq">${item.seq}
							<td id="title"><a
								href="articleView.do?no=${item.seq}&count=${item.count}"
								class="no-uline">${item.title}</a>
							<td id="writer">${item.writer}
							<td id="count">${item.count}
						</tr>
					</tbody>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tbody id="body_b">
					<tr id="shit">
						<td id="nothing" colspan=4>표시할 내용이 없습니다.</td>
					</tr>
				</tbody>
			</c:otherwise>
		</c:choose>
	</table>
	<button type="button" id="insert">글쓰기</button>
	<div id="bottom" align=center>${navi}</div> 
</body>
</html>