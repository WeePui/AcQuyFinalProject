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

public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchContent = req.getParameter("searchContent");

        GameDB gameDB = new GameDB();
        List<Game> games = gameDB.selectGames(searchContent);
        CategoryDB categoryDB = new CategoryDB();
        List<Category> categories = categoryDB.selectCategories();

        req.setAttribute("listC", categories);
        req.setAttribute("listP", games);

        req.getRequestDispatcher("/featured.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
