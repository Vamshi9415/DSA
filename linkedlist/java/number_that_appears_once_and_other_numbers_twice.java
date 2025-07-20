import java.util.HashMap;
import java.util.Map;
class number_that_appears_once_and_other_numbers_twice{
    public static int findfun(int[] arr){
            int n = arr.length;
            HashMap<Integer, Integer> hm = new HashMap<>();

            for(int i=0;i<n;i++){
                int value = hm.getOrDefault(arr[i],0);
                hm.put(arr[i],value+1);
            }

            for(Map.Entry<Integer,Integer> e: hm.entrySet()){
                if(e.getValue() == 1){
                    return e.getKey();
                }
            }
            return -1;

    }

    public static void main(String[] args){
        int[] arr = {2,3,5,4,5,3,4};
        System.out.println("only once "+findfun(arr));
    }
}