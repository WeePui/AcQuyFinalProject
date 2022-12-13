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
    <form action="save" method="post">
      <div class="pen-body">
        <div>
          <div><label>Name</label>
            <input size="50" name="gameName" type="text" class="form-control" required>
          </div>
          <div><label>Image</label>
            <input size="50" name="image" type="text" class="form-control" required>
          </div>
          <div><label>Price</label>
            <input size="50" name="price" type="text" class="form-control" required>
          </div>
          <div><label>Description</label>
            <input size="50" name="description" class="form-control" required>
          </div>
          <div> <label>Developer</label>
            <input size="50" name="gameDeveloper" class="form-control" required>
          </div>
          <div><label>Publisher</label>
            <input size="50" name="gamePublisher" class="form-control" required>
          </div>
          <div><label>Demo1</label>
            <input size="50" name="demo1" class="form-control" required>
          </div>
          <div><label>Demo2</label>
            <input size="50" name="demo2" class="form-control" required>
          </div>
          <div><label>Demo3</label>
            <input size="50" name="demo3" class="form-control" required>
          </div>
          <div><label>Demo4</label>
            <input size="50" name="demo3" class="form-control" required>
          </div>
          <div><label>Release Date</label>
            <input size="50" name="releaseDate" class="form-control" required>
          </div>
          <div><label>Category</label>
            <select name="category" class="form-select" aria-label="Default select example">
              <c:forEach items="${listC}" var="o">
                <option value=${o.categoryName}></option>
              </c:forEach>
            </select>
          </div>
        </div>

      </div>
      <div class="modal-footer">
        <input size="50" type="submit" class="btn btn-secondary" value="Cancel">
        <input size="50" type="submit" class="btn btn-success" value="Save">
      </div>
    </form>
  </section>



  <script src="./js/main.js"></script>
</body>

</html>
