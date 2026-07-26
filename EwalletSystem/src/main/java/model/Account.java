package model;

public class Account {

    private int id;
    private String username;
    private String password;
    private Double balance;
    private String phoneNumber;
    private float age;

    public Account() {
    }

    // Used for login
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Used for signup
    public Account(String username, String password, String phoneNumber, float age) {
        this.username = username;
        this.password = password;
        this.balance = 0.0;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    // Used when loading an account from the database
    public Account(int id, String username, Double balance, String phoneNumber, float age) {
        this.id = id;
        this.username = username;
        this.balance = balance;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    // ================= Getters & Setters =================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }
}