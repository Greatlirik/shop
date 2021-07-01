package models;

import entities.Category;
import entities.Product;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductModel {

    private List<Product> productModel;


    private ProductModel() {
        productModel = new ArrayList<>();
    }

    public void add(Product product) {
        productModel.add(product);
    }

    public List<String> productNames() {
        return productModel.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
    }

    public List<Integer> productPrices() {
        return productModel.stream()
                .map(Product::getPrice)
                .collect(Collectors.toList());
    }
    public List<List<String>> productShops() {
        return productModel.stream()
                .map(Product::getShopNames)
                .collect(Collectors.toList());
    }

    public List<String> productCategories() {
        return productModel.stream()
                .map(s -> s.getCategory())
                .map(Category::toString)
                .collect(Collectors.toList());

    }


}
