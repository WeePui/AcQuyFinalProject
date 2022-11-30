package nhom7.controller;

import nhom7.DAO.CustomerDB;
import nhom7.business.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        HttpSession session = req.getSession();
        Customer customer = (Customer) session.getAttribute("customer");

        if (CustomerDB.emailExists(customer.getEmail()))
            req.setAttribute("alertMsg", "Bạn đã đặt hàng thành công");
        else
            req.setAttribute("alertMsg", "Đặt hàng thất bại do bạn chưa đăng nhập");
        } catch (Exception e) {
            req.setAttribute("alertMsg", "Đặt hàng thất bại do bạn chưa đăng nhập");
        }
        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
