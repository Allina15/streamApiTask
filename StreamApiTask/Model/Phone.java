package StreamApiTask.Model;

import java.util.List;

public class Phone {
    private int id;
    private static int idd = 1;
    private String name;
    private String brand;
    private List<Contact>contact;

    public Phone(String name, String brand, List<Contact> contact) {
        this.id = idd++;
        this.name = name;
        this.brand = brand;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", contact=" + contact +
                '}';
    }
}
