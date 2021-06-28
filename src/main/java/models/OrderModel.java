package models;


import entities.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderModel {
    private final List<Order> model;

    private OrderModel() {
        model = new ArrayList<>();
    }

    public void add(Order order) {
        model.add(order);
    }

    public void delete(List <Order> orders) {
        model.removeAll(orders);
    }

    public List<String> clients() {
        return model.stream()
                .map(Order::getClient)
                .collect(Collectors.toList());
    }
    public List<String> shops() {
        return model.stream()
                .map(Order::getShop)
                .collect(Collectors.toList());
    }
    public List<String> products() {
        return model.stream()
                .map(Order::getProduct)
                .collect(Collectors.toList());
    }

}
