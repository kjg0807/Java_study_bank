// 1. 선택자
const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d3 = document.getElementById("d3");
const year = document.getElementById("year");
const month = document.getElementById("month");
const date = document.getElementById("date");
// alert(d1.value);
// alert(d1.getAttribute("value"));

// 타입 변경
//d2.setAttribute("type", "button");
d2.type = "button";

// 숫자만큼 div를 실행?
// let count = prompt("숫자를 입력하세요");
// let t = "";
// for (let i = 0; i < count; i++) {
//     t = t + '<input type="text" value="Java Script">';
// }
// d3.innerHTML = t;

//연도 1900 ~ 2022
//달 1 ~ 12
//일 1 ~ 31

let m = "";
let y = "";
let d = "";

for (let i = 2022; i > 1900; i--) {
    y = y + '<option>' + i + " 년도" + '</option>';
}
year.innerHTML = y;

for (let i = 1; i < 13; i++) {
    m = m + "<option>" + i + " 월" + "</option>";
}
month.innerHTML = m;
// for (let i = 1900; i < 2023; i++) {
//     y = y + "<option>" + i + " 년도" + "</option>";
//     year.innerHTML = y;
// }
for (let i = 1; i < 32; i++) {
    d = d + "<option>" + i + " 일" + "</option>";
}
date.innerHTML = d;

const d4 = document.getElementById("d4");

let r = prompt("Row의 갯수 입력"); // tr
let c = prompt("columt의 갯수 입력"); //td

let table = "";

for (let i = 0; i < r; i++) {
    table = table + "<tr>";
    for (let j = 0; j < c; j++) {
        table = table + "<td>" + i + j + "</td>";
    }
    table = table + "</tr>";
}
d4.innerHTML = table;