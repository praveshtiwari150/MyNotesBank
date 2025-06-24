
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
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        int[] b = { 1, 7, 8, 9 };

        int[] ans = mergeTwoSortedArrays(a, b);

        for (int element : ans) {
            System.out.print(element + " ");
        }
    }
}