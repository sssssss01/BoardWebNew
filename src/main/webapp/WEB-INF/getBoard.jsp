<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화소개</title>
<style>
   div{
    width: 70%;     
   }

</style>
</head>
<body>

    
<form action="" method="post" enctype=multipart/form-data">
    <div id ="search_mov">
        <fieldset>
        <input type="text" value="영화검색">
        <button type="submit" >검색</button>
        </fieldset>
    </div>
    
    <div id="container">
        <div id="article">
            
            <h1>영화 제목</h1>
            <h5>영화 제목</h5>
            <hr>
            <table>
                <tr>
                    <th width="70" height="10"><b>개요</b></th>
                    <td>줄거리</td>
                </tr>

                <tr>
                    <th width="70"><b>감독</b></th>&nbsp;
                    <td>감독이름</td>
                </tr>

                <tr>
                    <th width="70"><b>출연</b></th>&nbsp;
                    <td>배우이름</td>
                </tr>
            </table>
        

            <div id ="poster" align="right">
                <img src="" alt="영화이름포스터">
            </div>

            <hr>
     </div>
    
  

    <div id ="content">
        <table>
            <tr>
                <th width="70">줄거리</th>
                <td>줄거리용</td>
            </tr>
        </table>

        <hr>

        <table>
            <tr>
                <th width="70">주연배우</th>
                <td>주연배우 정보</td>
            </tr>
        </table>
        
        <hr>

        <table>
            <tr>
                <th width="70">리뷰</th>
                <td>리뷰</td>
            </tr>

        </table>
        </form>
        <hr>
    </div>

    </div>
    
    </body>
    </html>