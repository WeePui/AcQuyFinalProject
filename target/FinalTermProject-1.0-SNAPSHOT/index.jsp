<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Ác Quỷ Shop</title>
   <link rel="icon" type="image/x-icon" href="assets/icon.ico">
  <!--CSS-->
  <link href="css/style.css" rel="stylesheet" />

  <!--fontawesome-->
  <script src="https://kit.fontawesome.com/4d3747bacc.js" crossorigin="anonymous"></script>
  
</head>

<body>
  <!--header-->
  <% String message = (String)request.getAttribute("alertMsg");%>
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
        <li><a class="active" href="index.jsp">HOME</a></li>
        <li><a href="shop">SHOP</a></li>
        <li><a href="login.jsp">TÀI KHOẢN</a></li>
        <li><a href="cart.jsp">CART</a></li>
      </ul>
    </div>
  </section>
  <!--Body-->
  <section id="hero">
    <h4>DEAL SIÊU HẤP DẪN!</h4>
    <h2>SUPER SALE</h2>
    <h1>ÁP DỤNG CHO MỌI GAME</h1>
    <p>GIẢM LÊN ĐẾN 50%</p>
    <Button>MUA NGAY!</Button>
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
  <section id="newcommer" class="section-p1 section-m1">
    <div class=newtext>
      <h4>Đăng kí để nhận thêm nhiều ưu đãi</h4>
      <p>Nhận ngay tin tức mới nhất về game và nhiều<span> ƯU ĐÃI ĐẶC BIỆT</span></p>
    </div>
    <div>
      <div class="form">
        <input type="text" placeholder="Email của bạn">
        <button type="button" class="normal">Đăng kí ngay</button>
      </div>
    </div>
  </section>
  <footer class="section-p1">
    <div class="col">
      <img class="logo" src="assets/Logo-white.png" width="100px" height="100px">
      <h4>Liên hệ</h4>
      <p><strong>Địa chỉ: </strong>01, Võ Văn Ngân, P. Linh Chiểu, TP. Thủ Đức</p>
      <p><strong>Điện thoại: </strong>0767989557 - 0123456789</p>
      <p><strong>Làm việc: </strong>6AM - 7PM các ngày trong tuần</p>
    </div>

    <div class="col">
      <h4>Giới thiệu</h4>
      <p>Là một trong các cửa hàng mua game uy tín hàng đầu việt nam &#128039;</p>
      <p>Chúng tôi hân hạnh cung cấp cho bạn các tựa game bom tấn với giá rẻ bất ngờ &#128039;</p>
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
    <p><center>@ 2022, Kaiser.inc - AcQuy's all right reserved.</center></p>
  </div>

  <script src="js/main.js"></script>
  <script type="text/javascript">
    var msg = "<%=message%>";
    alert(msg);
  </script>

</body>

</html>