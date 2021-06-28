package models;

import entities.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClientModel {
    private final List<Client> model;


    private ClientModel() {
        model = new ArrayList<>();
    }

    public void add(Client client) {
        model.add(client);
    }

    public void delete(List <Client> clients) {
        model.removeAll(clients);
    }

    public void delete(Client client) {
        model.remove(client);
    }

    public List<String> clientIDs() {
        return model.stream()
                .map(Client::getId)
                .collect(Collectors.toList());
    }

    public List<String> clientNames() {
        return model.stream()
                .map(Client::getName)
                .collect(Collectors.toList());
    }

    public List<Integer> clientAges() {
        return model.stream()
                .map(Client::getAge)
                .collect(Collectors.toList());
    }
    public List<String> clientMails() {
        return model.stream()
                .map(Client::getMail)
                .collect(Collectors.toList());
    }

    public List<Client> getClients(List<String> ids){
       return model.stream().filter(client -> ids.contains(client.getId())).collect(Collectors.toList());

    }

    public Client getClient(String id){
        return model.stream().filter(client -> id.equals(client.getId())).findFirst().orElse(null);


    }


}
