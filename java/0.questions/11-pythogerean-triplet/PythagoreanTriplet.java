import java.util.*;

class PythagoreanTriplet {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int n3 = scn.nextInt();

        int h = n1;
        if (n2 > h) {
            h = n2;
        }

        if (n3 > h) {
            h = n3;
        }

        if (h == n1) {
            boolean flag = (n2 * n2 + n3 * n3) == n1 * n1;

            if (flag) {
                System.out.println("PythagoreanTriplet");
            }

            else{
                System.out.println("Not PythagoreanTriplet");
            }
        }
        
        if (h == n2) {
            boolean flag = (n1 * n1 + n3 * n3) == n2 * n2;

            if (flag) {
                System.out.println("PythagoreanTriplet");
            }

            else {
                System.out.println("Not PythagoreanTriplet");
            }
        }
        
        if (h == n3) {
            boolean flag = (n1 * n1 + n2 * n2) == n3 * n3;

            if (flag) {
                System.out.println("PythagoreanTriplet");
            }

            else {
                System.out.println("Not PythagoreanTriplet");
            }
        }
    }
}