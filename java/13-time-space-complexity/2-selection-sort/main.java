
public class main {

    public static boolean isSmaller(int[] arr, int i, int j) {
        return arr[i] < arr[j];
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (isSmaller(arr, j, min)) {
                    min = j;
                }
            }

            swap(arr, i, min);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 23, 5, 8, 29, 3 };

        System.out.println("Before selectionSort: ");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        selectionSort(arr);
        System.out.println();
        System.out.println("After selectionSort: ");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }
}