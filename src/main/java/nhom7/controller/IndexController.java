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
import java.util.List;

public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //processRequest(req, resp);
        resp.setContentType("text/html; charset = UTF-8");

        GameDB gameDB = new GameDB();
        CategoryDB categoryDB = new CategoryDB();

        List<Game> games = gameDB.selectGames();
        List<Category> categories = categoryDB.selectCategories();

        req.setAttribute("listP", games);
        req.setAttribute("listC", categories);

        getServletContext().getRequestDispatcher("/featured.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //processRequest(req, resp);
        doGet(req, resp);
    }
}
