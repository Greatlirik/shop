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

public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Gson gson = new Gson();
        Reader reader = new FileReader("C:\\Users\\Kirill\\Desktop\\workspace\\shop\\ProductData.json");

        // Convert JSON File to Java Object
        ProductModel productModel = gson.fromJson(reader, ProductModel.class);

        List<String> names = productModel.productNames();
        List<Integer> prices = productModel.productPrices();
        List<List<String>> shops = productModel.productShops();
        req.setAttribute("productNames", names);
        req.setAttribute("productPrices", prices);
        req.setAttribute("productShops", shops);



        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/product/products.jsp");
        requestDispatcher.forward(req, resp);
    }
}
