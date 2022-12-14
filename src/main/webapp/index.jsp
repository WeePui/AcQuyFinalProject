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
        <li><a class="active" href="index.jsp">HOME</a></li>
        <li><a href="shop">SHOP</a></li>
        <li><a href="account">TÀI KHOẢN</a></li>
        <li><a href="cart.jsp">CART(<span>${sessionScope.cart.count}</span>)</a></li>
      </ul>
    </div>
  </section>
  <!--Body-->
  <div class="galaxy">
    <section id="hero">
      <div class="sectiom-p1">
        <h4>DEAL SIÊU HẤP DẪN!</h4>
        <h2>SUPER SALE</h2>
        <h1>ÁP DỤNG CHO MỌI GAME</h1>
        <p>GIẢM LÊN ĐẾN 50%</p>
        <Button><a href="featured.html">MUA NGAY!</a></Button>
      </div>
      <div>
        <iframe width="1120" height="630" src="https://www.youtube-nocookie.com/embed/53ONj7l_KPY?autoplay=1&mute=1" title="PGR Demo" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
      </div>
    </section>
    <section id="features" class="section-p1">
      <div class="fe-box">
        <img src="assets/02.png" alt="" width="150" height="150">
        <h6>TIẾT KIỆM CHI PHÍ</h6>
      </div>
      <div class="fe-box">
        <img src="assets/03.png" alt="" width="150" height="150">
        <h6>MUA GAME ONLINE</h6>
      </div>
      <div class="fe-box">
        <img src="assets/04.png" alt="" width="150" height="150">
        <h6>HOẠT ĐỘNG MỌI LÚC</h6>
      </div>
      <div class="fe-box">
        <img src="assets/05.png" alt="" width="150" height="150">
        <h6>NHẬN GAME CODE</h6>
      </div>
    </section>
    <section id="newcommer" class="section-p1">
      <div class=newtext>
        <h4>Đăng kí để nhận thêm nhiều ưu đãi</h4>
        <p>Nhận ngay tin tức mới nhất về game và nhiều<span> ƯU ĐÃI ĐẶC BIỆT</span></p>
      </div>
      <div>
        <div class="form">
          <input type="text" style="text-align: center" placeholder="Tạo tài khoản ngay nào!!" readonly>
          <button onclick="document.location='sign.jsp'" type="button" class="normal">Đăng kí ngay</button>
        </div>
      </div>
    </section>
  </div>
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
