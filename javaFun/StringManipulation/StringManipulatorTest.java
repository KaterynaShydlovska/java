public class StringManipulatorTest {
    public static void main(String[] args) {
        StringManipulator manipulator = new StringManipulator();
        String str = manipulator.trimAndConcat("    Hello     ","     World    ");
        System.out.println(str); // HelloWorld 

        char letter = 'o';
        Integer a = manipulator.getIndexOrNull("Coding", letter);
        Integer b = manipulator.getIndexOrNull("Hello World", letter);
        Integer c = manipulator.getIndexOrNull("Hi", letter);
        System.out.println(a); // 1
        System.out.println(b); // 4
        System.out.println(c); // null

        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer str1 = manipulator.getIndexOrNull(word, subString);
        Integer str2 = manipulator.getIndexOrNull(word, notSubString);
        System.out.println(str1); // 2
        System.out.println(str2); // null

        String wordToConcat = manipulator.concatSubstring("Hello", 1, 2, "world");
        System.out.println(wordToConcat); // eworld

    }
}
