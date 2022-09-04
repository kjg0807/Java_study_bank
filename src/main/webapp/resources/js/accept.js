// 약관 동의 페이지
// check box code
const cb = document.getElementsByClassName("cb"); // 유사배열
//const cb = document.querySelectorAll(".cb"); // class="cb"
const all = document.getElementById("all");
//const all = document.querySelector("#all");
const join = document.getElementById("join");
const frm = document.getElementById("frm");
const req = document.getElementsByClassName("req");

// console.log("forEach");
// // foreach(function(변수명1, 변수명2, 배열의변수명)
// cb.forEach(function (v, i, ar) {
//     console.log(v);
// });

all.addEventListener("click", function () { // 0번 체크하면 전체 체크
    console.log(all.checked);
    for (let i = 0; i < cb.length; i++) {
        cb[i].checked = all.checked;
    }
});

for (let i = 0; i < cb.length; i++) {
    cb[i].addEventListener("click", function () {
        let rs = true;
        for (let i = 0; i < cb.length; i++) {
            //console.log(cb[i].checked); // true
            if (!cb[i].checked) {
                rs = false;
                break;
            }
        }
        // if cb[i].checked: false -> rs = false
        all.checked = rs;
    });
}

join.addEventListener("click", function () {
    // 필수 약관만 동의하면 넘어감
    let rs = true;
    for (let i = 0; i < req.length; i++) {
        if (!req[i].checked) {
            rs = false;
            console.log("필수동의");
            break;
        }
    }
    if (rs) {
        frm.submit();
    }
    else {
        alert("필수 약관에 동의하지 않음");
    }

    // if (all.checked) { // 모든 버튼이 체크되야 넘어감
    //     frm.submit();
    // }
    // else {
    //     alert("약관에 동의하지 않음");
    // }
});

// --------------------------------------------------------