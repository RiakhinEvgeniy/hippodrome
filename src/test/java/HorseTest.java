import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"\t", "", " ", "\r", "\n",})
    void ifFirstParamInConstructorWhitespaceOrNotCharsThrowIllegalArgException(String name) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(name, 2, 2));
    }

    @ParameterizedTest
    @ValueSource(strings = {"\t", "", " ", "\r", "\n",})
    void ifFirstParamInConstructorWhitespaceOrNotCharsGetMessageFromIllegalArgException(String name) {
        String message = "";
        try {
            new Horse(name, 2, 2);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        Assertions.assertEquals("Name cannot be blank.", message);
    }

    @Test
    void ifSecondParamInConstructorNegativeNumberThrowIllegalArgException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("horse", -1, 2));
    }

    @Test
    void ifSecondParamInConstructorNegativeNumberGetMessageFromException() {
        String message = "";
        try {
            new Horse("horse", -2, 2);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        Assertions.assertEquals("Speed cannot be negative.", message);
    }
}