package w5d4;

import org.junit.jupiter.api.Test;
import w5d3.User;
import w5d3.UserValidator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void convertPrice() {
        Product p1 = new Product(1,"USD");
        Product p2 = new Product(150,"HUF");
        assertEquals(300, p1.convertPrice("HUF"));
        assertEquals(0.5, p2.convertPrice("USD"));

    }
}