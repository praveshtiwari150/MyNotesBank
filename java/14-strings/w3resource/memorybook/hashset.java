import java.util.*;

public class HashSetMemoryBook {
    public static void main(String[] args) {
        // 1. Creating HashSet
        HashSet<String> set = new HashSet<>();
        System.out.println("Empty set: " + set);

        // 2. Adding elements
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // duplicate
        System.out.println("After add(): " + set);

        // 3. Removing element
        set.remove("Banana");
        System.out.println("After remove(): " + set);

        // 4. Checking size
        System.out.println("Size: " + set.size());

        // 5. Checking if set is empty
        System.out.println("Is empty?: " + set.isEmpty());

        // 6. Searching element
        System.out.println("Contains 'Apple'?: " + set.contains("Apple"));

        // 7. Traversal using for-each
        System.out.print("Traversal: ");
        for (String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();

        // 8. Traversal using iterator
        System.out.print("Traversal using iterator: ");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 9. Clear set
        set.clear();
        System.out.println("After clear(): " + set);

        // 10. Adding all elements from another set
        HashSet<String> set1 = new HashSet<>(Arrays.asList("X", "Y", "Z"));
        HashSet<String> set2 = new HashSet<>(Arrays.asList("A", "B"));
        set1.addAll(set2);
        System.out.println("After addAll(): " + set1);

        // 11. Set union
        HashSet<String> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        System.out.println("Union: " + unionSet);

        // 12. Set intersection
        HashSet<String> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        System.out.println("Intersection: " + intersectionSet);

        // 13. Set difference
        HashSet<String> differenceSet = new HashSet<>(set1);
        differenceSet.removeAll(set2);
        System.out.println("Difference: " + differenceSet);
    }
}
