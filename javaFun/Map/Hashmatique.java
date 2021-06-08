import java.util.HashMap;

public class Hashmatique {
    public void trackList(){
        HashMap<String, String> userMap = new HashMap<String, String>();

        userMap.put("song1", "Michael Jackson");
        userMap.put("song2", "Basta");
        userMap.put("song3", "Rihana");
        userMap.put("song4", "Miyagi");

        System.out.println(userMap.get("song1"));
        
        userMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }
    
}
