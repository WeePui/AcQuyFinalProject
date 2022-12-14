package nhom7.controller.manager;

import nhom7.DAO.CategoryDB;
import nhom7.DAO.GameDB;
import nhom7.business.Category;
import nhom7.business.Game;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(value = "/addgame")
public class AddGameController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

        List<Category> categories = new ArrayList<Category>();
        Category newCate = new Category(category);
        //CategoryDB.insert(newCate);
        categories.add(newCate);

        Game game = new Game(
                gameName,
                image,
                Long.parseLong(price),
                description,
                gameDeveloper,
                gamePublisher,
                demo1,
                demo2,
                demo3,
                demo4,
                new Date(releaseDate)
        );
        game.setCategories(categories);

        GameDB.insert(game);

        req.setAttribute("message", "Đã thêm thành công");

        req.getRequestDispatcher("/addgame.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
