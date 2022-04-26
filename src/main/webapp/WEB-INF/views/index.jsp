<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="/resources/js/drag_order_dom.js"></script>
<style>
.dragItem{
	border: 1px solid black;
	width: 150px;
	height: 60px;
}
</style>
<script>
$(function(){

	$("#apply").click(function(){
	
        $(".list").children().each((index, item) => {
        	//alert($(item).text());
        	//alert(item.dataset.order);
        	//alert(item.dataset.orderOriginal);
        	const list = {
				bookId: $(item).text(),
	    		orderOriginal: item.dataset.orderOriginal,
	    		order: item.dataset.order
	    	};
	    	 $.ajax("order", {
		        method: "POST",
		        contentType: "application/json",
		        dataType: "json",
		        data: JSON.stringify(list),
		        success: result => {
		        	if(result==1){
		        		console.log("성공");
					}else{
						alert("실패")
					}
				}, 
		        error: xhr => alert(`오류 발생: ${xhr.statusText}`)
	   		 })
	    	
        });
	});
});
</script>
</head>
<body>
<div>
	<h1>도서 관리</h1>
	<ul>
		<!-- page를 넘겨줌-->
		<li><a href="book/list/${pager.page}">도서 관리</a></li>
	</ul>
	<h1>순서 변경</h1>
		<div class="list">
			<c:forEach var="item" items="${list}">
				<div class="dragItem">${item.bookId}</div>
			</c:forEach>
		</div>
		<div>
			<div><a href="?page=1">처음</a></div>
			<div><a href="?page=${pager.prev}">이전</a></div>
			
			<c:forEach var="page" items="${pager.list}">
				<div><a href="?page=${page}">${page}</a></div>
			</c:forEach>								
			
			<div><a href="?page=${pager.next}">다음</a></div>
			<div><a href="?page=${pager.last}">마지막</a></div>
		</div>
	<button id="apply">적용</button>
</div>
<script>
		new DragOrder(".list");
	</script>
</body>
</html>