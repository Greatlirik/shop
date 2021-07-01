package controllers.client;

import com.google.gson.Gson;
import entities.Client;
import models.ClientModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

public class EditClientsController extends HttpServlet {

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


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/client/editClients.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Gson gson = new Gson();
        Reader reader = new FileReader("ClientData.json");
        ClientModel clientModel = gson.fromJson(reader, ClientModel.class);
        List <String> ids = Arrays.asList(req.getParameterValues("id"));
        List <Client> clients = clientModel.getClients(ids);


        switch (req.getParameter("operation")) {
            case "edit":

                break;
            case "delete":
                clientModel.delete(clients);
                break;
        }

        try (FileWriter writer = new FileWriter("ClientData.json")) {
            gson.toJson(clientModel, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }


        resp.setStatus(201);
        doGet(req, resp);
    }
}
