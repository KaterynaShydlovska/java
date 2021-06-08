import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.*;

public class PuzzleJava {
    public ArrayList<Integer> countSum(int[] arr){
        ArrayList<Integer> res = new ArrayList<Integer>();
        int sum=0;
        for(int i=0; i< arr.length; i++){
            sum+= arr[i];
            if( arr[i] > 10){
                res.add(arr[i]);
            }
        }
        System.out.println(sum);
        for(int j =0; j< res.size(); j++){
            System.out.println(res.get(j));
        }
        return res;
    }

    public ArrayList<String> names(ArrayList<String> array){
        Collections.shuffle(array);
        ArrayList<String> newArr = new ArrayList<String>();

        for(int k=0; k< array.size(); k++){
            System.out.println(array.get(k));
        }
        
        int nameLength = 0;
        for(int n = 0; n < array.size(); n++){
            if(array.get(n).length() >=5){
                newArr.add(array.get(n));
                System.out.println(array.get(n));
            }
        }
        return newArr;
    }

    public void alphabet(List<Character> arr){
        Collections.shuffle(arr);
        System.out.println(arr.get(0));
        System.out.println(arr.get(arr.size()-1));
        if(arr.get(0) == 'A' || arr.get(0) == 'E' || arr.get(0) == 'O' || arr.get(0) == 'I' || arr.get(0) == 'U' ){
            System.out.println("message !!!!!!");
        }
    }

    public ArrayList<Integer> randomNumbers(){
        ArrayList<Integer> res = new ArrayList<Integer>();
        Random r = new Random();
        int i=1;
        int rNum;
        
        while(i<= 10){
            rNum = r.nextInt(100-55) + 55;
            res.add(rNum);
            System.out.println(rNum);
            i++;
        }
        return res;

    }

    public ArrayList<Integer> randomN(){
        ArrayList<Integer> res = new ArrayList<Integer>();
        Random r = new Random();
        int i=1;
        int rNum;
        
        while(i<= 10){
            rNum = r.nextInt(100-55) + 55;
            res.add(rNum);
            i++;
        }
        Collections.sort(res);
        System.out.println("min: " + res.get(0));
        for(int k =0; k< res.size(); k++){
            System.out.println(res.get(k));
        }
        System.out.println("max: " + res.get(res.size()-1));
        return res;

    }

    public String randomString(int n){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {

            int index = (int)(str.length() * Math.random());
            sb.append(str.charAt(index));
        }
  
        return sb.toString();
    }

    public ArrayList<String> randomStringArr(int n){
        ArrayList<String> arrStr = new ArrayList<String>();

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       

        int count = 0;
        while(count <= 10){
            StringBuilder sb = new StringBuilder(n);
            for (int i = 0; i < n; i++) {
                int index = (int)(str.length() * Math.random());
                sb.append(str.charAt(index));
            }
            String res = sb.toString();
            System.out.println(res);
            arrStr. add(res);
            count++;
        }
        return arrStr;
    }


}
