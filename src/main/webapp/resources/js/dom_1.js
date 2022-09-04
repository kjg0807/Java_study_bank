console.log("dom_1");

let rs = window.confirm("확인???");
console.log("rs : ", rs);

rs = window.prompt("이름을 입력하세요");
console.log("rs : ", rs);

let d1 = document.getElementById("d1");
//alert(d1);
console.log(d1);
//d1.innerText = '<h1>' + rs + '</h1>';
console.log("--------------------");
let d2 = document.getElementById("d2");
console.log(d2.innerHTML);
console.log(d2.innerText);
console.log("--------------------");
let d3 = document.getElementById("d3");
let d4 = document.getElementById("d4");

console.log(d4.innerHTML = d3.innerHTML);

