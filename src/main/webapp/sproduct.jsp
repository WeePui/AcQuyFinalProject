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
        <li><a class="active" href="shop">SHOP</a></li>
        <li><a href="login.jsp">TÀI KHOẢN</a></li>
        <li><a href="cart.jsp">CART</a></li>
      </ul>
    </div>
  </section>
  <!--Body-->
  <section id="prodetails" class="section-p1">
    <div class="single-pro-img">
      <img src="${game.demo1}" width="600" height ="400" id="MainImg">
      <div class="small-img-group">
        <div class="small-img-col">
          <img src="${game.demo1}" width="140" height="100" class="small-img" alt="">
        </div>
        <div class="small-img-col">
          <img src="${game.demo2}" width="140" height="100" class="small-img" alt="">
        </div>
        <div class="small-img-col">
          <img src="${game.demo3}" width="140" height="100" class="small-img" alt="">
        </div>
        <div class="small-img-col">
          <img src="${game.demo4}"
 width="140" height="100" class="small-img" alt="">
        </div>
      </div>
    </div>
    <div class="single-pro-details">
        <h6><a href="index.jsp">Home</a> / <a href="index.jsp">Gerne</a></h6>
        <h4>${game.gameName}</h4>
        <h2>${game.price}</h2>
      <button onclick="window.location.href='addToCart?gameName=${game.gameName}&isRemove=false'" class="normal">Add to cart</button>
        <h4>Product details</h4>
        <span>${game.description}</span>
      </div>
  </section>
  <section class="public-details">

    <div>
      <table>
        <thead>
        <tr>
          <td>Nhà phát triển</td>
          <td>Nhà phát hành</td>
          <td>Thể loại</td>
          <td>Năm phát hành</td>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>${game.gameDeveloper}</td>
          <td>${game.gamePublisher}</td>
          <td>${category}</td>
          <td>${game.releaseDate}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </section>
  <footer class="section-p1">
    <div class="col">
      <img class="logo" src="./assets/Logo-white.png" width="100px" height="100px">
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
        <img src="./assets/pay.png">
      </div>
    </div>
  </footer>
  <div class="copyright">
    <p>
          <p><center>@ 2022, Kaiser.inc - AcQuy's all right reserved.</center></p>
    </p>
  </div>

  <script>
    var MainImg = document.getElementById("MainImg");
    var smallimg = document.getElementsByClassName("small-img");
      smallimg[0].onclick =function(){
        MainImg.src = smallimg[0].src;
      }
    smallimg[1].onclick =function(){
        MainImg.src = smallimg[1].src;
      }
    smallimg[2].onclick =function(){
        MainImg.src = smallimg[2].src;
      }
    smallimg[3].onclick =function(){
        MainImg.src = smallimg[3].src;
      }
    
  </script>

</body>

</html>