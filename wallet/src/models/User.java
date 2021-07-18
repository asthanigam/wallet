package models;

import java.util.UUID;

public class User {
    private String name;
    private String id;
    private String phone;
    public User(String name, String id, String phone)
    {
        this.setName(name);
        this.setId(id);
        this.setPhone(phone);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
