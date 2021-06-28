
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Clients</title>
        <link rel="stylesheet" href="table.css">
    </head>

    <body>
        <div>
            <h1>Clients</h1>
        </div>

        <div>
            <div>
                <table class="table">
                    <form action="/editClients" method="post">
                        <input type="submit" name="operation" value="delete"/>
                        <thead>
                            <tr><th>names</th><th>mails</th><th>ages</th></tr>
                        </thead>
                        <tbody>
                            <%
                            List<String> ids = (List<String>) request.getAttribute("clientIDs");
                            List<String> names = (List<String>) request.getAttribute("clientNames");
                            List<String> mails = (List<String>) request.getAttribute("clientMails");
                            List<Integer> ages = (List<Integer>) request.getAttribute("clientAges");

                            if (names != null && !names.isEmpty()) {

                            for (int i = 0; i < names.size(); i++) {
                                 out.println("<tr><td>" + names.get(i) +
                                  "</td>" + "<td>" + mails.get(i) + "</td>" + "<td>" +
                                 ages.get(i) + "</td></td><td><input type=checkbox name=id value=" + ids.get(i) + "></td></tr>");
                             }

                            } else out.println("<p>There are no clients yet!</p>");
                         %>
                        </tbody>
                    </form>
                </table>

        <div>
            <button onclick="location.href='/clients'">Back to clients</button>
            <button onclick="location.href='/changeClients'">Change clients</button>
        </div>
    </body>
</html>