package nhom7.controller;

import nhom7.DAO.CustomerDB;
import nhom7.DAO.InvoiceDB;
import nhom7.business.Cart;
import nhom7.business.Customer;
import nhom7.business.Game;
import nhom7.business.Invoice;
import nhom7.service.EmailUtility;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderController extends HttpServlet {
    private String host;
    private String port;
    private String user;
    private String pass;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        host=context.getInitParameter("host");
        port=context.getInitParameter("port");
        user=context.getInitParameter("user");
        pass=context.getInitParameter("pass");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession();
            Customer customer = (Customer) session.getAttribute("customer");

            if (customer == null) {
                req.setAttribute("message", "Vui lòng đăng nhập để tiến hành đặt hàng");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
            else {
                Cart cart = (Cart) session.getAttribute("cart");
                List<Game> games = cart.getItems();

                Invoice invoice = new Invoice(
                  new Date(),
                        games,
                        false
                );

                InvoiceDB.insert(invoice);
                List<Invoice> invoices = customer.getInvoices();
                invoices.add(invoice);

                customer.setInvoices(invoices);
                CustomerDB.update(customer);

                String email = customer.getEmail();
                String firstName = customer.getFirstName();
                String lastName = customer.getLastName();
                String phoneNumber = customer.getPhoneNumber();
                String address = customer.getAddress();
                String total = String.valueOf(cart.getTotal());

                String subject = "Cảm ơn bạn đã mua hàng";
                //HTML
                String content = "";

                try {
                    EmailUtility.sendMail(host, port, user, pass, email, subject, content);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                session.removeAttribute("cart");
                session.removeAttribute("total");
                req.getRequestDispatcher("/cart.jsp").forward(req, resp);
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
