import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void moveInvokeHorseMethodMove() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(Mockito.mock(Horse.class));
        }

        new Hippodrome(horses).move();

        for (Horse horse : horses) {
            Mockito.verify(horse).move();
        }
    }

    @Test
    void getWinner() {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("horse1", 2, 3));
        horses.add(new Horse("horse2", 2, 10));
        horses.add(new Horse("horse3", 2, 8));
        Hippodrome hippodrome = new Hippodrome(horses);

        Horse winner = hippodrome.getWinner();

        Assertions.assertEquals("horse2", winner.getName());
    }
}