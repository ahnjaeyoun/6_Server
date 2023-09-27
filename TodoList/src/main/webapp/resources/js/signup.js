const checkObj = {
    "enrollInputId" : false,
    "enrollInputPw" : false,
    "enrollInputPwConfirm" : false,
    "enrollInputNickname" : false
}

const enrollIdConfirmText = document.getElementById("enroll-idConfirmText");

document.getElementById("enroll-inputId").addEventListener("change", function() {

    const regExp = /^[a-z][\w-_]{5,13}$/;
                // 소문자시작(1) + 나머지(5~13) = 6~14글자

    if(regExp.test(this.value)) {
        this.style.backgroundColor = "springgreen";
        this.style.color = "black";
        enrollIdConfirmText.innerText = "사용 가능한 아이디입니다."
        checkObj.enrollInputId = true;
    } else {
        this.style.backgroundColor = "red";
        this.style.color = "white";
        enrollIdConfirmText.innerText = "사용 불가능한 아이디입니다."
        checkObj.enrollInputId = false;
    }


});

const enrollInputPw = document.getElementById("enroll-inputPw");
const enrollInputPwConfirm = document.getElementById("enroll-inputPwConfirm");

enrollInputPwConfirm.addEventListener("keyup", function() {

    if(enrollInputPw.value.length == 0) {
        this.value = "";
        alert("비밀번호를 입력해주세요");
        enrollInputPw.focus();
        checkObj.enrollInputPw = false;
    }
});


const pwMessage = document.getElementById("enroll-pwConfirmText-span");


enrollInputPwConfirm.addEventListener("keyup", function() {
    if( (enrollInputPw.value == enrollInputPwConfirm.value) && enrollInputPw.value.length != 0 ) {
        pwMessage.innerText = "비밀번호 일치";
        pwMessage.style.color = "green";
        checkObj.enrollInputPw = true;
        checkObj.enrollInputPwConfirm = true;
    }else {
        pwMessage.innerText="비밀번호 불일치";
        pwMessage.style.color = "red";
        checkObj.enrollInputPwConfirm = false;
    }
});


document.getElementById("enroll-inputNickname").addEventListener("change", function() {
    const regExp = /^[가-힣]{2,5}$/;

    const nameMessage = document.getElementById("enroll-nicknameConfirmText");

    if(regExp.test(this.value)) {
        nameMessage.innerText = "정상입력";
        nameMessage.style.color = "green";
        checkObj.enrollInputNickname = true;
    }else {
        nameMessage.innerText = "한글만 입력하세요";
        nameMessage.style.color = "red";
        checkObj.enrollInputNickname = false;
    }
});


function validate() {
    
    for(let key in checkObj) {
        if( !checkObj[key] ) { 
            alert("회원가입 양식이 잘 못 되었습니다.");
            return false;
            
        }
    }

    alert("회원가입 완료");
    return true;

};