
public class main {

    public static boolean isGreater(int[] arr, int i, int j) {
        return arr[i] > arr[j];
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (isGreater(arr,j, j+1)) {
                    swap(arr, j, j+1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 23, 5, 8, 29, 3 };

        System.out.println("Before insertionSort: ");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
     insertionSort(arr);
        System.out.println();
        System.out.println("After insertionSort: ");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }
}