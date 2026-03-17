<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signup - 회원가입</title>
</head>
<body>

<h1>회원가입</h1>
<hr>

<form action="/signup" method="post">
    <table border="1">
        <tr>
            <th>아이디</th>
            <td><input type="text" name="userId" required></td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td><input type="password" name="pw" required></td>
        </tr>
        <tr>
            <th>이름</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>생년월일</th>
            <td><input type="date" name="birth"></td>
        </tr>
        <tr>
            <th>이메일</th>
            <td><input type="email" name="email"></td>
        </tr>
        <tr>
		    <th>전화번호</th>
		    <td>
		        <input type="text" name="phone" oninput="formatPhone(this)">
		    </td>
		</tr>
        <tr>
	    	<th>학력</th>
		    <td>
		        <select name="education">
		            <option value="">선택하세요</option>
		            <option value="초졸">초졸</option>
		            <option value="중졸">중졸</option>
		            <option value="고졸">고졸</option>
		            <option value="대졸">대졸</option>
		            <option value="대학원">대학원</option>
		        </select>
		    </td>
        </tr>
        <tr>
            <th>보유 스킬</th>
            <td><input type="text" name="skill"></td>
        </tr>
        <tr>
            <th>희망 직무</th>
            <td><input type="text" name="desiredJob"></td>
        </tr>
        <tr>
            <th>희망 근무지</th>
            <td><input type="text" name="desiredArea"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="회원가입">
                <a href="/loginForm">로그인으로</a>
            </td>
        </tr>
    </table>
</form>
<script>
function formatPhone(input) {
    let value = input.value.replace(/[^0-9]/g, ""); // 숫자만 남김

    if (value.length < 4) {
        input.value = value;
    } else if (value.length < 8) {
        input.value = value.slice(0, 3) + "-" + value.slice(3);
    } else {
        input.value = value.slice(0, 3) + "-" + value.slice(3, 7) + "-" + value.slice(7, 11);
    }
}
</script>
</body>
</html>