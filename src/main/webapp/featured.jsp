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
  </section>
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
        <li><a class="active" href="shop">SHOP</a></li>
        <li><a href="account">
          <c:choose>
            <c:when test="${sessionScope.customer!=null}">
              Chào, ${sessionScope.customer.firstName}            </c:when>
            <c:when test="${sessionScope.customer==null}">
              ĐĂNG NHẬP
            </c:when>
          </c:choose>
        </a></li>
        <li><a href="cart.jsp">CART(<span>${sessionScope.cart.count}</span>)</a></li>
      </ul>
    </div>
  </section>
  <!--Body-->
   <div class="temp">
    <h2>Featured Products</h2>
    <p>To be added</p>
  </div>
  <section id="product1" class="section-p1">
    <form class="filter" action="filter">
      <h6 style="font-size: 46px; color: gold;">Filter</h6>
      <c:forEach items="${listC}" var="o">
        <div class="gen">
          <input type="radio" id="gen1" name="checkedItem" value="${o.categoryName}">
          <label>${o.categoryName}</label>
        </div>
      </c:forEach>

      <input type="submit" value="Filter">
    </form>

    <div class="pro-container">
      <c:forEach var="p" items="${listP}">
        <div class="pro" onclick="window.location.href='detail?gameName=${p.gameName}'">
          <img style="width:224px;height:224px;" src="${p.image}">
          <div class="des">
            <h6>${p.gameDeveloper}</h6>
            <h5>${p.gameName}</h5>
            <h4>${p.price} VNĐ</h4>
          </div>
          <div class="cart">
            <a href="addToCart?gameName=${p.gameName}&isRemove=false"><i class="fa-solid fa-cart-shopping"></i></a>
          </div>
        </div>
      </c:forEach>
      
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
      <p>Trang web được code bằng tình yêu, mồ hôi, nước mắt, và rất nhiều Cafe <i class="fa fa-coffee" style="font-size:24px"></i></p>
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
