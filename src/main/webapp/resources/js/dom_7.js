const d1 = document.getElementById("d1"); //div#d1
const d2 = document.getElementById("d2"); //div#d2
const remove1 = document.getElementById("remove1"); //button#remove1
const remove2 = document.getElementById("remove2"); //button#remove2

remove1.addEventListener("click", function () {
    d1.remove();
})

// 자식태그 내용 전체 지우기
remove2.addEventListener("click", function () {
    // d2.removeChild(d2_1);
    // d2.removeChild(d2_2);
    // d2.removeChild(d2_3);
    // d2.removeChild(d2_4);
    // -------------------------- id
    // for (let i = 1; i < 5; i++) {
    //     const d2_i = document.getElementById("d2_" + i); //div#d2_1
    //     d2.removeChild(d2_i);
    // }
    // -------------------------- class
    const ch = document.getElementsByClassName("ch");
    const ar = [];
    for (let i = 0; i < ch.length; i++) {
        //d2.removeChild(ch[i]);
        ar.push(ch[i].id);
    }
    // for(변수명 of 컬렉션변수명)
    for(i of ar){
        let d = document.getElementById(i);
        d2.removeChild(d);
    }
})