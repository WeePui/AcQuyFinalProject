package nhom7.controller;

import nhom7.DAO.GameDB;
import nhom7.business.Cart;
import nhom7.business.Game;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddToCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = getServletContext();

        String gameName = req.getParameter("gameName");
        String isRemove = req.getParameter("isRemove");

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        Game item = GameDB.selectGame(gameName);

        if(isRemove.equals("false")) {
            cart.addItem(item);
        }
        else {
            cart.removeItem(item);
        }

        session.setAttribute("total", cart.getTotal());
        session.setAttribute("cart", cart);

        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
