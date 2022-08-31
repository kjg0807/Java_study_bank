// id를 입력하고 나왔을 때 2글자 미만이면 메세지 출력 : id는 2글자 이상
const id = document.getElementById("id");

idcheck = true;
pwdcheck = true;
namecheck = true;
emailcheck = true;
phonecheck = true;

id.addEventListener("blur", id1);
function id1() {
    let d = id.value;
    if (d.length < 2) {
        document.getElementById("idText").style.display = 'block';
        idcheck = false;
    }
    else {
        document.getElementById("idText").style.display = 'none';
    }
}

// pwd를 입력할 때마다 (1글자씩) 메세지를 출력 : pwd - 최소 6글자 이상
const pwd = document.getElementById("pwd");

pwd.addEventListener("blur", pwd11);
function pwd11() {
    let p = pwd.value;
    if (p.length < 6) {
        document.getElementById("pwdText").style.display = 'block';
    }
    else {
        document.getElementById("pwdText").style.display = 'none';
    }
}

// pwd를 입력하고 나왔을 때 첫번째 pwd와 값 비교 후 메세지 출력 : 같다, 다르다
const pwd2 = document.getElementById("pwd2");
// 입력하고 다른 곳 클릭하면 값 비교 후 출력
pwd2.addEventListener("blur", pwd22);
function pwd22() {
    let pw = pwd2.value;
    let p1 = pwd.value;
    if (p1 != pw) {
        document.getElementById("pwdText2").style.display = 'block';
        pwdcheck = false;
    }
    else {
        document.getElementById("pwdText2").style.display = 'none';
    }
}

// 입력 후 최소 1글자 이상 name, email, phone
const name1 = document.getElementById("name");
const email = document.getElementById("email");
const phone = document.getElementById("phone");
let a = 1;
name1.addEventListener("blur", na);
function na() {
    let ne = name1.value;
    if (ne.length < a) {
        document.getElementById("nameText").style.display = 'block';
        namecheck = false;
    }
    else {
        document.getElementById("nameText").style.display = 'none';
    }
}
email.addEventListener("blur", em);
function em() {
    let ne = email.value;
    if (ne.length < a) {
        document.getElementById("emailText").style.display = 'block';
        emailcheck = false;
    }
    else {
        document.getElementById("emailText").style.display = 'none';
    }
}
phone.addEventListener("blur", ph);
function ph() {
    let ne = phone.value;
    if (ne.length < a) {
        document.getElementById("phoneText").style.display = 'block';
        phonecheck = false;
    }
    else {
        document.getElementById("phoneText").style.display = 'none';
    }
}

// id, pwd, name, email, phone의 각 조건을 검사 후 조건이 맞을때만 회원가입 - button
const btn = document.getElementById("btn");
const frm = document.getElementById("frm");

btn.addEventListener("click", function () {
    // console.log(id);
    // console.log(pwd2);
    // console.log(name1);
    // console.log(email);
    // console.log(phone);
    console.log(idcheck && pwdcheck && namecheck && emailcheck && phonecheck);
    if ((idcheck && pwdcheck && namecheck && emailcheck && phonecheck) == true) {
        frm.submit();
    }
    else {
        alert("조건을 충족하지 못하였습니다.");
    }
})
