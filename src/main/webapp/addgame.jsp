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
  <form action="addgame" method="post">
        <label>Name</label>
          <input size="50" name="gameName" type="text" class="form-control" required><br>
        <label>Image</label>
          <input size="50" name="image" type="text" class="form-control" required><br>
        <label>Price</label>
          <input size="50" name="price" type="text" class="form-control" required><br>
        <label>Description</label>
          <input size="50" name="description" class="form-control" required><br>
        <label>Developer</label>
          <input size="50" name="gameDeveloper" class="form-control" required><br>
        <label>Publisher</label>
          <input size="50" name="gamePublisher" class="form-control" required><br>
        <label>Demo1</label>
          <input size="50" name="demo1" class="form-control" required><br>
        <label>Demo2</label>
          <input size="50" name="demo2" class="form-control" required><br>
        <label>Demo3</label>
          <input size="50" name="demo3" class="form-control" required><br>
        <label>Demo4</label>
          <input size="50" name="demo3" class="form-control" required><br>
        <label>Release Date</label>
          <input size="50" name="releaseDate" class="form-control" required><br>
        <label>Category</label>
          <input size="50" name="category" class="form-control" required><br>
        <input size="50" type="button" onclick="window.location.href='manager.jsp'" value="Trở về">
        <input size="50" type="submit" value="Thêm">
  </form>
</section>



<script src="./js/main.js"></script>
</body>

</html>