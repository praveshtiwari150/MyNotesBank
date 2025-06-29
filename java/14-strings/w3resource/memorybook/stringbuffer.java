public class StringBufferMemoryBook {
    public static void main(String[] args) {
        // 1. Creating StringBuffer
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println("Original StringBuffer: " + sb);

        // 2. Traversal
        System.out.print("Traversal: ");
        for (int i = 0; i < sb.length(); i++) {
            System.out.print(sb.charAt(i) + " ");
        }
        System.out.println();

        // 3. Insertion
        sb.insert(5, " World");
        System.out.println("After insertion: " + sb);

        // 4. Deletion
        sb.delete(5, 11);
        System.out.println("After deletion: " + sb);

        // 5. Searching
        int index = sb.indexOf("lo");
        System.out.println("Index of 'lo': " + index);

        // 6. Updating
        sb.replace(0, 5, "Hi");
        System.out.println("After updating: " + sb);

        // 7. Sorting (convert to char array and sort)
        char[] chars = sb.toString().toCharArray();
        java.util.Arrays.sort(chars);
        System.out.println("After sorting chars: " + new String(chars));

        // 8. Merging
        StringBuffer another = new StringBuffer(" there!");
        sb.append(another);
        System.out.println("After merging: " + sb);

        // 9. Copying
        StringBuffer copied = new StringBuffer(sb);
        System.out.println("Copied StringBuffer: " + copied);

        // 10. Reversing
        sb.reverse();
        System.out.println("After reversing: " + sb);
    }
}
