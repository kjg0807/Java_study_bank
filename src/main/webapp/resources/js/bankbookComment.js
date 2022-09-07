// 버튼 클릭하면 insert하러 감 - javascript를 통해서
const commentAdd = document.querySelector("#btn");
const writer = document.querySelector("#writer");
const contents = document.getElementById("contents");
const commentList = document.querySelector("#commentList");
// page
const more = document.querySelector("#more");
let page = 1;
// booknum 담을 변수
const bookNum = commentAdd.getAttribute("data-booknum");
getCommentList(page, bookNum);

commentAdd.addEventListener("click", function () {

    let wv = writer.value;
    let cv = contents.value;

    // ---------- ajax ----------
    // 1. xmlHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    // 2. URL 준비
    xhttp.open("POST", "./commentAdd");

    // 3. Enctype
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //요청 header 정보 - GET은 필요 없음

    // 4. 전송 (post일 경우 파라미터 추가)
    xhttp.send("bookNum=" + bookNum + "&writer=" + wv + "&contents=" + cv);
    //POST 파라미터 전송 - GET은 내용 안넣음

    // 5. 응답 결과 처리
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let result = xhttp.responseText.trim();
            console.log(result);
            result = JSON.parse(result);
            console.log(result.result);
            writer.value = "";
            contents.value = "";

            if (result.result == 1) {
                alert("댓글 등록 성공");
                for (let i = 0; i < commentList.children.length;) {
                    commentList.children[0].remove();
                }
                page = 1;
                getCommentList(page, bookNum); // 최근에 단 댓글을 제일 먼저 - 1
            }
            else {

            }
        }
    };
}); // click 끝

function getCommentList(p, bn) { // p - page, bn - booknum
    // 1. xmlHTTPRequest 생성
    const xhttp = new XMLHttpRequest();
    // 2. method, url
    // bn = commentAdd.getAttribute("data-booknum")
    xhttp.open("GET", "./commentList?page=" + p + "&bookNum=" + bn);
    // 3. enctype 요청 전송 - get 안씀
    // 4. 전송 - get 내용 안씀
    xhttp.send();
    // 5. 응답 처리
    xhttp.addEventListener("readystatechange", function () {
        if (xhttp.readyState == 4 && this.status == 200) {
            //console.log(xhttp.responseText);
            // 1. jsp 사용한 결과물
            //commentList.innerHTML=xhttp.responseText.trim();

            // 2. json 결과물
            let result = JSON.parse(xhttp.responseText.trim());
            // table 생성
            // let result = document.createElement("table");
            // let resultAttr = document.createAttribute("class");
            // resultAttr.value("table table-hover");
            // result.setAttributeNode(resultAttr); // table class=table table-hover

            let pager = result.pager; // commentPager
            let ar = result.list; // commentList

            for (let i = 0; i < ar.length; i++) {
                let tr = document.createElement("tr");

                let td = document.createElement("td");
                let tdText = document.createTextNode(ar[i].contents);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode(ar[i].writer);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode(ar[i].regDate);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode("update");
                let tdAttr = document.createAttribute("class");
                tdAttr.value = "update"; // class="update"
                td.setAttributeNode(tdAttr);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode("delete");
                tdAttr = document.createAttribute("class");
                tdAttr.value = "delete"; // class="update"
                td.setAttributeNode(tdAttr);
                tdAttr = document.createAttribute("data-commentnum");
                tdAttr.value = ar[i].num;
                console.log(tdAttr.value = ar[i].num);
                td.setAttributeNode(tdAttr);

                td.appendChild(tdText);
                tr.appendChild(td);

                //result.appendChild(tr);
                commentList.append(tr);

                if (page >= pager.totalPage) {
                    more.classList.add("disabled");
                }
                else {
                    more.classList.remove("disabled");
                }
            }
            //console.log(commentList.children);

            // try {
            //     console.log(commentList.children());
            //     throw new Error("에러 메세지");
            // }
            // catch(exeception) {

            // }
            // finally{

            // }
            // let t = commentList.children;
            // if (t.length != 0) {
            //     commentList.children[0].remove();
            // }

            // commentList.append(result);
        }
    })
}

// 더보기 클릭시 실행
more.addEventListener("click", function () {
    page++;
    //console.log(bookNum);
    getCommentList(page, bookNum);
})

// ------------------------ 더보기 ------------------------
commentList.addEventListener("click", function (event) {
    let num = event.target.getAttribute("data-commentnum");
    if (event.target.className == "delete") {
        let check = confirm(num + "번 삭제하려면 확인");
        if (check == true) {
            // 1. xmlHTTPRequest 생성
            const xhttp = new XMLHttpRequest();
            // 2. method, url
            xhttp.open("POST", "commentDelete");
            // 3. enctype 요청 전송 - get 안씀
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            // 4. 전송 - get 내용 안씀
            xhttp.send("num=" + num);
            // 5. 응답 처리
            xhttp.addEventListener("readystatechange", function () {
                if (xhttp.readyState == 4 && this.status == 200) {
                    let result = xhttp.responseText.trim();
                    console.log(result);
                    if (result == 1) {
                        alert(num + "번 삭제 완료");
                        page = 1;
                        getCommentList(page, bookNum);
                        for (let i = 0; i < commentList.children.length;) {
                            commentList.children[0].remove();
                        }
                    }
                    else {
                        alert("삭제 실패");
                    }
                }
            });
        }
    }
    if (event.target.className == "update") {
        // let content = event.target.previousSibling.previousSibling.previousSibling;
        // let a = content.innerHTML;
        // prompt("내용 수정", a);
        // console.log(a);

        //content.innerHTML = "<textarea>"+a+"</textarea>";
        document.querySelector("#up").click();
        
    }
})