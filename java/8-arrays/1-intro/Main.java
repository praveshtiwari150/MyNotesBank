import java.util.Scanner;

public class Main {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[5];
        arr[0] = 33;
        arr[1] = 47;
        arr[2] = 59;
        arr[3] = 67;
        arr[4] = 98;

        // int[] two = arr;
        // two[2] = 200;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        System.out.println();

        // array when passed to function
        swap(arr, 0, 4);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}