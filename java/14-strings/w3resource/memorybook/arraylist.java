import java.util.*;

public class ArrayListMemoryBook {
    public static void main(String[] args) {
        // 1. Creating ArrayList
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Empty list: " + list);

        // 2. Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("After add(): " + list);

        // 3. Adding at index
        list.add(1, "Mango");
        System.out.println("After add(index, element): " + list);

        // 4. Accessing element
        String fruit = list.get(2);
        System.out.println("Element at index 2: " + fruit);

        // 5. Setting element
        list.set(0, "Orange");
        System.out.println("After set(0, Orange): " + list);

        // 6. Removing element by index
        list.remove(1);
        System.out.println("After remove(index): " + list);

        // 7. Removing element by value
        list.remove("Cherry");
        System.out.println("After remove(value): " + list);

        // 8. Checking size
        System.out.println("Size of list: " + list.size());

        // 9. Checking if empty
        System.out.println("Is list empty?: " + list.isEmpty());

        // 10. Searching element
        System.out.println("Contains 'Apple'?: " + list.contains("Apple"));
        System.out.println("Index of 'Orange': " + list.indexOf("Orange"));

        // 11. Traversal using for-each
        System.out.print("Traversal using for-each: ");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        // 12. Traversal using iterator
        System.out.print("Traversal using iterator: ");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 13. Clearing list
        list.clear();
        System.out.println("After clear(): " + list);

        // 14. Adding all elements from another list
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("D", "E"));
        list1.addAll(list2);
        System.out.println("After addAll(): " + list1);

        // 15. Sorting list
        Collections.sort(list1);
        System.out.println("After sort(): " + list1);

        // 16. Reversing list
        Collections.reverse(list1);
        System.out.println("After reverse(): " + list1);

        // 17. Copying list
        ArrayList<String> copiedList = new ArrayList<>(list1);
        System.out.println("Copied list: " + copiedList);

        // 18. SubList
        List<String> subList = list1.subList(1, 3);
        System.out.println("SubList (1 to 2): " + subList);

        // 19. Converting to array
        String[] array = list1.toArray(new String[0]);
        System.out.println("Converted to array: " + Arrays.toString(array));
    }
}
