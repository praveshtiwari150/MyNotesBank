import java.util.*;

public class HashtableMemoryBook {
    public static void main(String[] args) {
        // 1. Creating Hashtable
        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(1, "Apple");
        table.put(2, "Banana");
        table.put(3, "Cherry");
        System.out.println("Original Hashtable: " + table);

        // 2. Traversal
        System.out.println("Traversal:");
        for (Map.Entry<Integer, String> entry : table.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 3. Insertion
        table.put(4, "Date");
        System.out.println("After insertion: " + table);

        // 4. Deletion
        table.remove(2);
        System.out.println("After deletion of key 2: " + table);

        // 5. Searching
        System.out.println("Contains key 3?: " + table.containsKey(3));

        // 6. Updating
        table.put(3, "Coconut");
        System.out.println("After updating key 3: " + table);

        // 7. Sorting (Hashtable is unordered, convert to TreeMap)
        TreeMap<Integer, String> sortedMap = new TreeMap<>(table);
        System.out.println("After sorting by key: " + sortedMap);

        // 8. Merging
        Hashtable<Integer, String> anotherTable = new Hashtable<>();
        anotherTable.put(5, "Elderberry");
        anotherTable.put(6, "Fig");
        table.putAll(anotherTable);
        System.out.println("After merging: " + table);

        // 9. Copying
        Hashtable<Integer, String> copiedTable = new Hashtable<>(table);
        System.out.println("Copied Hashtable: " + copiedTable);

        // 10. Reversing (LinkedHashMap with reversed entry order)
        LinkedHashMap<Integer, String> reversedMap = new LinkedHashMap<>();
        ArrayList<Map.Entry<Integer, String>> entries = new ArrayList<>(table.entrySet());
        Collections.reverse(entries);
        for (Map.Entry<Integer, String> entry : entries) {
            reversedMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println("After reversing: " + reversedMap);
    }
}
