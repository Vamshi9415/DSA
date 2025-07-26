import java.util.*;

public class arrayList {
    public static void main(String[] args){
        
        // Creating an ArrayList to store String elements
        ArrayList<String> list = new ArrayList<>();
        
        // Adding elements to the end of the list
        list.add("apple");      // Index 0
        list.add("banana");     // Index 1
        
        // Adding element at specific index (1) - shifts existing elements
        list.add(1,"Orange");   // Orange goes to index 1, banana shifts to index 2
        
        // Display the current list
        System.out.println(" fruits "+ list);
        // Output: fruits [apple, Orange, banana]
        
        // Remove element by value (first occurrence)
        list.remove("apple");
        
        // Display list after removal
        System.out.println(" fruits after removing apple "+ list);
        // Output: fruits after removing apple [Orange, banana]
        
        // Check if list contains a specific element
        System.out.println("contains mango ? "+ list.contains("mango"));
        // Output: contains mango ? false
        
        // Get the size of the list
        System.out.println(" Size: "+ list.size());
        // Output: Size: 2
        
        // Additional useful ArrayList operations with comments
        
        // Get element at specific index
        System.out.println("Element at index 0: " + list.get(0));
        // Output: Element at index 0: Orange
        
        // Find index of an element (-1 if not found)
        System.out.println("Index of 'banana': " + list.indexOf("banana"));
        // Output: Index of 'banana': 1
        
        // Replace element at specific index
        list.set(0, "mango");
        System.out.println("After replacing index 0 with mango: " + list);
        // Output: After replacing index 0 with mango: [mango, banana]
        
        // Add multiple elements at once
        list.addAll(Arrays.asList("grape", "cherry", "kiwi"));
        System.out.println("After adding multiple fruits: " + list);
        // Output: After adding multiple fruits: [mango, banana, grape, cherry, kiwi]
        
        // Remove element by index and get the removed element
        String removed = list.remove(2);
        System.out.println("Removed element at index 2: " + removed);
        System.out.println("List after removal: " + list);
        // Output: Removed element at index 2: grape
        // Output: List after removal: [mango, banana, cherry, kiwi]
        
        // Iterate through the list using enhanced for loop
        System.out.print("Iterating through list: ");
        for(String fruit : list) {
            System.out.print(fruit + " ");
        }
        System.out.println();
        // Output: Iterating through list: mango banana cherry kiwi 
        
        // Sort the list alphabetically
        Collections.sort(list);
        System.out.println("Sorted list: " + list);
        // Output: Sorted list: [banana, cherry, kiwi, mango]
        
        // Create a sublist (from index 1 to 3, exclusive)
        List<String> subList = list.subList(1, 3);
        System.out.println("Sublist (index 1-2): " + subList);
        // Output: Sublist (index 1-2): [cherry, kiwi]
        
        // Convert ArrayList to array
        String[] array = list.toArray(new String[0]);
        System.out.println("Converted to array: " + Arrays.toString(array));
        // Output: Converted to array: [banana, cherry, kiwi, mango]
        
        // Clone the ArrayList
        ArrayList<String> clonedList = (ArrayList<String>) list.clone();
        System.out.println("Cloned list: " + clonedList);
        // Output: Cloned list: [banana, cherry, kiwi, mango]
        
        // Clear all elements from the list
        list.clear();
        
        // Check if list is empty
        System.out.println(" is list empty ? "+ list.isEmpty());
        // Output: is list empty ? true
        
        // Final size check
        System.out.println("Final size: " + list.size());
        // Output: Final size: 0
    }
}