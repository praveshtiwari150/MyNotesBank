import java.util.*;

public class HashMapMemoryBook {
    public static void main(String[] args) {
        // 1. Creating HashMap
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        System.out.println("Original Map: " + map);

        // 2. Traversal
        System.out.println("Traversal:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 3. Insertion (put new key-value pair)
        map.put(4, "Date");
        System.out.println("After insertion: " + map);

        // 4. Deletion (remove by key)
        map.remove(2);
        System.out.println("After deletion of key 2: " + map);

        // 5. Searching (check if key exists)
        System.out.println("Contains key 3?: " + map.containsKey(3));

        // 6. Updating (replace value at a key)
        map.put(3, "Coconut");
        System.out.println("After updating key 3: " + map);

        // 7. Sorting by key (use TreeMap)
        TreeMap<Integer, String> sortedMap = new TreeMap<>(map);
        System.out.println("After sorting by key: " + sortedMap);

        // 8. Merging (put all entries from another map)
        HashMap<Integer, String> anotherMap = new HashMap<>();
        anotherMap.put(5, "Elderberry");
        anotherMap.put(6, "Fig");
        map.putAll(anotherMap);
        System.out.println("After merging: " + map);

        // 9. Copying
        HashMap<Integer, String> copiedMap = new HashMap<>(map);
        System.out.println("Copied Map: " + copiedMap);

        // 10. Reversing (create LinkedHashMap with reversed entry order)
        LinkedHashMap<Integer, String> reversedMap = new LinkedHashMap<>();
        ArrayList<Map.Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());
        Collections.reverse(entries);
        for (Map.Entry<Integer, String> entry : entries) {
            reversedMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println("After reversing: " + reversedMap);
    }
}
