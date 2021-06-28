
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Products</title>
        <link rel="stylesheet" href="table.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
        <script src="sort.js"></script>
    </head>

    <body>
        <div>
            <h1>Products</h1>
        </div>
        <div class="nav-item">
            <form action="/searchProducts"  method="get">
                 <input type="hidden" name="_csrf" value="{{_csrf.token}}"/>
                 <input type="search" name="query" required placeholder="Поиск по сайту">
                 <input type="submit" value="Найти">
            </form>
        </div>

        <table class="table" id= "maintable">
            <thead>
                <tr><th>names</th><th id="prices" onclick="sort_price();">prices</th><th>shops</th></tr>
            </thead>
            <tbody id ="table1">
                <%
                   List<String> names = (List<String>) request.getAttribute("productNames");
                   List<Integer> prices = (List<Integer>) request.getAttribute("productPrices");
                   List<List<String>> shops = (List<List<String>>) request.getAttribute("productShops");

                   if (names != null && !names.isEmpty()) {

                   for (int i = 0; i < names.size(); i++) {
                  out.println("<tr><td>" + names.get(i) + "</td>" + "<td>" + prices.get(i) + "</td>" + "<td>" + shops.get(i) + "</td></tr>");
                    }

                   } else out.println("<p>There are no products yet!</p>");
                %>
            </tbody>
        </table>
        <input type="hidden" id="price_order" value="asc">


        <div>
               <button onclick="location.href='/service.html'">Back to main</button>
               <button onclick="location.href='/addProducts'">Add Products</button>
        </div>
    </body>
</html>