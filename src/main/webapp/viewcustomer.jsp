<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Ác Quỷ Shop</title>
  <link rel="icon" type="image/x-icon" href="assets/icon.ico">
  <!--CSS-->
  <link href="./css/style.css" rel="stylesheet" type="text/css"/>

  <!--fontawesome-->
  <script src="https://kit.fontawesome.com/4d3747bacc.js" crossorigin="anonymous"></script>

</head>

<body>
<!--header-->
<section id="header2">
  <li><a class="logout-btn" href="logout">LOG OUT</a></li>
</section>
<!--Body-->
<section id="manager-table">
  <div>
    <table width="80%">
      <thead>
      <tr>
        <td>ID</td>
        <td>Tài khoản</td>
        <td>Mật khẩu</td>
        <td>Họ</td>
        <td>Tên</td>
        <td>Địa chỉ</td>
        <td>Điện thoại</td>
        <td>Email</td>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="p" items="${listP}">
        <tr>
          <td>${p.customerID}</td>
          <td>${p.userName}</td>
          <td>${p.password}</td>
          <td>${p.lastName}</td>
          <td>${p.firstName}</td>
          <td>${p.address}</td>
          <td>${p.phoneNumber}</td>
          <td>${p.email}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
  <div class="modal-footer">
    <input size="50" type="submit" value="Back">
  </div>
</section>


<script src="./js/main.js"></script>
</body>

</html>
