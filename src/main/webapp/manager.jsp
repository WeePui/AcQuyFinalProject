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
    <input type="submit" name="action" onclick="window.location.href='addgame.jsp'" value="Thêm">
    <input type="submit" name="action" onclick="window.location.href='deletegame.jsp'" value="Xoá">
    <input type="submit" name="action" onclick="window.location.href='updategame.jsp'" value="Sửa">
    <input type="submit" name="action" onclick="window.location.href='#'" value="Xem">
  </div>
  <h2>2. bảng Khách hàng</h2>
  <div >
    <input type="submit" value="Thêm">
    <input type="submit" value="Xoá">
    <input type="submit" value="Sửa">
    <input type="submit" value="Xem">
  </div>
  <h2>3. bảng Đơn hàng</h2>
  <div >
    <input type="submit" value="Thêm">
    <input type="submit" value="Xoá">
    <input type="submit" value="Sửa">
    <input type="submit" value="Xem">
  </div>
  <h2>4. <a>Xem tổng doanh thu</a></h2>
</section>



<script src="./js/main.js"></script>
</body>

</html>
