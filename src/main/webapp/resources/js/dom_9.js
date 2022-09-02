const d1 = document.querySelector("#d1");
const d1_1 = document.querySelector("#d1_1");
const d1_2 = document.querySelector("#d1_2");
const d1_2_1 = document.querySelector("#d1_2_1");
const d1_2_1_2 = document.querySelector("#d1_2_1_2");
const btn = document.getElementById("btn");

console.log(d1.childNodes);
console.log(d1.children);
console.log(d1.childNodes[3].childNodes[1].childNodes[1].innerHTML);
console.log(d1.children[1].children[0].children[0].innerHTML);

d1.addEventListener("click", function () {
    // li 모드 삭제
    //d1.children[1].children[0].children[0].remove(); // 나는 천재야-!
    let li = d1.children[1].children[0].children;
    
    // for (let i = 0; i != li.length;) {
    //     console.log("li.lenth: " + li.length);
    //     console.log("i: " + i);
    //     li[0].remove();
    // }
});

console.log("----------------------------");
console.log(d1_2_1_2.parentNode.parentNode);
// 버튼 클릭시 d1_2_1_2 기준 div #d1_2를 지움 -> h1만 남음
btn.addEventListener("click", function(){
    d1_2_1_2.parentNode.parentNode.remove();
})
console.log("----------------------------");
console.log(d1_2_1_2.previousSibling.previousSibling);
console.log(d1_2_1_2.nextSibling.nextSibling);