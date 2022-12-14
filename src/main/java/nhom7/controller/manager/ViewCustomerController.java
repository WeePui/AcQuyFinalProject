package nhom7.controller.manager;

import nhom7.DAO.CategoryDB;
import nhom7.DAO.CustomerDB;
import nhom7.DAO.GameDB;
import nhom7.business.Category;
import nhom7.business.Customer;
import nhom7.business.Game;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(value = "/viewcustomer")
public class ViewCustomerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDB customerDB = new CustomerDB();

        List<Customer> customers = customerDB.selectCustomers();

        req.setAttribute("listP", customers);

        req.getRequestDispatcher("/viewcustomer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
