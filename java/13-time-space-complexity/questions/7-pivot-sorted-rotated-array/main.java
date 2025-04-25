public class main {
    public static int findPivot(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] < arr[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return arr[hi]; // or arr[lo], since lo == hi
    }

    public static void main(String[] args) {
        int[] rotatedArray = { 6, 7, 8, 1, 2, 3, 4, 5 };
        int pivot = findPivot(rotatedArray);
        System.out.println("Pivot (smallest element) is: " + pivot);
    }
}
