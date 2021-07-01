package controllers.order;

import com.google.gson.Gson;
import models.OrderModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class OrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        Reader reader = new FileReader("OrderData.json");

        // Convert JSON File to Java Object
        OrderModel orderModel = gson.fromJson(reader, OrderModel.class);


        List<String> clients = orderModel.clients();
        List<String> shops = orderModel.shops();
        List<String> products = orderModel.products();

        req.setAttribute("clients", clients);
        req.setAttribute("shops", shops);
        req.setAttribute("products", products);




        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/order/orders.jsp");
        requestDispatcher.forward(req, resp);
    }

}
