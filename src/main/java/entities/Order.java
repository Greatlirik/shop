package entities;


import java.util.UUID;

public class Order {
    private String id;
    private String client;
    private String shop;
    private String product;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Order(String client, String shop, String product){
        this.id = UUID.randomUUID().toString();
        this.client = client;
        this.shop = shop;
        this.product = product;
    }
}
