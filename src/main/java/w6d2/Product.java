package w6d2;

public class Product {
    private String name;
    private ProductCat cat;
    private int price;

    public Product(String name, ProductCat cat, int price) {
        this.name = name;
        this.cat = cat;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public ProductCat getCat() {
        return cat;
    }

    public int getPrice() {
        return price;
    }
}
