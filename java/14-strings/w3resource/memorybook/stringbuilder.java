public class StringBuilderMemoryBook {
    public static void main(String[] args) {
        // 1. Creating StringBuilder
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Original StringBuilder: " + sb);

        // 2. Traversal (printing each character)
        System.out.print("Traversal: ");
        for (int i = 0; i < sb.length(); i++) {
            System.out.print(sb.charAt(i) + " ");
        }
        System.out.println();

        // 3. Insertion (insert at specific position)
        sb.insert(5, " World");
        System.out.println("After insertion: " + sb);

        // 4. Deletion (delete characters from index 5 to 11)
        sb.delete(5, 11);
        System.out.println("After deletion: " + sb);

        // 5. Searching (find index of substring)
        int index = sb.indexOf("lo");
        System.out.println("Index of 'lo': " + index);

        // 6. Updating (replace part of string)
        sb.replace(0, 5, "Hi");
        System.out.println("After updating: " + sb);

        // 7. Sorting (not directly supported, convert to char array and sort)
        char[] chars = sb.toString().toCharArray();
        java.util.Arrays.sort(chars);
        System.out.println("After sorting chars: " + new String(chars));

        // 8. Merging (append another StringBuilder)
        StringBuilder another = new StringBuilder(" there!");
        sb.append(another);
        System.out.println("After merging: " + sb);

        // 9. Copying (create new StringBuilder with same content)
        StringBuilder copied = new StringBuilder(sb);
        System.out.println("Copied StringBuilder: " + copied);

        // 10. Reversing
        sb.reverse();
        System.out.println("After reversing: " + sb);
    }
}
