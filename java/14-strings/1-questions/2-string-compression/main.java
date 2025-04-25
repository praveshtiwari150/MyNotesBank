import java.util.Scanner;

public class main {

    // Method to remove consecutive duplicate characters
    public static String compression1(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder s = new StringBuilder();
        s.append(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);

            if (curr != prev) {
                s.append(curr);
            }
        }

        return s.toString();
    }

    // Method to compress the string by replacing sequences of the same character
    // with that character followed by the count of its repetitions
    public static String compression2(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder s = new StringBuilder();
        s.append(str.charAt(0));
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);

            if (curr == prev) {
                count++;
            } else {
                if (count > 1) {
                    s.append(count);
                }
                s.append(curr);
                count = 1;
            }
        }

        if (count > 1) {
            s.append(count);
        }

        return s.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        // Apply compression1 and display the result
        String result1 = compression1(input);
        System.out.println("Compression1 Output: " + result1);

        // Apply compression2 and display the result
        String result2 = compression2(input);
        System.out.println("Compression2 Output: " + result2);

        scanner.close();
    }
}
