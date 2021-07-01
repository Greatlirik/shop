package controllers.client;

import com.google.gson.Gson;
import models.ClientModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ClientController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        Reader reader = new FileReader("ClientData.json");

        // Convert JSON File to Java Object
        ClientModel clientModel = gson.fromJson(reader, ClientModel.class);

        List<String> clientIDs = clientModel.clientIDs();
        List<String> names = clientModel.clientNames();
        List<Integer> ages = clientModel.clientAges();
        List<String> mails = clientModel.clientMails();

        req.setAttribute("clientIDs", clientIDs);
        req.setAttribute("clientNames", names);
        req.setAttribute("clientAges", ages);
        req.setAttribute("clientMails", mails);




        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/client/clients.jsp");
        requestDispatcher.forward(req, resp);
    }
}
