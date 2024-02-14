import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HorseTest {

   /* @BeforeEach
    void setUp() {
    }*/

    @Test
    void constructorNameThrowIAE() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(null, 2, 2));
    }

    @Test
    void constructorNameGetMessageFromIAE() {
        String message = "";
        try {
            new Horse(null, 2, 2);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        Assertions.assertEquals("Name cannot be null.", message);
    }

    @ParameterizedTest
    @ValueSource(strings = {"\t", "", " ", "\r", "\n", "\f"})
    void constructorNameWhitespaceOrNotCharsThrowIAE(String name) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(name, 2, 2));
    }

    @ParameterizedTest
    @ValueSource(strings = {"\t", "", " ", "\r", "\n",})
    void constructorNameWhitespaceOrNotCharsGetMessageFromIAE(String name) {
        String message = "";
        try {
            new Horse(name, 2, 2);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        Assertions.assertEquals("Name cannot be blank.", message);
    }

    @Test
    void constructorSpeedNegativeNumberThrowIAE() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("horse", -1, 2));
    }

    @Test
    void constructorSpeedNegativeNumberGetMessageFromIAE() {
        String message = "";
        try {
            new Horse("horse", -2, 2);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        Assertions.assertEquals("Speed cannot be negative.", message);
    }

    @Test
    void constructorDistanceNegativeNumberThrowIAE() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("horse", 1, -2));
    }

    @Test
    void constructorDistanceNegativeNumberGetMessageFromIAE() {
        String message = "";
        try {
            new Horse("horse", 2, -2);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        Assertions.assertEquals("Distance cannot be negative.", message);
    }

    @Test
    void getNameTest() {
        Horse horse = new Horse("Winner", 2, 2);
        Assertions.assertEquals("Winner", horse.getName());
    }

    @Test
    void getSpeedTest() {
        Horse horse = new Horse("Winner", 2, 2);
        Assertions.assertEquals(2, horse.getSpeed());
    }

    @Test
    void getDistanceTest() {
        Horse horse = new Horse("Winner", 2, 3);
        Assertions.assertEquals(3, horse.getDistance());
    }

    @Test
    void moveTestInvokeStaticMethod() {
        try (MockedStatic<Horse> ms = Mockito.mockStatic(Horse.class)) {
            new Horse("horse", Mockito.anyDouble(), Mockito.anyDouble()).move();
            ms.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }

    @Test
    void moveTestMockMethodGetRandom() {
        try (MockedStatic<Horse> ms = Mockito.mockStatic(Horse.class)) {
            ms.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(10.0);
        }
    }
}