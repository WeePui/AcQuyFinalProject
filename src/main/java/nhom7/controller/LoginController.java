package nhom7.controller;

import nhom7.DAO.CategoryDB;
import nhom7.DAO.CustomerDB;
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
import java.util.List;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String message = "";

        Customer customer = CustomerDB.login(userName, password);
        if(customer != null){
            HttpSession session = req.getSession();
            session.setAttribute("customer", customer);

            String url = "";

            if (customer.isAdmin()){
                url = "/manager.jsp";
                GameDB gameDB = new GameDB();
                List<Game> games = gameDB.selectGames();
                CategoryDB categoryDB = new CategoryDB();
                List<Category> categories = categoryDB.selectCategories();

                session.setMaxInactiveInterval(10);

                req.setAttribute("listC", categories);
                req.setAttribute("listP", games);
            }
            else {
                message = "Bạn đã đăng nhập thành công";
                req.setAttribute("message", message);
                url = "/login.jsp";
            }

            req.getRequestDispatcher(url).forward(req, resp);
        } else {
            message = "Sai tài khoản/mật khẩu";

            req.setAttribute("message", message);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
