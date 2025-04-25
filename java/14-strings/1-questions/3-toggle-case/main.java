/*
 * 'p' - 'a' = 'P' - 'A'
 * 'p' = 'a' + 'P' - 'A'
 * Similarly
 * 'P' = 'A' + 'p' - 'a'
 * 
 * in general
 * lc = 'a' + uc - 'A'
 * uc = 'A' + lc - 'a'
 */

import java.util.Scanner;

public class main {

    public static String toggleCase(String str) {
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                char uch = (char) ('A' + ch - 'a');
                sb.setCharAt(i, uch);
            } else if (ch >= 'A' && ch <= 'Z') {
                char lch = (char) ('a' + ch - 'A');
                sb.setCharAt(i, lch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user for input
        System.out.println("Enter a string:");
        String input = sc.nextLine();

        // Toggle case
        String toggled = toggleCase(input);

        // Output result
        System.out.println("Toggled case string: " + toggled);

        sc.close();
    }
}
