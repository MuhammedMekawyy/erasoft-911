package model;

public class ItemDetails {

    private int id;
    private Item item;                 // One-to-one relationship
    private String description;
    private int warrantyMonths;

    // Default constructor
    public ItemDetails() {
    }

    // Constructor without id (for insert)
    public ItemDetails(Item item, String description, int warrantyMonths) {
        this.item = item;
        this.description = description;
        this.warrantyMonths = warrantyMonths;
    }

    // Constructor with id (for retrieval)
    public ItemDetails(int id, Item item, String description, int warrantyMonths) {
        this.id = id;
        this.item = item;
        this.description = description;
        this.warrantyMonths = warrantyMonths;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String toString() {
        return "ItemDetails{" +
                "id=" + id +
                ", item=" + item +
                ", description='" + description + '\'' +
                ", warrantyMonths=" + warrantyMonths +
                '}';
    }
}