import java.util.*;

public class set {
    public static void removeduplicates(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int[] newarr = set.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(newarr));

        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        Set<Integer> newset = new LinkedHashSet<>(list);
        List<Integer> list2 = new ArrayList<>(newset);
        System.out.println(list2);
    }

    public static List<Integer> intersection(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : arr2) {
            if (set.contains(num)) {
                list.add(num);
            }
        }
        return list;
    }

    public static void check_two_Arrays_equal_or_not(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            set2.add(num);
        }

        System.out.println(set.equals(set2));
    }

    public static Set<Integer> union(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr1)
            set.add(num);
        for (int num : arr2)
            set.add(num);
        return set;
    }

    public static Set<Integer> difference(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : arr1)
            set1.add(num);
        Set<Integer> set2 = new HashSet<>();
        for (int num : arr2)
            set2.add(num);
        Set<Integer> diff = new HashSet<>(set1);
        diff.removeAll(set2);
        return diff;
    }

    public static Set<Integer> symmetricDifference(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : arr1)
            set1.add(num);
        Set<Integer> set2 = new HashSet<>();
        for (int num : arr2)
            set2.add(num);
        Set<Integer> symDiff = new HashSet<>(set1);
        symDiff.addAll(set2);
        Set<Integer> inter = new HashSet<>(set1);
        inter.retainAll(set2);
        symDiff.removeAll(inter);
        return symDiff;
    }

    public static boolean isSubset(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : arr1)
            set1.add(num);
        Set<Integer> set2 = new HashSet<>();
        for (int num : arr2)
            set2.add(num);
        return set2.containsAll(set1);
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        set.add(3);
        set.remove(3);

        boolean isthere = set.contains(0);
        boolean ismepty = set.isEmpty();

        Set<String> set2 = new LinkedHashSet<>(Arrays.asList("a", "b", "c"));

        Iterator<String> it = set2.iterator();

        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Test the methods
        int[] arr1 = { 1, 2, 3, 4 };
        int[] arr2 = { 3, 4, 5, 6 };

        System.out.println("Union: " + union(arr1, arr2));
        System.out.println("Intersection: " + intersection(arr1, arr2));
        System.out.println("Difference (arr1 - arr2): " + difference(arr1, arr2));
        System.out.println("Symmetric Difference: " + symmetricDifference(arr1, arr2));
        System.out.println("Is arr1 subset of arr2? " + isSubset(arr1, arr2));

        // Call existing methods
        removeduplicates(new int[] { 1, 2, 2, 3, 4, 4 });
        System.out.println("Intersection: " + intersection(new int[] { 1, 2, 3 }, new int[] { 2, 3, 4 }));
        check_two_Arrays_equal_or_not(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 });
    }
}