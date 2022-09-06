// 버튼 클릭하면 insert하러 감 - javascript를 통해서
const commentAdd = document.querySelector("#btn");
const writer = document.querySelector("#writer");
const contents = document.getElementById("contents");
const commentList = document.querySelector("#commentList");

getCommentList();

commentAdd.addEventListener("click", function () {
    let bookNum = commentAdd.getAttribute("data-booknum");
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
                getCommentList();
            }
        }
    };
}); // click 끝

function getCommentList() {
    // 1. xmlHTTPRequest 생성
    const xhttp = new XMLHttpRequest();
    // 2. method, url
    xhttp.open("GET", "./commentList?page=1&bookNum=" + commentAdd.getAttribute("data-booknum"));
    // 3. enctype 요청 전송 - get 안씀
    // 4. 전송 - get 내용 안씀
    xhttp.send();
    // 5. 응답 처리
    xhttp.addEventListener("readystatechange", function () {
        if (xhttp.readyState == 4 && this.status == 200) {
            console.log(xhttp.responseText);
            // 1. jsp 사용한 결과물
            //commentList.innerHTML=xhttp.responseText.trim();

            // 2. json 결과물
            let ar = JSON.parse(xhttp.responseText.trim());
            let result = document.createElement("table");
            let resultAttr = document.createAttribute("class");
            resultAttr.value("table table-hover");
            result.setAttributeNode(resultAttr); // table class=table table-hover
            resultAttr.value("table-hover");
            result.setAttributeNode(resultAttr); // table class=table table-hover

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

                result.appendChild(tr);
            }
            commentList.append(result);
        }
    })
}