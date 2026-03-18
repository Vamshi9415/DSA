
import java.util.*;

public class list {
    public static int secondHighestFromList(List<Integer> nums) {
        int first = Integer.MIN_VALUE;
        int sec = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > first) {
                sec = first;
                first = num;
            } else if (num > sec && num != first) {
                sec = num;
            }
        }

        return sec;
    }

    public static List<Integer> mergetwolists(List<Integer> num1, List<Integer> num2) {
        List<Integer> list = new ArrayList<>(num1);
        list.addAll(num2);

        return list;
    }

    public static List<Integer> Intersectiontwolists(List<Integer> num1, List<Integer> num2) {
        List<Integer> list = new ArrayList<>(num1);
        list.retainAll(num2);

        return list;
    }

    public static List<Integer> removeDuplicates(List<Integer> nums) {
        return new ArrayList<>(new LinkedHashSet<>(nums));
    }

    public static int findMax(List<Integer> nums) {
        if (nums.isEmpty())
            return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max)
                max = num;
        }
        return max;
    }

    public static int findMin(List<Integer> nums) {
        if (nums.isEmpty())
            return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min)
                min = num;
        }
        return min;
    }

    public static int sum(List<Integer> nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        return sum;
    }

    public static double average(List<Integer> nums) {
        if (nums.isEmpty())
            return 0.0;
        return (double) sum(nums) / nums.size();
    }

    public static List<Integer> difference(List<Integer> num1, List<Integer> num2) {
        List<Integer> diff = new ArrayList<>(num1);
        diff.removeAll(num2);
        return diff;
    }

    public static List<Integer> symmetricDifference(List<Integer> num1, List<Integer> num2) {
        List<Integer> symDiff = new ArrayList<>();
        for (int num : num1) {
            if (!num2.contains(num))
                symDiff.add(num);
        }
        for (int num : num2) {
            if (!num1.contains(num))
                symDiff.add(num);
        }
        return symDiff;
    }

    public static List<Integer> union(List<Integer> num1, List<Integer> num2) {
        Set<Integer> set = new LinkedHashSet<>(num1);
        set.addAll(num2);
        return new ArrayList<>(set);
    }

    public static List<Integer> intersectionUnique(List<Integer> num1, List<Integer> num2) {
        List<Integer> inter = new ArrayList<>();
        for (int num : num1) {
            if (num2.contains(num) && !inter.contains(num))
                inter.add(num);
        }
        return inter;
    }

    public static void main(String[] args) {
        // Initialize an ArrayList of Integers
        List<Integer> l = new ArrayList<>();

        // Adding elements to the list
        l.add(4);
        l.add(5);
        l.add(4);

        System.out.println("Initial list after adding 4, 5, 4: " + l);

        // Inserting element at specific index
        l.add(0, 3);
        System.out.println("List after inserting 3 at index 0: " + l);

        // Removing first occurrence of an element
        l.remove(Integer.valueOf(4));
        System.out.println("List after removing first occurrence of 4: " + l);

        // Removing element at specific index
        l.remove(2);
        System.out.println("List after removing element at index 2: " + l);

        // Accessing element at index
        int val = l.get(0);
        System.out.println("Element at index 0: " + val);

        // Setting element at specific index
        l.set(1, 10);
        System.out.println("List after setting index 1 to 10: " + l);

        // Finding index of an element
        int index = l.indexOf(10);
        System.out.println("Index of 10: " + index);

        // Checking if element exists
        boolean exists = l.contains(3);
        System.out.println("Does list contain 3? " + exists);

        // Getting size of the list
        int size = l.size();
        System.out.println("Size of the list: " + size);

        // Checking if list is empty
        boolean empty = l.isEmpty();
        System.out.println("Is the list empty? " + empty);

        // Iteration using Iterator
        System.out.print("Iterating using Iterator: ");
        Iterator<Integer> it = l.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Iteration using ListIterator (forward)
        System.out.print("Iterating using ListIterator (forward): ");
        ListIterator<Integer> lit = l.listIterator();
        while (lit.hasNext()) {
            System.out.print(lit.next() + " ");
        }
        System.out.println();

        // Iteration using ListIterator (backward)
        System.out.print("Iterating using ListIterator (backward): ");
        while (lit.hasPrevious()) {
            System.out.print(lit.previous() + " ");
        }
        System.out.println();

        // Adding another element for sorting demo
        l.add(5);
        System.out.println("List after adding 5: " + l);

        // Sorting the list
        Collections.sort(l);
        System.out.println("List after sorting in ascending order: " + l);

        // Reversing the list
        Collections.reverse(l);
        System.out.println("List after reversing: " + l);

        // Creating a String array and converting it to a List
        String[] arr = { "A", "b", "v" };
        List<String> listr = new ArrayList<>(Arrays.asList(arr));
        System.out.println("List created from array: " + listr);

        // Converting List back to Object array
        String[] arrlist = listr.toArray(new String[0]);
        System.out.println("Array converted from list: " + Arrays.toString(arrlist));

        List<Integer> newlist = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println(secondHighestFromList(newlist));
    }

}
