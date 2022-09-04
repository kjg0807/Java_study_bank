//button click event
const btn = document.getElementById("btn"); //button id : btn
const add = document.getElementById("add"); //button id : add
const d1 = document.getElementById("d1"); //div id: d1
const list = document.getElementById("list"); //ul id: list
const list2 = document.getElementById("list2"); //ol id: list2
const add2 = document.getElementById("add2"); //button id : add2
const add3 = document.getElementById("add3"); //button id : add3
const d2 = document.getElementById("d2"); //div id: d2
const add4 = document.getElementById("add4"); //button id : add4
const add5 = document.getElementById("add5"); //button id : add5
const d3 = document.getElementById("d3"); //div id: d3

btn.addEventListener("click", function () {
    d1.innerHTML = '<img src="/resources/image/1.jpg">';
})

add.addEventListener("click", function () {
    let li = document.createElement('li'); //<li> </li>
    let t = document.createTextNode('test'); // li내용 test 추가
    li.appendChild(t); //<li>test</li>
    list.append(li);
})

add2.addEventListener("click", function () {
    let ol = document.createElement('li');
    let h = document.createElement('h3'); // <h3></h3>
    let t = document.createTextNode('Hello') // Hello
    h.appendChild(t);
    ol.appendChild(h);
    list2.prepend(ol);
})

//add3 클릭하면 div#d2 내에 input Element를 Append
add3.addEventListener("click", function () {
    let input = document.createElement('input'); //<input>
    let ch = document.createAttribute("type") // type=
    ch.value = "checkbox"; // type = checkbox
    input.setAttributeNode(ch); //<input type="checkbox">
    d2.append(input);
})

// add4 클릭하면 div#d3에 before
add4.addEventListener("click", function(){
    let be = document.createElement('h3');
    let text = document.createTextNode('before');
    be.appendChild(text);
    d3.before(be);
})

// add5 클릭하면 div#d4에 after
add5.addEventListener("click", function(){
    let af = document.createElement('h3');
    let text = document.createTextNode('after');
    af.appendChild(text);
    d3.after(af);
})