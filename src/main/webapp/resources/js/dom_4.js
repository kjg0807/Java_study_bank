const ch = document.getElementsByClassName("ch");
const cb = document.getElementsByClassName("cb");

for (let i = 0; i < ch.length; i++) {
    ch[i].addEventListener("click", function () {
        alert(ch[i].value);
    })
}

// 첫번째 체크가 true면 나머지도 전부 true
// false면 전부 false
// for (let i = 0; i < c1.length; i++) {
//     console.log(c1[i].selected);
// }
// c1[0].selected = true;

for (let i = 0; i < cb.length; i++) {
    cb[i].addEventListener("click", function () {
        //console.log(cb[0] == true);
        for (let i = 0; i < cb.length; i++) {
            console.log(cb[i].checked);
            cb[i].checked = true;
            // if (!cb[0].checked) {
            //     cb[i].checked = false;
            // }
        }
        console.log(cb[i].checked);
    })
}