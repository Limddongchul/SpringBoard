<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>${sessionScope.loginId}님 환영합니다.</th>
		</tr>
		<tr>
			<td>
				<button>로그아웃</button>
				<button>게시판으로가기</button>
				<button>나의정보</button>
				<button>회원탈퇴</button>
			</td>
		</tr>
	</table>
</body>
</html>