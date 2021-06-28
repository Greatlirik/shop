<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Change clients</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
            <h1>Change client</h1>
        </div>

        <div class="w3-container w3-padding">
            <table class="table">
                <form  action="/changeClients" method="post">
                <thead>
                    <tr><th>names</th><th>mails</th><th>ages</th></tr>
                </thead>
                <tbody>

                    <%
                    List<String> ids = (List<String>) request.getAttribute("clientIDs");
                    List<String> names = (List<String>) request.getAttribute("clientNames");
                    List<String> mails = (List<String>) request.getAttribute("clientMails");
                    List<Integer> ages = (List<Integer>) request.getAttribute("clientAges");

                    if (names != null && !names.isEmpty()){
                    for (int i = 0; i < names.size(); i++) {
                         out.println("<tr><td>" + names.get(i) + "</td>" + "<td>" + mails.get(i) + "</td>" + "<td>" + ages.get(i) + "</td></tr>");
                         out.println("<tr><td><input type=text name=name></td><td><input type=email name=mail></td><td><input type=number name=age></td><td><input type=submit name=operation  value=edit></td></tr>");
                         out.println("<input type=hidden name=id value=" + ids.get(i) + ">");}
                    } else out.println("<p>There are no clients yet!</p>");
                 %>
                </tbody>
                </form>
            </table>



        </div>

        <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/service.html'">Back to main</button>
            <button class="w3-btn w3-round-large" onclick="location.href='/clients'">Back to clients</button>
        </div>
        <script>
            if ( window.history.replaceState ) {
              window.history.replaceState( null, null, window.location.href );
            }
         </script>
    </body>
</html>