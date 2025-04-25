import java.util.Scanner;

public class main {

    // Method to check if a given string is a palindrome
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);

            if (ch1 != ch2) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    // Method to print all palindromic substrings of a given string
    public static void printPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substr = s.substring(i, j);
                if (isPalindrome(substr)) {
                    System.out.println(substr);
                }
            }
        }
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.println("Palindromic substrings are:");
        printPalindrome(input);
        scanner.close();
    }
}
