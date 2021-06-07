public class PythagoreanTest {
    public static void main(String[] args) {
        Pythagorean pythagorean = new Pythagorean();
        System.out.println(pythagorean.calculateHypotenuse(Integer.valueOf(args[0]), Integer.valueOf(args[1])));

    }
}