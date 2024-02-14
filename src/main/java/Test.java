public class Test {
    public static void main(String[] args) {
        /*var c = '\u001D';
        System.out.println(c);*/
        for (int i = 0; i < 5; i++) {
            System.out.println(getRandomDouble(0.2, 0.9));
        }
    }

    public static double getRandomDouble(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }
}
