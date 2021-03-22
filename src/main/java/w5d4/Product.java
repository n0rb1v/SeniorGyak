package w5d4;

public class Product {
    private long price;
    private String currency;

    public Product(long price, String currency) {
        this.price = price;
        if (currency.equals("HUF") | currency.equals("USD")) {
            this.currency = currency;
        } else {
            throw new IllegalStateException("unknow");
        }
    }

    public double convertPrice(String s) {
        if (s.equals("USD") & currency.equals("HUF")) {
            return price / 300.0;
        }
        if (s.equals("HUF") & currency.equals("USD")) {
            return price * 300.0;
        }
        return price;
    }
}
