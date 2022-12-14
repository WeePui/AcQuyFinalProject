package nhom7.controller;

import nhom7.DAO.CategoryDB;
import nhom7.DAO.GameDB;
import nhom7.business.Category;
import nhom7.business.Game;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerController extends HttpServlet {
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("Xem Game"))
            viewGame(req, resp);
        else if (action.equals("InsertGame"))
            addGame(req, resp);
        else if (action.equals("Sửa Game"))
            updateGame(req, resp);
        else if (action.equals("Xóa Game"))
            deleteGame(req, resp);
        else if (action.equals("Back"))
            req.getRequestDispatcher("/manager.jsp").forward(req, resp);
    }

    private void viewGame(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GameDB gameDB = new GameDB();

        List<Game> games = gameDB.selectGames();

        req.setAttribute("listP", games);

        req.getRequestDispatcher("/viewgame.jsp").forward(req, resp);
    }

    private void addGame(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gameName = req.getParameter("gameName");
        String price = req.getParameter("price");
        String description = req.getParameter("description");
        String demo1 = req.getParameter("demo1");
        String demo2 = req.getParameter("demo2");
        String demo3 = req.getParameter("demo3");
        String demo4 = req.getParameter("demo4");
        String image = req.getParameter("image");
        String gameDeveloper = req.getParameter("gameDeveloper");
        String gamePublisher = req.getParameter("gamePublisher");
        String category = req.getParameter("category");
        String releaseDate = req.getParameter("releaseDate");

        Game game = new Game();
        List<Category> categories = new ArrayList<Category>();
        Category newCate = new Category(category);
        CategoryDB.insert(newCate);
        categories.add(newCate);
        game.setCategories(categories);
        game.setGameName(gameName);
        game.setPrice(Long.parseLong(price));
        game.setGameDeveloper(gameDeveloper);
        game.setGamePublisher(gamePublisher);
        game.setDescription(description);
        game.setImage(image);
        game.setReleaseDate(new Date(releaseDate));
        game.setDemo1(demo1);
        game.setDemo2(demo2);
        game.setDemo3(demo3);
        game.setDemo4(demo4);

        GameDB.insert(game);

        req.setAttribute("message", "Đã thêm thành công");

        req.getRequestDispatcher("/addgame.jsp").forward(req, resp);
    }

    private void deleteGame(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gameName = req.getParameter("gameName");

        Game game = GameDB.selectGame(gameName);
        String message = "";

        if(game != null) {
            GameDB.delete(game);
            message = "Đã xóa thành công";
        }
        else {
            message = "Game muốn xóa không tồn tại trên hệ thống";
        }

        req.setAttribute("message", message);
        req.getRequestDispatcher("/deletegame.jsp").forward(req, resp);
    }

    private void updateGame(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gameID = req.getParameter("gameID");
        String gameName = req.getParameter("gameName");
        String price = req.getParameter("price");
        String description = req.getParameter("description");
        String demo1 = req.getParameter("demo1");
        String demo2 = req.getParameter("demo2");
        String demo3 = req.getParameter("demo3");
        String demo4 = req.getParameter("demo4");
        String image = req.getParameter("image");
        String gameDeveloper = req.getParameter("gameDeveloper");
        String gamePublisher = req.getParameter("gamePublisher");
        String category = req.getParameter("category");
        String releaseDate = req.getParameter("releaseDate");
        Game game = GameDB.selectGame(gameID);
        String message = "";

        if(game != null) {
            game.setGameName(gameName);
            game.setPrice(Long.parseLong(price));
            game.setDescription(description);
            game.setDemo1(demo1);
            game.setDemo2(demo2);
            game.setDemo3(demo3);
            game.setDemo4(demo4);
            game.setImage(image);
            game.setGameDeveloper(gameDeveloper);
            game.setGamePublisher(gamePublisher);
            game.setReleaseDate(new Date(releaseDate));
            List<Category> categories = new ArrayList<Category>();
            Category newCate = new Category(category);
            CategoryDB.insert(newCate);
            categories.add(newCate);
            game.setCategories(categories);

            GameDB.update(game);

            message = "Đã chỉnh sửa thành công";
        }
        else {
            message = "Game muốn sửa không tồn tại trên hệ thống";
        }

        req.setAttribute("message", message);
        req.getRequestDispatcher("updategame.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
