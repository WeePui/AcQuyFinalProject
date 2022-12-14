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
$(document).ready(function() {
  $(".checkRadioBtn1").click(function() {
    $("#radiobtn1").prop("checked", true);
  });
  $(".checkRadioBtn2").click(function() {
    $("#radiobtn2").prop("checked", true);
  });
});

$(document).ready(function() {
  // Activate tooltip
  $('[data-toggle="tooltip"]').tooltip();

  // Select/Deselect checkboxes
  var checkbox = $('table tbody input[type="checkbox"]');
  $("#selectAll").click(function() {
    if (this.checked) {
      checkbox.each(function() {
        this.checked = true;
      });
    } else {
      checkbox.each(function() {
        this.checked = false;
      });
    }
  });
  checkbox.click(function() {
    if (!this.checked) {
      $("#selectAll").prop("checked", false);
    }
  });
});
