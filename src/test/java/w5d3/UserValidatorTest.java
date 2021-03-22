package w5d3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    @Test
    void validate() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new UserValidator().validate(null));
        assertEquals("userlist error", ex.getMessage());
        ex = assertThrows(IllegalArgumentException.class, () -> new UserValidator().validate(List.of(new User(null,55))));
        assertEquals("user error", ex.getMessage());
        ex = assertThrows(IllegalArgumentException.class, () -> new UserValidator().validate(List.of(new User("jani",-5))));
        assertEquals("age error", ex.getMessage());

        assertEquals(true, new UserValidator().validate(List.of(new User("jani",55))));
    }
}