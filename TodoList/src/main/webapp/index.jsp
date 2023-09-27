<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TodoList</title>

<link rel="stylesheet" href="/resources/css/main.css">

</head>
<body>

	<c:choose>
		<c:when test="${empty sessionScope.loginMember}">
	<main>
        <section>
            <div id="todoList-text">투 두 리스트 로그인</div>
        </section>
        <section>
            <div id="todoList-login-infor-box">
                <form action="/member/login" method="post" id="login-form">
                    <div id="idText">아이디</div>
                    <input name="inputId" id="id">
                    <div id="pwText">패스워드</div>
                    <input type="password" name="inputPw" id="pw">
                    <div id="loginBtn-box">
                        <button id="loginBtn">로그인</button>
                    </div>
                </form>
                <a href="/signupPage" id="enrollBtn">회원가입</a>                
            </div>
        </section>
    </main>
		</c:when>
		<c:otherwise>
			<section id="todoList-main">
            <section></section>
           <section id="todoList-title-sec">
               <div id="todoList-title">user1의 투 두 리스트</div>
           </section>
           <section id="todoList-content-sec">
                <div id="todoList-content"></div>
           </section>
           <nav id="nav-sec">
               <div>
                   <a href="/insert">등록하기</a>
               </div>
               <div>
                   <a href="/logout">로그아웃</a>
               </div>
           </nav>
           <section></section>
       </section>
		</c:otherwise>
	
	</c:choose>
	
	<c:if test='${not empty sessionScope.message }'>
		<script>
			alert('${message}')
		</script> 
	 <c:remove var="message" scope="session"/>
	</c:if>
    
</body>
</html>