package nhom7.controller;

import nhom7.DAO.CustomerDB;
import nhom7.business.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SignInController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String action = req.getParameter("action");

        PrintWriter out = resp.getWriter();

        if (action == null) {
            action = "join";
        }

        String url = "";

        if (action.equals("join")) {
            url = "/sign.jsp";
        }
        else if (action.equals("add")) {
            String userName = req.getParameter("userName");
            String password = req.getParameter("password");
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");
            String phoneNumber = req.getParameter("phoneNumber");
            String address = req.getParameter("address");

            Customer customer = new Customer(userName, password, lastName, firstName, email, phoneNumber, address, false);

            String message = "";

            if (CustomerDB.emailExists(customer.getEmail())) {
                url = "/sign.jsp";
                message = "Email đã tồn tại vui lòng nhập lại!!!";
            } else if (CustomerDB.userNameExists(customer.getUserName())) {
                url = "/sign.jsp";
                message = "Tài khoản đã tồn tại vui lòng nhập lại!!!";
            } else if (CustomerDB.phoneNumberExists(customer.getPhoneNumber())) {
                url = "/sign.jsp";
                message = "Số điện thoại bạn vừa nhập đã tồn tại trên hệ thống";
            } else {
                CustomerDB.insert(customer);

                message = "Bạn đã đăng kí thành công";

                url="/login.jsp";
            }

            req.setAttribute("message", message);

            req.getRequestDispatcher(url).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
