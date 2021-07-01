package entities;

import java.util.List;


public class Product {
    private Category category;
    private int price;
    private String name;
    private List<String> shopNames ;

    public List<String> getShopNames() {
        return shopNames;
    }

    public void setShopNames(List<String> shopNames) {
        this.shopNames = shopNames;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(String name, int price, List<String> shopNames, Category category ){
        this.category = category;
        this.name = name;
        this.shopNames = shopNames;
        this.price = price;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
