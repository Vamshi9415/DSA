import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sort_character_frequency {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hashmap = new HashMap<>();

        for(int i =0;i<s.length();i++){
                hashmap.put(s.charAt(i),hashmap.getOrDefault(s.charAt(i),0)+1);
        }

        for(Map.Entry<Character, Integer> entry : hashmap.entrySet()){
            System.out.println("key " + entry.getKey() +" value "+entry.getValue());
        }

        System.out.println(hashmap.entrySet());

        List<HashMap.Entry<Character,Integer>> list = new ArrayList<>(hashmap.entrySet());
        // List<Map.Entry<Character, Integer>> list = new ArrayList<>(freq.entrySet());

        System.out.println(list);
// Compare (e=2, t=1) → 1 - 2 = -1 → negative → e stays before t.
        list.sort((a,b) -> b.getValue()-a.getValue() );

        System.out.println(list);

        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Character, Integer> entry : list){
            sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        String str = sb.toString();
        return str;
    }

    public static void main(String[] args) {
        sort_character_frequency sorter = new sort_character_frequency();
        String input = "tree";
        String result = sorter.frequencySort(input);
        System.out.println("Sorted by frequency: " + result);
    }
}
