import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int data = scn.nextInt();

        int lo = 0;
        int hi = arr.length - 1;
        int ceil = Integer.MAX_VALUE;
        int floor = Integer.MIN_VALUE;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (data < arr[mid]) {
                ceil = arr[mid]; // potential ceil
                hi = mid - 1;
            } else if (data > arr[mid]) {
                floor = arr[mid]; // potential floor
                lo = mid + 1;
            } else {
                ceil = arr[mid];
                floor = arr[mid];
                break;
            }
        }

        System.out.println("Ceil -> " + (ceil == Integer.MAX_VALUE ? "No Ceil" : ceil));
        System.out.println("Floor -> " + (floor == Integer.MIN_VALUE ? "No Floor" : floor));
    }
}
