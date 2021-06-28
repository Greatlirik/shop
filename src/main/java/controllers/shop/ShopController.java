package controllers.shop;



import com.google.gson.Gson;
import models.ShopModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


public class ShopController extends HttpServlet {




    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        Reader reader = new FileReader("C:\\Users\\Kirill\\Desktop\\workspace\\shop\\ShopData.json");

        // Convert JSON File to Java Object
        ShopModel shopModel = gson.fromJson(reader, ShopModel.class);
//        List<Shop> shops = shopModel.shopId();






        request.getRequestDispatcher("shops.jsp").forward(request, response);
    }





}
