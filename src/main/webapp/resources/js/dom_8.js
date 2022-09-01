//숫자를 입력하고 버튼을 클릭하면 입력된 숫자만큼 div내에 button태그 생성
// input count, button btn, div rs
// 새로 생기는 Button - class="c1"

const count = document.getElementById("count");
const btn = document.getElementById("btn");
const rs = document.getElementById("rs");

btn.addEventListener("click", function () {
    const a = count.value;
    for (let i = 0; i < a; i++) {
        let button = document.createElement("button");
        let t = document.createTextNode("Click" + i);
        button.appendChild(t);
        let buttonClass = document.createAttribute("class");
        buttonClass.value = "c1";

        button.setAttributeNode(buttonClass);

        rs.append(button);

        button.addEventListener("click", function () {
            alert(button.textContent);
        })
    }
})

// class : c1 -> 내용을 alert으로 띄움
const c1 = document.getElementsByClassName("c1");
rs.addEventListener("click", function (event) {
    if (event.target.className == c1) {
        alert(event.target.innerHTML);
    }
})
// ---------------------------------------------------
const d1 = document.getElementById("d1");
const d1_1 = document.getElementById("d1_1");
const d1_1_1 = document.getElementById("d1_1_1");

d1.addEventListener("click", function (event) {
    console.log("d1 click");
    // console.log(event);
    // console.log(event.currentTarget);
    // console.log(event.target);

    if (event.target.className == 'buttons') {
        alert("Button");
        console.log("this: ", this);
        alert(event.target.innerHTML);
    }

}, false)

const google = document.getElementById("google");

google.addEventListener("click", function (event) {
    alert("Go Google!!");
    event.preventDefault();
})