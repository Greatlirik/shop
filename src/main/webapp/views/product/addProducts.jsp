<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add new products</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
            <h1>Add new products</h1>
        </div>

        <div class="w3-container w3-padding">
            <%
                if (request.getAttribute("clientsName") != null) {
                    out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                            "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                            "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                            "   <h5>User '" + request.getAttribute("clientName") + "' added!</h5>\n" +
                            "</div>");
                }
            %>
            <div class="w3-card-4">
                <div class="w3-container w3-center w3-green">
                    <h2>Add product</h2>
                </div>
                <form  method="post" action="addProducts" class="w3-selection w3-light-grey w3-padding">
                    <label>Name:
                        <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                    </label>
                    <label>Price:
                        <input type="number" name="price" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                    </label>
                    <label>Shops:
                        <input type="text" name="shops" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                    </label>
                    <label>Category:
                     <p><select size="1"  id=1 name="categories" required>
                        <option disabled>Select a category</option>
                        <option value="other">other</option>
                        <option value="toys">toys</option>
                        <option value="clothes">clothes</option>
                        <option value="electrical_appliances">electrical appliances</option>
                        <option value="household_chemicals">household chemicals</option>
                       </select></p>
                     </label>
                     <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom" >Submit</button>
                </form>
            </div>
        </div>
         <script>
            if ( window.history.replaceState ) {
              window.history.replaceState( null, null, window.location.href );
            }
         </script>
        <button onclick="location.href='/service.html'">Back to main</button>
    </body>
</html>