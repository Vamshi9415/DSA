import java.util.*;
class twosum{
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        HashMap<Integer,Integer> hashmap = new HashMap<>();

        for(int i =0; i<nums.length;i++){
            int check = target - nums[i];

            if (hashmap.containsKey(check)){
                result[0] = i ;
                result[1] = hashmap.get(check) ;
                return result;
            }
            else{
                hashmap.put(nums[i],i);
            }
        }

        return result;
    }
}