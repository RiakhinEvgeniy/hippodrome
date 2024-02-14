import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Horse> horses = fillList();
        for(Horse h : horses) {
            System.out.println(h.getName());
        }
    }

    public static double getRandomDouble(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }

    static List<Horse> fillList() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            horses.add(new Horse("#" + i, 2, 2));
        }
        return horses;
    }
}
