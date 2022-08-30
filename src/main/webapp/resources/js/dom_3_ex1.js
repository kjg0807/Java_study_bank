// d1 * d2 = d3 btn 눌럿을때 계산
const d1 = document.getElementById('d1');
const d2 = document.getElementById('d2');
const d3 = document.getElementById('d3');
const btn = document.getElementById('btn');
const btn2 = document.getElementById('btn2');
const btn3 = document.getElementById('btn3');
const btn4 = document.getElementById('btn4');
const sel = document.getElementById('select');
const c1 = document.getElementsByClassName('c1');

btn.addEventListener("click", function () {
    // console.log(d1.value);
    // console.log(d2.value);
    // d3.value = d2.value * 1 / d1.value * 1;
    // console.log(d3.value);
    console.log("operator: " + sel.value);
    if (sel.value == "+") {
        d3.value = d1.value * 1 + d2.value * 1;
    }
    else if (sel.value == "-") {
        d3.value = d1.value * 1 - d2.value * 1;
    }
    else if (sel.value == "*") {
        d3.value = d1.value * d2.value;
    }
    else if (sel.value == "/") {
        d3.value = (d1.value * 1) / (d2.value * 1);
    }
    else if (sel.value == "%") {
        d3.value = (d1.value * 1) % (d2.value * 1);
    }
});

btn2.addEventListener("click", function () {
    alert("btn2");
})

btn3.addEventListener("click", function () {
    btn2.click();
})

btn4.addEventListener("click", function () {
    console.log(c1);
    console.log(c1.value);
    for (let i = 0; i < c1.length; i++) {
        console.log(c1[i].selected);
    }
    c1[0].selected = true;
})
