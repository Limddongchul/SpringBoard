<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
	$(document).ready(function(){
		$("#join").click(function(){
			$(location).attr("href","join.jsp");
		})
	})
</script>


</head>
<body>
	<form action="login.do" method="post">
		<table border="1" style="margin: 0 auto;">
			<tr>
				<th colspan="2">로그인</th>
			</tr>

			<tr>
				<td>로그인 :</td>
				<td><input type="text" name="id"></td>
			</tr>

			<tr>
				<td>비밀번호 :</td>
				<td><input type="password" name="pw"></td>
			</tr>

			<tr>
				<td colspan="2" style="text-align: center;">
					<button>로그인</button>
					<button type="button" id="join">회원가입</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>