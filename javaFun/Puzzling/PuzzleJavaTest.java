import java.util.ArrayList; 
import java.util.*;

public class PuzzleJavaTest {
    public static void main(String[] args) {
        PuzzleJava puzzle = new PuzzleJava();
        int[] arr = {3,5,1,2,7,9,8,13,25,32};
        // puzzle.countSum(arr);

        ArrayList<String> array = new ArrayList<String>();
        array.add("Nancy");
        array.add("Jinichi");
        array.add("Fujibayashi");
        array.add("Momochi");
        array.add("Ishikawa");
        // puzzle.names(array);

        List<Character> list = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
        // puzzle.alphabet(list);

        // puzzle.randomNumbers();
        
        // puzzle.randomN();

        
        int n = 5;
        // System.out.println(puzzle.randomString(n));

        int length = 5;
        puzzle.randomStringArr(length);

    }

}
