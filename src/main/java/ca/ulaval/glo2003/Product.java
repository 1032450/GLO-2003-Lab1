package ca.ulaval.glo2003;

public class Product {
    private String title;
    private String description;
    private double price;
    private boolean sold;

    public Product(String title, String description, double price, boolean sold) {
        this.setTitle(title);
        this.setDescription(description);
        this.setPrice(price);
        this.setSold(sold);
    }

    public Product() {
        this.setTitle("");
        this.setDescription("");
        this.setPrice(0);
        this.setSold(false);
    }

    public String getAll() {
        return "title: " + this.getTitle() + ", description: " + this.getDescription() + ", price: " + this.getPrice() + ", sold: "
                + this.isSold();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }
}
