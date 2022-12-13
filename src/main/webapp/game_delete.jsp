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
          <table class="table table-striped table-hover">
            <thead>
              <tr>
                <th>
                </th>
                <th>Name</th>
                <th>Image</th>
                <th>Price</th>
                <th>Game Developer</th>
                <th>Game Publisher</th>
                <th>Release Date</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${listP}" var="o">
                <tr>
                  <td>  
                      <input type="radio" id="checkbox1" name="options[]" value="1">
                  </td>
                  <td>${o.gameName}</td>
                  <td>
                    <img src="${o.image}">
                  </td>
                  <td>${o.gamePrice}</td>
                  <td>${o.gameDeveloper}</td>
                  <td>${o.gamePublisher}</td>
                  <td>${o.releaseDate} $</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>

      </div>
      <div class="modal-footer">
        <input size="50" type="submit" value="Cancel">
        <input size="50" type="submit" value="Delete">
      </div>
    </form>
  </section>



  <script src="./js/main.js"></script>
</body>

</html>
