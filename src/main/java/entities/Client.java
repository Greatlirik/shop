package entities;

import java.util.UUID;

public class Client {
    private String id;
    private String name;
    private Integer age;
    private String mail;

    public Client(String name, Integer age, String mail){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
