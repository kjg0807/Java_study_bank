<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>약관 동의</title>
        </head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
            crossorigin="anonymous"></script>
        <style>
            form {
                margin-top: 50px;
                text-align: center;
            }
        </style>

        <body>
            <!-- index -> accept(약관 동의 check box) -> join - join으로 넘어갈때 form을 전송-->
            <c:import url="../template/header.jsp"></c:import>
            <h1 align="center">Accept Page</h1>
            <div class="row" align="center">
                <div class="form-check">
                    전체 동의 <input type="checkbox" name="box" id="all">
                </div>
                <div class="form-check">
                    1. (필수)<input type="checkbox" name="box" id="" class="cb req">
                </div>
                <div class="form-check">
                    2. (필수)<input type="checkbox" name="box" id="" class="cb req">
                </div>
                <div class="form-check">
                    3. (선택)<input type="checkbox" name="box" id="" class="cb">
                </div>
            </div>

            <form action="./join.naver" id="frm">
                <div>
                    <button type="button" class="btn btn-primary" id="join">Join</button>
                </div>
            </form>

            <c:import url="../template/footer.jsp"></c:import>
        </body>
        <script src="/resources/js/accept.js"></script>

        </html>