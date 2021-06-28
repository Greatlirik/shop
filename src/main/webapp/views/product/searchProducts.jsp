<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Search results</title>
        <link rel="stylesheet" href="table.css">
    </head>

    <body>
        <div>
            <h1>Products</h1>
        </div>
        <table class="table">
            <thead>
                <tr><th>names</th><th>prices</th><th>shops</th></tr>
            </thead>
            <tbody>
                <%
                   List<String> names = (List<String>) request.getAttribute("productNames");
                   List<Integer> prices = (List<Integer>) request.getAttribute("productPrices");
                   List<List<String>> shops = (List<List<String>>) request.getAttribute("productShops");

                   if (names != null && !names.isEmpty()) {

                   for (int i = 0; i < names.size(); i++) {
                  out.println("<tr><td>" + names.get(i) + "</td>" + "<td>" + prices.get(i) + "</td>" + "<td>" + shops.get(i) + "</td></tr>");
                    }

                   } else out.println("<p>There are no products</p>");
                %>
            </tbody>
        </table>
        <div>
               <button onclick="location.href='/service.html'">Back to main</button>
               <button onclick="location.href='/products'">Back to Products</button>
        </div>
    </body>
</html>