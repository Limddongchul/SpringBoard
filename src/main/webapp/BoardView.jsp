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
			<td><label>�۹�ȣ : ${result.seq}</label> </td>
		</tr>
		<tr>
			<th><label>���� : </label>${result.title}</th>
		</tr>
		<tr>
			<td><label>���� : </label> ${result.contents}</td>
		</tr>
		<tr>
			<td><label>�ۼ���  : </label> ${result.writer }</td>
		</tr>
		<tr>
			<td><label>��ȸ�� : </label> ${result.count}</td>
		</tr>
	</table>
</body>
</html>