<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<td><label>글번호 : ${result.seq}</label> </td>
		</tr>
		<tr>
			<th><label>제목 : </label>${result.title}</th>
		</tr>
		<tr>
			<td><label>내용 : </label> ${result.contents}</td>
		</tr>
		<tr>
			<td><label>작성자  : </label> ${result.writer }</td>
		</tr>
		<tr>
			<td><label>조회수 : </label> ${result.count}</td>
		</tr>
	</table>
</body>
</html>