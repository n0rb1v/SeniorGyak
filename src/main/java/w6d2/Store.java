package w6d2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    List<Product> products;

    public Store(List<Product> products) {
        this.products = products;
    }

    public Map<ProductCat, Integer> getProductsByCategory() {
        Map<ProductCat, Integer> result = new HashMap<>();
        for (Product item : products) {
            if (!result.containsKey(item.getCat())) {
                result.put(item.getCat(), 0);
            }
            result.put(item.getCat(), result.get(item.getCat()) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Product> pr = new ArrayList<>(List.of(
                new Product("tej",ProductCat.FROZEN,250),
                new Product("sajt",ProductCat.FROZEN,350),
                new Product("kenyer",ProductCat.DAIRY,150)
                ));

        Store s = new Store(pr);
        System.out.println(s.getProductsByCategory());
    }
}
