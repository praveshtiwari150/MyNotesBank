
public class main {

    public static boolean isSmaller(int[] arr, int i, int j) {
        return arr[i] < arr[j];
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void bubbleSort(int[] arr) {
        for (int itr = 1; itr < arr.length; itr++) {
            for (int j = 0; j < arr.length - itr; j++) {
                if (isSmaller(arr, j + 1, j)) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = { 23, 5, 8, 29, 3 };

        System.out.println("Before bubbleSort: ");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        bubbleSort(arr);
        System.out.println();
        System.out.println("After bubbleSort: ");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }
}