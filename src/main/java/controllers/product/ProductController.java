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
import java.util.Locale;
import java.util.stream.Collectors;

public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Gson gson = new Gson();
        Reader reader = new FileReader("ProductData.json");

        // Convert JSON File to Java Object
        ProductModel productModel = gson.fromJson(reader, ProductModel.class);

        List<String> names = productModel.productNames();
        List<Integer> prices = productModel.productPrices();
        List<List<String>> shops = productModel.productShops();
        List<String> categories = productModel.productCategories();

        String filteredCategory = req.getParameter("categories");


        System.out.println(filteredCategory);
        if (filteredCategory!= null && !filteredCategory.equalsIgnoreCase("all")){
            categories = categories.stream().filter(s -> s.contains(filteredCategory.toUpperCase(Locale.ROOT))).collect(Collectors.toList());

        }


        req.setAttribute("productNames", names);
        req.setAttribute("productPrices", prices);
        req.setAttribute("productShops", shops);
        req.setAttribute("productCategories", categories);



        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/product/products.jsp");
        requestDispatcher.forward(req, resp);
    }



}
