import java.util.Scanner;

public class main {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void partition(int[] arr, int pivot) {
        // 0 to j - 1 -> <= pivot;
        // j to i-1 -> > pivot;
        // i  toend -> unknow
        int i = 0;
        int j = 0;

        while (i < arr.length) {
            if (arr[i] > pivot) {
                i++;
            }
            else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int p = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        
        partition(arr, p);

        for(int ele:arr){
            System.out.print(ele + " ");
        }
    }
}
