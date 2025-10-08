import java.util.*;

public class subsets {
    public static ArrayList<ArrayList<Integer>> findSubsets(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        generateSubsets(arr, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateSubsets(int[] arr, int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        // Base case: when index reaches the end
        if (index == arr.length) {
            result.add(new ArrayList<>(current)); // Add a copy of the current subset
            return;
        }

        // Include current element
        current.add(arr[index]);
        generateSubsets(arr, index + 1, current, result);

        // Exclude current element
        current.remove(current.size() - 1);
        generateSubsets(arr, index + 1, current, result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        ArrayList<ArrayList<Integer>> subsets = findSubsets(arr);

        // Print all subsets
        for (ArrayList<Integer> subset : subsets) {
            System.out.println(subset);
        }
        sc.close();
    }
}
