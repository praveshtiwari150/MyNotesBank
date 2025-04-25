import java.util.*;

public class main {

    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);
            int gap = curr - prev;
            sb.append(gap);
            sb.append(curr);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.println("Enter a string:");
        String input = sc.nextLine();

        // Generate and print the output
        String result = solution(input);
        System.out.println("Output with ASCII gaps: " + result);

        sc.close();
    }
}
