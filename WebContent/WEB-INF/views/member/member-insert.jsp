<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/member/insert">
	<table>
		<tr>
			<th>회원이름</th>
			<td><input type="text" name="m_name"></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="m_id"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="m_pw"></td>
		</tr>
	</table>
	<button>회원번호 입력</button>
</form>

</body>
</html>