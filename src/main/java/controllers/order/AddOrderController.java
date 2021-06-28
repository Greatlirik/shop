package controllers.order;

import com.google.gson.Gson;
import entities.Order;
import models.OrderModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class AddOrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/order/addOrder.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String client = req.getParameter("client");
        String shop = req.getParameter("shop");
        String product = req.getParameter("product");

        Order order = new Order(client, shop, product);


        Gson gson = new Gson();
        Reader reader = new FileReader("C:\\Users\\Kirill\\Desktop\\workspace\\shop\\OrderData.json");
        OrderModel orderModelFromJson = gson.fromJson(reader, OrderModel.class);
       orderModelFromJson.add(order);

        try (FileWriter writer = new FileWriter("C:\\Users\\Kirill\\Desktop\\workspace\\shop\\OrderData.json")) {
            gson.toJson(orderModelFromJson, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        resp.setStatus(201);
        doGet(req, resp);
    }

}

