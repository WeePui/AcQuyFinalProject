package nhom7.controller.manager;

import nhom7.DAO.GameDB;
import nhom7.business.Game;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(value = "/viewgame")
public class ViewGameController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GameDB gameDB = new GameDB();

        List<Game> games = gameDB.selectGames();

        req.setAttribute("listP", games);

        req.getRequestDispatcher("/viewgame.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
