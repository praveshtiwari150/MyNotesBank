import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // String s1 = "hello";
        // String s2 = scn.nextLine();
        // String s3 = scn.next();
        // System.out.println(s1);

        // String s = scn.nextLine();
        // System.out.println(s.length());
        // char ch = s.charAt(3);
        // System.out.println(ch);

        // for (int i = 0; i < s.length(); i++) {
        //     System.out.println(s.charAt(i));
        // }

        String s = "Jago Mohan Pyare"; 
        String substr1 = s.substring(0, 3);
        System.out.println(substr1);
        String substr2 = s.substring(4);
        System.out.println(substr2);

        // printing all substring
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j));
            }
        }

        String s1 = "hello";
        s1 += " pravesh's";
        String s2 = "World";
        String s3 = s1 + " " + s2;
        System.out.println(s3);
        System.out.println("hello" + 10 + 20);
        System.out.println(10 + 20 + "hello");

        String[] parts = s.split(" ");

        for (String str : parts) {
            System.out.print(str + " ");
        }
    }
}