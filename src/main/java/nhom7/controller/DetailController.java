package nhom7.controller;

import nhom7.DAO.GameDB;
import nhom7.business.Category;
import nhom7.business.Game;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset = UTF-8");

        HttpSession session = req.getSession();

        String gameName = req.getParameter("gameName");

        Game game = GameDB.selectGame(gameName);

        String category = "";
        for (Category cate:
             game.getCategories()) {
            category += cate.getCategoryName() + ", ";
        }
        category += "...";

        session.setAttribute("game", game);
        session.setAttribute("category", category);

        req.getRequestDispatcher("/sproduct.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
