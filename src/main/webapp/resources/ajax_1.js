const d1 = document.querySelector("#d1");
const in1 = document.querySelector("#in1");
const rs = document.querySelector("#rs");

d1.addEventListener("click", function () {
    console.log("click");

    // 1. ajax 로 요청하는 객체 생성
    let xhttp = new XMLHttpRequest();

    // input에서 입력한 번호 출력
    let v = in1.value;
    // 2. 요청 정보 적용(메서드 형식, url주소, )
    xhttp.open("GET", "https://jsonplaceholder.typicode.com/posts/" + v);

    // 3. 요청 발생
    xhttp.send();

    // 4. 응답 결과 처리
    xhttp.onreadystatechange = function () {
        // this - http객체
        // console.log(this.status);
        // console.log(this.readyState);
        // console.log("----------");
        if (this.readyState == 4 && this.status == 200) { // 요청 응답이 끝낫을 때
            //console.log(this.responseText);
            let response = this.responseText.trim(); // 문자열
            response = JSON.parse(response); // 문자열을 객체로 바꿔줌

            console.log(response.userId);
            console.log(response.id);
            console.log(response.title);
            console.log(response.body);

            let h1 = document.createElement("h3");
            let t = document.createTextNode(response.userId);
            h1.appendChild(t);
            rs.appendChild(h1);

            let h2 = document.createElement("h3");
            let t2 = document.createTextNode(response.id);
            h2.appendChild(t2);
            rs.appendChild(h2);

            let h3 = document.createElement("h3");
            let t3 = document.createTextNode(response.title);
            h3.appendChild(t3);
            rs.appendChild(h3);

            let h4 = document.createElement("h3");
            let t4 = document.createTextNode(response.body);
            h4.appendChild(t4);
            rs.appendChild(h4);
        }
    }
    console.log("Ajax 발생");

});