const btn = document.getElementById("btn");
const frm = document.getElementById("frm");
const id = document.getElementById("id");
const pwd = document.getElementById("pwd");

btn.addEventListener("click", function () {
    let id1 = id.value;
    let pwd1 = pwd.value;

    if (id1.length == 0 && pwd1.length == 0) {
        alert("ID, PWD 입력")
    }
    else if (id1.length == 0) {
        alert("ID 입력");
    }
    else if (id1.length != 0) {
        if (pwd1.length == 0) {
            alert("PWD 입력");
        }
        else {
            frm.submit();
        }
    }    
});
