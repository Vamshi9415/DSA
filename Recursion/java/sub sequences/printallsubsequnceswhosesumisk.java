import java.util.*;
public class printallsubsequnceswhosesumisk {

    static void f(int[] arr, int index, List<Integer> current,int sum, int k){
        int n = arr.length;

        if(index >=n){
            if(sum == k){
                System.out.println(current);
            }
            return;
        }

        // include the current element
        current.add(arr[index]);

        f(arr,index+1,current, sum+arr[index], k);

        //exclude the current element

        current.remove(current.size()-1);

        f(arr,index+1,current, sum, k);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int k = 2;

        System.out.println("Subsequences with sum " + k + ":");
        f(arr, 0, new ArrayList<>(), 0, k);
    }
}
