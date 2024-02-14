import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {

    @Test
    void constructorNullThrowsIAE() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }

    @Test
    void constructorNullGetMessageFromIAE() {
        String message = "";
        try {
            new Hippodrome(null);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        Assertions.assertEquals("Horses cannot be null.", message);
    }

    @Test
    void constructorListIsEmptyThrowsIAE() {
        List<Horse> horses = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(horses));
    }

    @Test
    void constructorListIsEmptyGetMessageFromIAE() {
        String message = "";
        List<Horse> horses = new ArrayList<>();
        try {
            new Hippodrome(horses);
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        Assertions.assertEquals("Horses cannot be empty.", message);
    }

    @Test
    void getHorsesTestSameObjectsAndSequence() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse("#" + i, i, i));
        }

        Hippodrome hippodrome = new Hippodrome(horses);
        Assertions.assertEquals(horses, hippodrome.getHorses());
    }
}