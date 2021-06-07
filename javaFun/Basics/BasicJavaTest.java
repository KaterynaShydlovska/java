public class BasicJavaTest {
    public static void main(String[] args) {
        BasicJava basics = new BasicJava();
        basics.printNums();

        basics.printOddNums();
        
        basics.printSum();

        int [] x = {1,3,5,7,9,13};
        basics.printArrVal(x);

        int [] y = {-5, 6, -2};
        basics.findMax(y);

        int [] arr = {2, 10, 5};
        basics.average(arr);

        basics.oddsNumArray();

        int[] ar = {1, 3, 5, 7};
        int n = 3;
        System.out.println(basics.greaterThen(n, ar));

        int[] array= {1, 5, 10, -2};
        basics.maxMinAverage(array);

        int[] values = {1, 5, 10, 7, -2};
        basics.shiftVal(values);
    }
}
