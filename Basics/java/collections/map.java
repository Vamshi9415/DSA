import java.util.HashMap;
import java.util.Map;

public class map {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Z", 10);

        int v = map.getOrDefault("X", 0);
        System.out.println(v);

        // Iterating Map

        for(Map.Entry<String, Integer> e : map.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }

    }
}
