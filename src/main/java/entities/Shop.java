package entities;


public class Shop {
    private int id;
    private String address;
    private String name;

    public Shop(String address, String name) {
        this.address = address;
        this.name = name;
    }

    public Shop(int id, String address, String name) {
        this.id = id;
        this.address = address;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
