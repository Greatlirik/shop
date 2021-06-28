package controllers.shop;

import com.google.gson.Gson;
import models.ShopModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class AddShopController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("addShop.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        Reader reader = new FileReader("C:\\Users\\Kirill\\Desktop\\workspace\\shop\\ShopData.json");
        ShopModel shopModelFromJson = gson.fromJson(reader, ShopModel.class);

//        String name = req.getParameter("name");
//        String address = req.getParameter("address");
//        Integer id =
//
//        Shop shop = new Shop(address, name);
//
//
//
//        shopModelFromJson.add(shop);
//
//        try (FileWriter writer = new FileWriter("C:\\Users\\Kirill\\Desktop\\workspace\\shop\\ShopData.json")) {
//            gson.toJson(shopModelFromJson, writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        doGet(req, resp);
    }

}
