<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	 <center>
        <h1>회원정보수정</h1>

	<form action="join.do" method="post">
		<table border=1>
			<tr>
				<td>아이디</td>
				<td><input type=text id="id" name="id" placeholder="${result.id}"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" id="pw" name="pw"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type=text id="name" name="name" placeholder="${result.name}"></td>
			</tr>
			<tr>
			<td colspan="2" align=center>
			<button>가입하기</button>
			<input type="reset" value="다시작성"></td>
			</tr>
		</table>
	</form>
	 </center>
</body>
</html>