<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<h1>도서 정보 변경</h1>
		<form method="post">
		<div>
			<label>도서명:</label>
			<input name="subject" type="text" value="${item.subject }">
		</div>
		<div>
			<label>내용:</label>
			<input name="contents" type="text" value="${item.contents }">
		</div>
		<div>
			<button>변경</button>
		</div>
		</form>
	</div>
</body>
</html>