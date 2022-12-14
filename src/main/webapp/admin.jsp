<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Management page</title>
  <link rel="icon" type="image/x-icon" href="./assets/icon.ico">
  <!--CSS-->
  <link href="./css/style.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <!--fontawesome-->
  <script src="https://kit.fontawesome.com/4d3747bacc.js" crossorigin="anonymous"></script>
</head>

<body>
  <div class="container">
    <div class="table-wrapper">
      <div class="table-title">
        <div class="row">
          <div class="col-sm-6">
            <h2>Manage Game</h2>
          </div>
          <div class="col-sm-6">
            <a href="#addGameModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i>
              <span>Add New Game</span></a>
            <a href="delete" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i>
              <span>Delete</span></a>
            <a href="logout" class="btn btn-danger"><i class="fa fa-sign-out"></i>
              <span>Logout</span></a>
          </div>
        </div>
      </div>
      <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>
              <span class="custom-checkbox">
                <input type="checkbox" id="selectAll">
                <label for="selectAll"></label>
              </span>
            </th>
            <th>Name</th>
            <th>Image</th>
            <th>Price</th>
            <th>Description</th>
            <th>Game Developer</th>
            <th>Game Publisher</th>
            <th>Release Date</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${listP}" var="o">
            <tr>
              <td>
                <span class="custom-checkbox">
                  <input type="checkbox" id="checkbox1" name="options[]" value="1">
                  <label for="checkbox1"></label>
                </span>
              </td>
              <td>${o.gameName}</td>
              <td>
                <img src="${o.image}">
              </td>
              <td>${o.price}</td>
              <td>${o.description}</td>
              <td>${o.gameDeveloper}</td>
              <td>${o.gamePublisher}</td>
              <td>
                <img src="${o.demo1}">
              </td>
              <td>
                <img src="${o.demo2}">
              </td>
              <td>
                <img src="${o.demo3}">
              </td>
              <td>
                <img src="${o.demo4}">
              </td>
              <td>${o.releaseDate} $</td>
              <td>
                <a href="#editGameModal" class="edit" data-toggle="modal"><i class="material-icons"
                    data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                <a href="delete?gameName=${o.gameName}" class="delete" data-toggle="modal"><i class="material-icons"
                    data-toggle="tooltip" title="Delete">&#xE872;</i></a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
  <!-- Edit Modal HTML -->
  <div id="addGameModal" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <form action="add" method="post">
          <div class="modal-header">
            <h4 class="modal-title">Add New Game</h4>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          </div>
          <div class="modal-body">
            <div>
              <div class="form-group">
                <label>Name</label>
                <input name="gameName" type="text" class="form-control" required>
              </div>
              <div class="form-group">
                <label>Image</label>
                <input name="image" type="text" class="form-control" required>
              </div>
              <div class="form-group">
                <label>Price</label>
                <input name="price" type="text" class="form-control" required>
              </div>
            </div>
            <div>
              <div class="form-group">
                <label>Description</label>
                <textarea name="description" class="form-control" required></textarea>
              </div>
              <div class="form-group">
                <label>Developer</label>
                <textarea name="gameDeveloper" class="form-control" required></textarea>
              </div>
              <div class="form-group">
                <label>Publisher</label>
                <textarea name="gamePublisher" class="form-control" required></textarea>
              </div>
            </div>
            <div>
              <div class="form-group">
                <label>Demo1</label>
                <textarea name="demo1" class="form-control" required></textarea>
              </div>
              <div class="form-group">
                <label>Demo2</label>
                <textarea name="demo2" class="form-control" required></textarea>
              </div>
              <div class="form-group">
                <label>Demo3</label>
                <textarea name="demo3" class="form-control" required></textarea>
              </div>
            </div>
            <div>
              <div class="form-group">
                <label>Demo4</label>
                <textarea name="demo4" class="form-control" required></textarea>
              </div>
              <div class="form-group">
                <label>Release Date</label>
                <textarea name="releaseDate" class="form-control" required></textarea>
              </div>
              <div class="form-group">
                <label>Category</label>
                <c:forEach items="${listC}" var="o">
                  <select name="category" class="form-select" aria-label="Default select example">
                      <option value=${o.categoryName}></option>
                  </select>
                </c:forEach>
              </div>
            </div>

          </div>
          <div class="modal-footer">
            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
            <input type="submit" class="btn btn-success" value="Add">
          </div>
        </form>
      </div>
    </div>
  </div>
  <!-- Edit Modal HTML -->
  <div id="editGameModal" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <form>
          <div class="modal-header">
            <h4 class="modal-title">Edit Game</h4>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          </div>
          <div class="modal-body">
            <div>
              <div class="form-group">
                <label>Name</label>
                <input name="gameName" type="text" class="form-control" required>
              </div>
              <div class="form-group">
                <label>Image</label>
                <input name="image" type="text" class="form-control" required>
              </div>
              <div class="form-group">
                <label>Price</label>
                <input name="price" type="text" class="form-control" required>
              </div>
            </div>
            <div>
              <div class="form-group">
                <label>Description</label>
                <textarea name="description" class="form-control" required></textarea>
              </div>
              <div class="form-group">
                <label>Developer</label>
                <textarea name="gameDeveloper" class="form-control" required></textarea>
              </div>
              <div class="form-group">
                <label>Publisher</label>
                <textarea name="gamePublisher" class="form-control" required></textarea>
              </div>
            </div>
            <div>
              <div class="form-group">
                <label>Demo1</label>
                <textarea name="demo1" class="form-control" required></textarea>
              </div>
              <div class="form-group">
                <label>Demo2</label>
                <textarea name="demo2" class="form-control" required></textarea>
              </div>
              <div class="form-group">
                <label>Demo3</label>
                <textarea name="demo3" class="form-control" required></textarea>
              </div>
            </div>
            <div>
              <div class="form-group">
                <label>Demo4</label>
                <textarea name="demo4" class="form-control" required></textarea>
              </div>
              <div class="form-group">
                <label>Release Date</label>
                <textarea name="releaseDate" class="form-control" required></textarea>
              </div>
              <div class="form-group">
                <label>Category</label>
                <c:forEach items="${listC}" var="o">
                  <select name="category" class="form-select" aria-label="Default select example">
                    <option value=${o.categoryName}></option>
                  </select>
                </c:forEach>
              </div>
            </div>

          </div>
          <div class="modal-footer">
            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
            <input type="submit" class="btn btn-info" value="Save">
          </div>
        </form>
      </div>
    </div>
  </div>
  <!-- Delete Modal HTML -->
  <div id="deleteGameModal" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <form action="delete" method="postu">
          <div class="modal-header">
            <h4 class="modal-title">Delete Product</h4>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          </div>
          <div class="modal-body">
            <p>Are you sure you want to delete these Records?</p>
            <p class="text-warning"><small>This action cannot be undone.</small></p>
          </div>
          <div class="modal-footer">
            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
            <input type="submit" class="btn btn-danger" value="Delete">
          </div>
        </form>
      </div>
    </div>
  </div>

  <script src="js/main.js" type="text/javascript"></script>

</body>

</html>
