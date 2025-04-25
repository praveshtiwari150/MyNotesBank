import java.util.*;

public class main {

    public static int firstIndex(int lo, int hi, int[] arr, int data) {
        int fi = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (data > arr[mid]) {
                lo = mid + 1;
            } else if (data < arr[mid]) {
                hi = mid - 1;
            } else {
                fi = mid;
                hi = mid - 1;
            }
        }

        return fi;
    }

    public static int lastIndex(int lo, int hi, int[] arr, int data) {
        int li = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (data > arr[mid]) {
                lo = mid + 1;
            } else if (data < arr[mid]) {
                hi = mid - 1;
            } else {
                li = mid;
                lo = mid + 1;
            }
        }

        return li;
    }
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
        int fi = firstIndex(lo, hi, arr, data);
        int li = lastIndex(lo, hi, arr, data);

        System.out.println(fi);
        System.out.println(li);
    }
}
