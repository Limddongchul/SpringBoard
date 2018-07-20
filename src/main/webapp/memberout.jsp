<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<script>
		if(${result} > 0){
			alert("회원탈퇴가 성공적으로 완료되었습니다.");
			${session.invalidate()};
			location.href="index.do";
		}else{
			alert("회원탈퇴에 실패하였습니다.");
			location.href="mypage.do";
		}
	</script>
</body>
</html>