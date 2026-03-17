<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login - 로그인 페이지</title>
</head>
<body>
<h1>로그인</h1>
<hr>
	<form action="/login" method="post">
		아이디: <input type="text" name="userId"><br>
		비밀번호: <input type="password" name="pw">
		<input type="submit" value="로그인">
	</form>
	<a href="/signupForm">회원가입 이동 </a>
</body>
</html>