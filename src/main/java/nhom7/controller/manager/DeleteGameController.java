package nhom7.controller.manager;

import nhom7.DAO.GameDB;
import nhom7.business.Game;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deletegame")
public class DeleteGameController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
