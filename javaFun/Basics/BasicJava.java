import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BasicJava {
    public void printNums(){
        for(int i=1; i<256; i++){
            System.out.println(i);
        }
    }

    public void printOddNums(){
        for(int i=1; i<256; i++){
            if(i % 2 != 0){
            System.out.println(i);
            }  
        } 
    }

    public void printSum(){
        int sum = 0;
        for(int i=0; i<256; i++){
            sum += i;
            System.out.println("New number: " + i + " Sum: " + sum);
        }
    }

    public void printArrVal(int[] x){
        for(int i=0; i < x.length; i++){
            System.out.println(x[i]);
        }
    }

    public void findMax(int[] y){
        int max = y[0];
        for(int i=0; i < y.length; i++){
            if(max < y[i]){
                max = y[i];
            }
        }
        System.out.println(max);
    }

    public void average(int[] arr){
        int total = 0;
        for(int i=0; i<arr.length; i++){
            total = total + arr[i];
        }
        int average = total / arr.length;
        System.out.println("The average is: " + average);
    }

    public void oddsNumArray(){
        ArrayList<Integer> y = new ArrayList<Integer>();
        int i = 1;
        while(i< 256){
            if(i % 2 != 0){
                y.add(i);
            }
            i++;
        }
        for(int j =0; j< y.size(); j ++){
            System.out.println(y.get(j));
        }
    }
    public int greaterThen(int n, int[] ar){
        int sum =0;
        for(int l=0; l< ar.length; l++){
            if(ar[l] > n){
                sum++;
            }
        }
        return sum;
    }

    public void maxMinAverage(int[] x){
        Arrays.sort(x);
        int max = x[x.length-1];
        int min = x[0];
        int ave = 0;
        int[] res = new int[3];
        res[0] = max;
        res[1] = min;

        for(int i=0; i<x.length; i++){
            ave = ave + x[i];
        }
        int average = ave / x.length;
        res[2] = average;
       for( int n=0; n< res.length; n++){
           System.out.println(res[n]);
       }
    }

    public void shiftVal(int[] numbers){
        int i=0;
        int j = i+1;
        while( j < numbers.length){
            numbers[i] = numbers[j];
            i++;
            j++;
        }
        numbers[numbers.length-1] = 0;

        for( int n=0; n< numbers.length; n++){
            System.out.println(numbers[n]);
        }

    }
}
