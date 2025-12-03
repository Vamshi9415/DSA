import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class countfrequencies {
    
    public static ArrayList<ArrayList<Integer>> countfreq(int[] nums){
        Map<Integer,Integer> freq = new HashMap<>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int num : nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: freq.entrySet()){
            ArrayList<Integer> pair = new ArrayList<>();

            pair.add(entry.getKey());
            pair.add(entry.getValue());
            list.add(pair);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 3};
        System.out.println(countfreq(nums));
}
}
