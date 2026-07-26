package model;

public class Item {

    private int id;
    private String name;
    private double price;
    private int totalNumber;
    
    private boolean hasDetails;

    // One-to-one relationship
    private ItemDetails itemDetails;

    public Item() {
    }

    // Constructor without id
    public Item(String name, double price, int totalNumber) {
        this.name = name;
        this.price = price;
        this.totalNumber = totalNumber;
    }

    // Constructor with id
    public Item(int id, String name, double price, int totalNumber) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalNumber = totalNumber;
    }

    // Constructor with ItemDetails
    public Item(int id, String name, double price, int totalNumber, ItemDetails itemDetails) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalNumber = totalNumber;
        this.itemDetails = itemDetails;
    }

    public Item(String name, double price, int totalNumber, ItemDetails itemDetails) {
        this.name = name;
        this.price = price;
        this.totalNumber = totalNumber;
        this.itemDetails = itemDetails;
    }

    // Getters & Setters
    
    public boolean isHasDetails() {
        return hasDetails;
    }

    public void setHasDetails(boolean hasDetails) {
        this.hasDetails = hasDetails;
    }
    

    public boolean getHasDetails() {
        return hasDetails;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public ItemDetails getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(ItemDetails itemDetails) {
        this.itemDetails = itemDetails;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", totalNumber=" + totalNumber +
                ", itemDetails=" + itemDetails +
                '}';
    }
}