import static java.lang.Math.sqrt;

public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        return sqrt((legA * legA) + (legB * legB));
    }
}
