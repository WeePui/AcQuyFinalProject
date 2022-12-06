    function LoginFunc() {
    alert("Đăng nhập thành công!");
  }
    function myFunction1() {
    alert("Email xác nhận đã được gửi cho bạn!");
  }
  var MainImg = document.getElementById("MainImg");
  var smallimg = document.getElementsByClassName("small-img");
  smallimg[0].onclick = function() {
    MainImg.src = smallimg[0].src;
  }
  smallimg[1].onclick = function() {
    MainImg.src = smallimg[1].src;
  }
  smallimg[2].onclick = function() {
    MainImg.src = smallimg[2].src;
  }
  smallimg[3].onclick = function() {
    MainImg.src = smallimg[3].src;
  }
