alert("Welcome");

// 숫자 1 입력
var num = 1;
//num = 'abc';
let num2 = '1';
console.log(num == num2);
console.log(num === num2);

var count = 1;
for (var i = 0; i < 10; i++) {
    console.log(i);
    count = 2;
}
console.log('--------------------');
console.log(i);
console.log(count);
console.log('--------------------');

let ar = ['4', 1, 3, '2'];
console.log(ar[0]);
console.log(ar[1]);
console.log('--------------------');
ar.push(5); // 배열에 5추가
console.log(ar);
ar.unshift(9); // 배열 맨 앞에 9 추가
console.log(ar);
ar.sort(); // 배열 오름차순으로 정렬
console.log(ar);
ar.reverse();
console.log(ar); // 역순으로 변경
console.log('--------------------');
ar.forEach(function (v, i, ar) { // ar의 index를 i번 v 에 담음
    console.log("v : ", v); //"v : " + v
    console.log("i : ", i);
    console.log('--------------------');
});
