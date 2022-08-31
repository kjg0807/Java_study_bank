const d2 = document.getElementById("d2");
const d1 = document.getElementById("d1");
const d3 = document.getElementById("d3");
const d5 = document.getElementById("d5");
const d4 = document.getElementById("d4");
const span = document.getElementById("span");

d2.addEventListener("focus", function () {
    console.log("입력준비");
})

d2.addEventListener("blur", function () {
    console.log("blur 발생");
})

// d1 입력하고 나왔을 때 글자의 길이가 3글자 이하라면 d1 강제로 다시 입력 대기 상태
d1.addEventListener("blur", function () {
    let v = d1.value;
    if (v.length < 4) {
        d1.focus();
    }
})

d3.addEventListener("change", function () {
    console.log("change Event 발생");
})

d5.addEventListener("change", function () {
    console.log("change 발생");
})

d4.addEventListener("keyup", function () {
    //console.log("key up");
})

span.addEventListener("keyup", function () {
    // 입력한 글수 만큼 1000원씩 추가
    let rs = 0;    
    if (d4.innerText++) {
        rs = rs + 1000;
    }
    console.log(rs);
})
