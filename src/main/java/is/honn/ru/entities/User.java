package is.honn.ru.entities;

public class User {
    private int id;
    private String name;
    private String address;
    private String email;
    private int phone;

    public User() {}

    public User(String name, String address, String email, int phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%s \t%s \t%s \t%d ", this.name, this.address, this.email, this.phone);
    }
}
