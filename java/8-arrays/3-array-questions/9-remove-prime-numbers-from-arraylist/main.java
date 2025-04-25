import java.util.*;

public class main {

    public static boolean isPrime(int val) {
        if (val <= 1)
            return false; // edge case for numbers <= 1
        for (int div = 2; div * div <= val; div++) {
            if (val % div == 0) {
                return false;
            }
        }
        return true;
    }

    public static void solution(ArrayList<Integer> a1) {
        for (int i = a1.size() - 1; i >= 0; i--) {
            int val = a1.get(i);
            if (isPrime(val)) {
                a1.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask user for number of elements
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // Process the list to remove primes
        solution(list);

        // Print the modified list
        System.out.println("List after removing prime numbers:");
        for (int num : list) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
