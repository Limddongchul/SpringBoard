<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
	$(document).ready(function(){
		$("#back").click(function(){
			$(location).attr("href","index.do");
		})
	})
</script>

</head>

<body>
	 <center>
        <h1>ȸ����������</h1>

	<form action="update.do" method="post">
		<table border=1>
			<tr>
				<td>���̵�</td>
				<td><input type=text id="id" name="id" value="${loginid}" placeholder="${loginid}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>�н�����</td>
				<td><input type="password" id="pw" name="pw"></td>
			</tr>
			<tr>
				<td>�̸�</td>
				<td><input type=text id="name" name="name" placeholder="${result.name}"></td>
			</tr>
			<tr>
			<td colspan="2" align=center>
			<button>�����ϱ�</button>
			<input type="reset" value="�ٽ��ۼ�">
			<button type="button" id="back">�ڷΰ���</button>
			</td>
			</tr>
		</table>
	</form>
	 </center>
</body>
</html>