public class main {
    // Method to swap elements at indices i and j in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Method to sort the array consisting of 0s, 1s, and 2s
    public static void sort012(int[] arr) {
        int low = 0; // 0 to low - 1 -> 0's area
        int mid = 0; // low to mid - 1 -> 1's area
        int high = arr.length - 1; // high + 1 to end -> 2's area

        // Traverse the array and sort the elements
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else { // arr[mid] == 2
                swap(arr, mid, high);
                high--;
            }
        }
    }

    // Main method to test the sort012 function
    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 1, 0, 2, 1, 0 };

        System.out.println("Before sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        sort012(arr);

        System.out.println("After sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
