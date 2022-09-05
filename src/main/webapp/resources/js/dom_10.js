//const d2 = document.getElementById("d2");
const d2 = document.querySelector("#d2");
const d1 = document.querySelector("#d1");
const d3 = document.querySelector("#d3");
const d4 = document.querySelector("#d4");

d3.addEventListener("click", function () {
    console.log("click");
    d2.classList.toggle("c2");
    console.log(d2.classList.contains("c2"));
})

d2.addEventListener("mouseenter", function () {
    console.log("Enter");
    console.log(d1.class);
    console.log(d1.getAttribute("class"));
    // 마우스가 들어가면 d1 배경색 파란색 - class="c2"
    //d1.className = "c2";
    d1.classList.replace("c3", "c2");
}, true); // true -> 캡쳐링(부모부터 실행), mouseenter -> 영역에 마우스가 들어갔을때

d2.addEventListener("mouseleave", function () {
    console.log("--------------");
    console.log("Leave");
    console.log(d1.className);
    console.log(d1.classList);
    d1.classList.add("c4");
}); // mouseleave -> 영역에서 마우스가 나갈 때

// id가 d4인것을 클릭?
d4.addEventListener("click", function () {
    console.log("request");
    console.log("origin: " + location.origin);
    console.log("hostname: " + location.hostname);
    console.log("pathname: " + location.pathname);
    console.log("search: " + location.search);

    location.href = "./dom_9.html"; // 이게 제일 중요
});