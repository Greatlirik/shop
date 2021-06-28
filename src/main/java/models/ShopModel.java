package models;

import entities.Client;
import entities.Product;
import entities.Shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ShopModel {
    private static ShopModel instance = new ShopModel();
    private HashMap<Integer, Shop> model;

    public static ShopModel getInstance() {
        return instance;
    }


    private ShopModel() {
        model = new HashMap<>();
    }


//    public void add(Integer id,Shop shop) {
//
//        model.put(id, shop);
//    }

//    public void changeName(Integer id, String name) {
//        model.stream().findFirst(
//    }

//    public void delete(Integer id) {
//        model.remove(id);
//    }

//
//    public List<String> shopName() {
//        return new ArrayList<String>(model.entrySet());
//    }
}

