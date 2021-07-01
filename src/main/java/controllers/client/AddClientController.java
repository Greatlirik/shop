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

public class AddClientController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/client/addClient.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get attributes from jsp
        String name = req.getParameter("name");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String mail = req.getParameter("mail");


        Client client = new Client(name, age, mail);


        Gson gson = new Gson();
        Reader reader = new FileReader("ClientData.json");

        // Convert JSON File to Java Object
        ClientModel clientModelFromJson = gson.fromJson(reader, ClientModel.class);
        clientModelFromJson.add(client);

        try (FileWriter writer = new FileWriter("ClientData.json")) {
            gson.toJson(clientModelFromJson, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        resp.setStatus(201);
        doGet(req, resp);
    }

}
