import java.util.*;
public class unionoftwoarrays {
    static List<Integer> union(int[] arr1,int[] arr2){
        List<Integer> unionlist = new ArrayList<>();

        int i=0;
        int j =0;

        int arr1len = arr1.length;
        int arr2len = arr2.length;

        while(i< arr1len && j< arr2len){
            if(arr1[i]<arr2[j] && (unionlist.isEmpty() || arr1[i] != unionlist.get(unionlist.size()-1))){
                unionlist.add(arr1[i]);
                i++;
            }
            else if(arr1[i] == arr2[j] && (unionlist.isEmpty() || arr1[i] != unionlist.get(unionlist.size()-1))){
                unionlist.add(arr1[i]);
                i++;
                j++;
            }
            else if(arr1[i]>arr2[j] && (unionlist.isEmpty() || arr2[i] != unionlist.get(unionlist.size()-1))){
                unionlist.add(arr2[j]);
                j++;
            }
        }
        return unionlist;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};

        List<Integer> result = union(arr1, arr2);

        System.out.println("Union of two arrays: " + result);
    }
}
