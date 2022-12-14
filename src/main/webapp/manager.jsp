<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Ác Quỷ Shop</title>
  <link rel="icon" type="image/x-icon" href="assets/icon.ico">
  <!--CSS-->
  <link href="./css/style.css" rel="stylesheet" type="text/css" />

  <!--fontawesome-->
  <script src="https://kit.fontawesome.com/4d3747bacc.js" crossorigin="anonymous"></script>

</head>

<body>
<!--header-->
<section id="header2">
  <li><a class="logout-btn" href="logout">LOG OUT</a></li>
</section>
<!--Body-->

<section class="pen">
  <h2>1. Bảng game</h2>
  <div >
    <input type="submit" onclick="window.location.href='addgame.jsp'" value="Thêm">
    <input type="submit" onclick="window.location.href='deletegame.jsp'" value="Xoá">
    <input type="submit" onclick="window.location.href='updategame.jsp'" value="Sửa">
    <input type="submit" onclick="window.location.href='viewgame'" value="Xem">
  </div>
  <h2>2. bảng Khách hàng</h2>
  <div >
    <input type="submit" onclick="window.location.href='viewcustomer'" value="Xem">
  </div>
</section>



<script src="./js/main.js"></script>
</body>

</html>
