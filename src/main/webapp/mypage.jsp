<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
	$(document).reday(function(){
		$("#logout").click(function(){
			$(location).attr("href","logout.do");
		})
		
		$("#boardView").click(function(){
			$(location).attr("href","boardView.do");
		})
		
		$("#myInfo").click(function(){
			$(location).attr("href","myInfo.do");
		})
		
		$("#memberout").click(function(){
			$(location).attr("href","memberout.do");
		})
	})
</script>

</head>
<body>
	<table border="1" style="margin: 0 auto;">
		<tr>
			<th>${sessionScope.loginId}님 환영합니다.</th>
		</tr>
		<tr>
			<td>
				<button id="logout">로그아웃</button>
				<button id="boardView">게시판으로가기</button>
				<button id="myInfo">나의정보</button>
				<button id="memberout">회원탈퇴</button>
			</td>
		</tr>
	</table>
</body>
</html>