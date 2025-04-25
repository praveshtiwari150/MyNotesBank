public class main {
    // Method to swap elements at indices i and j in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Method to sort the array consisting of 0s and 1s
    public static void sort01(int[] arr) {
        int i = 0;
        int j = 0;

        while (i < arr.length) {
            if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
    }

    // Main method to test the sort01 function
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0, 0, 1, 0};

        System.out.println("Before sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        sort01(arr);

        System.out.println("After sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
