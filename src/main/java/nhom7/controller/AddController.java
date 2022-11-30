package nhom7.controller;

import nhom7.DAO.CategoryDB;
import nhom7.DAO.GameDB;
import nhom7.business.Category;
import nhom7.business.Customer;
import nhom7.business.Game;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddController extends HttpServlet {
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

        Game game = new Game();
        List<Category> categories = new ArrayList<Category>();
        categories.add(CategoryDB.selectCategories(category));
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

        GameDB gameDB = new GameDB();
        CategoryDB categoryDB = new CategoryDB();
        List<Game> games = gameDB.selectGames();
        List<Category> categories1 = categoryDB.selectCategories();

        req.setAttribute("listP", games);
        req.setAttribute("listC", categories1);

        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
