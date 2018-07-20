<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
	<form action="boardInsert.do" method="post">
		<input type="hidden" name="writer" value="${sessionScope.loginId}">
		<div id="title"><input type="text" name="title" placeholder="제목을 입력하세요."></div>
		<div id="contents"><textarea name="contents" rows="10" cols="80" placeholder="내용을 입력하세요."></textarea></div>
		<button>Confirm</button>
	</form>

</body>
</html>