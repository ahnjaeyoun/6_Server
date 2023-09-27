<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
	<main>
        <section id="enroll-text-area">
            <div>
                회원가입
            </div>
        </section>
        <section id="enroll-infor-area">
            <form action="/signup" id="enroll-infor-area-form" onsubmit="return validate()" 
            method="post">
                <div id="enroll-infor-area-idText">아이디</div>
                <input id="enroll-inputId" name="inputId">
                <p>영어 대/소문자, 숫자, 특수문자 포함 6~14글자</p>
                <div id="enroll-idConfirm-box">
                    <span id="enroll-idConfirmText"></span>
                </div>
                <div id="enroll-infor-area-pwText">비밀번호</div>
                <input type="password" id="enroll-inputPw" name="inputPw">
                <div id="enroll-infor-area-pwTextConfirm">비밀번호 확인</div>
                <input type="password" id="enroll-inputPwConfirm">
                <div id="enroll-pwConfirmText">
                    <span id="enroll-pwConfirmText-span"></span>
                </div>
                <div id="enroll-infor-area-nickname">닉네임</div>
                <input id="enroll-inputNickname" name="inputNickname">
                <div id="enroll-nicknameConfirmText-box">
                    <span id="enroll-nicknameConfirmText"></span>
                </div>
                <button id="enrollBtn">가입하기</button>
            </form>
        </section>
    </main>
    
    <script src="/resources/js/signup.js"></script>
</body>
</html>