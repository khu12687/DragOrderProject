<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>도서 목록</h1>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th>도서번호</th>
						<th>도서명</th>
						<th>내용</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="4">등록된 도서가 없습니다</td>
						</tr>
					</c:if>
					
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.bookId}</td>
							<td>${item.subject}</td>
							<td>${item.contents}</td>
							<td><a href ="../update/${item.bookId}">변경</a><a href ="../delete/${item.bookId }">삭제</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4">
							<div>
								<div><a href="1">처음</a></div>
								<div><a href="${pager.prev}">이전</a></div>
								
								<c:forEach var="page" items="${pager.list}">
									<div><a href="${page}">${page}</a></div>
								</c:forEach>								
								
								<div><a href="${pager.next}">다음</a></div>
								<div><a href="${pager.last}">마지막</a></div>
							</div>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
		<div>
			<a href="/">메인으로</a>
		</div>
		<div>
			<a href="../add">등록</a>
		</div>
		<div>
			<a href="../dummy">대량추가</a>
		</div>
		<div>
			<a href="../init">초기화</a>
		</div>
	</div>
</body>
</html>