import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HorseTest {

   /* @BeforeEach
    void setUp() {
    }*/

    @Test
    void ifFirstParamInConstructorNullThrowIllegalArgException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(null, 2, 2));
    }

    @Test
    void ifFirstParamInConstructorNullGetMessageFromException() {
        String message = "";
        try {
            new Horse(null, 2, 2);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        Assertions.assertEquals("Name cannot be null.", message);
    }

    /*@Test
    void getName() {
    }

    @Test
    void getSpeed() {
    }

    @Test
    void getDistance() {
    }

    @Test
    void move() {
    }*/
}