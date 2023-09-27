<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/main.css">

</head>
<body>
	<section id="insert-main-sec">
        <section></section>
        <section>
            <form action="/insert" method="post" id="insert-content-box">
                    <div>To Do 등록하기</div>
                    <div></div>
                    <div>제목</div>
                    <input name="insertTitle">
                    <div></div>
                    <div>메모</div>
                    <textarea name="insertMemo"></textarea>
                    <div></div>
                    <button>등록하기</button>           
            </form>
        </section>
        <section></section>
    </section>
</body>
</html>