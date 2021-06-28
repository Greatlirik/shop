package controllers.product;

import com.google.gson.Gson;
import models.ProductModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

public class SearchProductsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Gson gson = new Gson();
        Reader reader = new FileReader("C:\\Users\\Kirill\\Desktop\\workspace\\shop\\ProductData.json");

        // Convert JSON File to Java Object
        ProductModel productModel = gson.fromJson(reader, ProductModel.class);



        List<String> names = productModel.productNames();
        List<Integer> prices = productModel.productPrices();
        List<List<String>> shops = productModel.productShops();

        String query = req.getParameter("query");


        List<String> queryResult = names.stream().filter(s -> s.contains(query)).collect(Collectors.toList());

        req.setAttribute("productNames", queryResult);
        req.setAttribute("productPrices", prices);
        req.setAttribute("productShops", shops);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/product/searchProducts.jsp");
        requestDispatcher.forward(req, resp);
    }
}

