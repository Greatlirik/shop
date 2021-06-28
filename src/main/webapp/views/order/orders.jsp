
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>orders</title>
        <link rel="stylesheet" href="table.css">
    </head>

    <body>
        <div>
            <h1>Orders</h1>
        </div>

        <div>
            <div>
                <table class="table">
                    <thead>
                        <tr><th>clients</th><th>shops</th><th>products</th></tr>
                    </thead>
                    <tbody>
                        <%
                        List<String> clients = (List<String>) request.getAttribute("clients");
                        List<String> shops = (List<String>) request.getAttribute("shops");
                        List<String> products = (List<String>) request.getAttribute("products");

                        if (clients != null && !clients.isEmpty()) {

                        for (int i = 0; i < clients.size(); i++) {
                             out.println("<tr><td>" + clients.get(i) + "</td>" + "<td>" + shops.get(i) + "</td>" + "<td>" + products.get(i) + "</td></tr>");
                         }

                        } else out.println("<p>There are no orders yet!</p>");
                     %>
                    </tbody>
                </table>
        <div>
            <button onclick="location.href='/service.html'">Back to main</button>
            <button onclick="location.href='/addOrder'">Add Order</button>
            <button onclick="location.href='/editOrders'">Edit Orders</button>
        </div>
    </body>
</html>