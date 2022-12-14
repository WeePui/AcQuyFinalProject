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
  <link href="css/style.css" rel="stylesheet" type="text/css" />

  <!--fontawesome-->
  <script src="https://kit.fontawesome.com/4d3747bacc.js" crossorigin="anonymous"></script>

</head>

<body>
<!--header-->
<section id="header">
  <div>
    <a href="#"><img src="assets/logo.png" class="logo" alt=""></a>
  </div>
  <div class="searchbar">
    <form action="search" method="post">
      <input name="searchContent" type="text" placeholder="Từ khoá">
      <button type="submit" onclick="window.location.href='search'">Search</button>
    </form>
  </div>
  <div>
    <ul id="navbar">
      <li><a href="index.jsp">HOME</a></li>
      <li><a href="shop">SHOP</a></li>
      <li><a href="account">
        <c:choose>
          <c:when test="${sessionScope.customer!=null}">
            Chào, ${sessionScope.customer.firstName}            </c:when>
          <c:when test="${sessionScope.customer==null}">
            ĐĂNG NHẬP
          </c:when>
        </c:choose>
      </a></li>
      <li><a class="active" href="cart.jsp">CART(<span>${sessionScope.cart.count}</span>)</a></li>
    </ul>
  </div>
</section>
<!--Body-->
<section id="cart" class="section-p1">
  <button onclick="document.location='shop'">Back</button>
  <table width="1480px">
    <thead>
    <tr>
      <td>Loại bỏ</td>
      <td>Sản phẩm</td>
      <td>Tên</td>
      <td>Giá tiền</td>
    </tr>
    <c:forEach var="item" items="${cart.items}">
      <tr>
        <td><a href="addToCart?gameName=${item.gameName}&isRemove=true"><i class="far fa-times-circle"></i></a></td>
        <td><img src="${item.image}"></td>
        <td>${item.gameName}</td>
        <td>${item.price} VNĐ</td>
      </tr>
    </c:forEach>
    </thead>

  </table>
</section>
<section id="cart-add" class="section-p1">
  <div id="subtotal">
    <h3>Tổng giỏ hàng ${total} VNĐ</h3>
    <button class="normal" onclick="window.location.href='order'">Xác nhận</button>
  </div>
</section>
<footer class="section-p1">
  <div class="col">
    <img class="logo" src="assets/logo.png" width="130px" height="130px">
    <h4>Liên hệ</h4>
    <p><strong>Địa chỉ: </strong>01, Võ Văn Ngân, P. Linh Chiểu, TP. Thủ Đức</p>
    <p><strong>Điện thoại: </strong>0767989557 - 0123456789</p>
    <p><strong>Làm việc: </strong>6AM - 7PM các ngày trong tuần</p>
  </div>

  <div class="col">
    <h4>Giới thiệu</h4>
    <p>Là một trong các cửa hàng mua game uy tín hàng đầu việt nam &#128039;</p>
    <p>Chúng tôi hân hạnh cung cấp cho bạn các tựa game bom tấn với giá rẻ bất ngờ &#128039;</p>
    <p>Trang web được code bằng tình yêu, mồ hôi, nước mắt, và rất nhiều Cafe <i class="fa fa-coffee"
                                                                                 style="font-size:24px"></i></p>
  </div>
  <div>
    <div class="follow">
      <h4>Theo dõi chúng tôi tại</h4>
      <div class="icon">
        <a href="https://www.facebook.com/weepui.bh/" class="fab fa-facebook-f fa-2xl"></a>
        <a href="https://twitter.com/weepui_it" class="fab fa-twitter fa-2xl"></a>
        <a href="https://www.instagram.com/weepui.nouseins/" class="fab fa-instagram fa-2xl"></a>
        <a href="https://www.youtube.com/channel/UCYYoU1WD5Xhgz_4iOEG2TXQ" class="fab fa-youtube fa-2xl"></a>
      </div>
    </div>
    <div class="payment">
      <h4>Được bảo mật bởi</h4>
      <img src="assets/pay.png">
    </div>
  </div>
</footer>
<div class="copyright">
  <p>
  <center>@ 2022, Kaiser.inc - AcQuy's all right reserved.</center>
  </p>
</div>

<script src="./js/main.js"></script>
</body>

</html>