
public class main {

    public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                res[k] = a[i];
                i++;
                k++;
            } else {
                res[k] = b[j];
                j++;
                k++;
            }
        }

        while (i < a.length) {
            res[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            res[k] = b[j];
            j++;
            k++;
        }

        return res;
    }

    public static int[] mergeSort(int[] arr, int lo, int hi) {

        if (lo == hi) {
            int[] ba = new int[1];
            ba[0] = arr[lo];
            return ba;
        }
        int mid = (lo + hi) / 2;
        int[] fsh = mergeSort(arr, lo, mid);
        int[] ssh = mergeSort(arr, mid + 1, hi);
        int[] fsa = mergeTwoSortedArrays(fsh, ssh);
        return fsa;
    }

    public static void main (String[] args) {
        int[] arr = { 34, 2, 5, 74, 9 };
        int[] ans = mergeSort(arr,0, arr.length-1);

        for (int element : ans) {
            System.out.print(element + " ");
        }
    }
}
