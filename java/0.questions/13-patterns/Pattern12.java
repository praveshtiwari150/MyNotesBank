import java.util.Scanner;

public class Pattern12 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        int a = 0;
        int b = 1;

        for(int i = 1; i<=n; i++){
            for (int j = 1; j <= i; j++) {
                System.out.print(a + "\t");
                int temp = b;
                b = a + b;
                a = temp;
            }
            System.out.println();
            
        }
    }
}