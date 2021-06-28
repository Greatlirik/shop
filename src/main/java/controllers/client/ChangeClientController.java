package controllers.client;

import com.google.gson.Gson;
import entities.Client;
import models.ClientModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class ChangeClientController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        Reader reader = new FileReader("C:\\Users\\Kirill\\Desktop\\workspace\\shop\\ClientData.json");

        // Convert JSON File to Java Object
        ClientModel clientModel = gson.fromJson(reader, ClientModel.class);

        List<String> clientIDs = clientModel.clientIDs();
        List<String> names = clientModel.clientNames();
        List<Integer> ages = clientModel.clientAges();
        List<String> mails = clientModel.clientMails();

        req.setAttribute("clientNames", names);
        req.setAttribute("clientAges", ages);
        req.setAttribute("clientMails", mails);
        req.setAttribute("clientIDs", clientIDs);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/client/changeClients.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        Reader reader = new FileReader("C:\\Users\\Kirill\\Desktop\\workspace\\shop\\ClientData.json");

        ClientModel clientModelFromJson = gson.fromJson(reader, ClientModel.class);


        String name = req.getParameter("name");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String mail = req.getParameter("mail");

        Client client = new Client(name, age, mail);



        switch (req.getParameter("operation")) {
            case "delete":

                break;
            case "edit":
                String id = req.getParameter("id");
                Client clientChange = clientModelFromJson.getClient(id);
                clientModelFromJson.delete(clientChange);
                clientModelFromJson.add(client);


        }

        try (FileWriter writer = new FileWriter("C:\\Users\\Kirill\\Desktop\\workspace\\shop\\ClientData.json")) {
            gson.toJson(clientModelFromJson, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }



        doGet(req, resp);
    }

}
