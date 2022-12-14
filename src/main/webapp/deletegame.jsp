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
  <h1>${message}</h1>
  <form action="deletegame" method="post">
    <div class="pen-body">
      <div>
        <div><label>Name</label>
          <input size="50" name="gameName" type="text" class="form-control" required>
        </div>
      </div>

    </div>
    <div class="modal-footer">
      <input size="50" type="button" onclick="window.location.href='manager.jsp'" value="Trở về">
      <input size="50" type="submit" value="Xóa">
    </div>
  </form>
</section>



<script src="./js/main.js"></script>
</body>

</html>