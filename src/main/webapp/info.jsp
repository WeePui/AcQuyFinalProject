<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Ác Quỷ Shop</title>
  <link rel="icon" type="image/x-icon" href="./assets/icon.ico">
  <!--CSS-->
  <link href="./css/style.css" rel="stylesheet" type="text/css" />

  <!--fontawesome-->
  <script src="https://kit.fontawesome.com/4d3747bacc.js" crossorigin="anonymous"></script>

</head>

<body>
  <!--header-->
  <section id="header">
    <a href="#"><img src="./assets/logo.png" class="logo" alt=""></a>
    <div class="searchbar">
      <form action="search" method="post">
        <input name="searchContent" type="text" placeholder="Từ khoá">
        <button type="submit">Search</button>
      </form>
    </div>
    <div>
      <ul id="navbar">
        <li><a href="index.jsp">HOME</a></li>
        <li><a href="shop">SHOP</a></li>
        <li><a class="active" href="login.jsp">TÀI KHOẢN</a></li>
        <li><a href="cart.jsp">CART</a></li>
      </ul>
    </div>
  </section>
  <!--Body-->
  <section id="signin">
    <button onclick="window.location.href='shop'">Back</button>
    <div>
      <div id="signin-section">
        <form action="signin" method="post">
          <input type="hidden" value="add" name="action">
          <div class="sign">
            <div>
              <p>Họ</p>
              <input type="text" value="An" name="lastName" readonly>
              <p>Tên</p>
              <input type="text" value="Khang" name="firstName" readonly>
            </div>
            <div>
              <p>Steam friend code</p>
              <input type="text" value="123456" name="steamFriendCode" readonly>
              <p>Email</p>
              <input type="text" value="ditmemay@gmail.com" name="email" readonly>
            </div>

            <input class="logout-btn"  type="submit" value="Đăng xuất">
          </div>
        </form>
      </div>
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
          <i class="fab fa-facebook-f fa-2xl"></i>
          <i class="fab fa-twitter fa-2xl"></i>
          <i class="fab fa-instagram fa-2xl"></i>
          <i class="fab fa-youtube fa-2xl"></i>
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
