package controllers.product;


import com.google.gson.Gson;
import entities.Category;
import entities.Product;
import models.ProductModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddProductsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/product/addProducts.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Category category;
        
        switch (req.getParameter("categories")) {
            case "toys":
                category = Category.TOYS;
                break;
            case "clothes":
                category = Category.CLOTHES;
                break;
            case "electrical_appliances":
                category = Category.ELECTRICAL_APPLIANCES;
                break;
            case "household_chemicals":
                category = Category.HOUSEHOLD_CHEMICALS;
                break;
            default:
                category = Category.OTHER;
                break;
        }

        String name = req.getParameter("name");
        int  price = Integer.parseInt(req.getParameter("price"));
        List<String> shops = new ArrayList<>(Arrays.asList(req.getParameter("shops").split(",")));

        Product product = new Product(name, price, shops, category);

        Gson gson = new Gson();
        Reader reader = new FileReader("ProductData.json");
        ProductModel productModelFromJson = gson.fromJson(reader, ProductModel.class);
        productModelFromJson.add(product);

        try (FileWriter writer = new FileWriter("ProductData.json")) {
            gson.toJson(productModelFromJson, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        resp.setStatus(201);
        doGet(req, resp);
    }

}