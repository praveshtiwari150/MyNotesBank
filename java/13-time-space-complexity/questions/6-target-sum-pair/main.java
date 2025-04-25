import java.util.*;

public class main {
    // Method to find and print all pairs in the array that sum to the target
    public static void targetSumPair(int[] arr, int target) {
        Arrays.sort(arr); // Sort the array to enable the two-pointer technique

        int left = 0; // Left pointer starts at the beginning of the array
        int right = arr.length - 1; // Right pointer starts at the end of the array

        while (left < right) {
            int currentSum = arr[left] + arr[right];

            if (currentSum < target) {
                left++; // Move the left pointer to the right to increase the sum
            } else if (currentSum > target) {
                right--; // Move the right pointer to the left to decrease the sum
            } else {
                System.out.println(arr[left] + ", " + arr[right]);
                left++;
                right--;
            }
        }
    }

    // Main method to test the targetSumPair function
    public static void main(String[] args) {
        int[] arr = { 1, 5, 7, -1, 5 };
        int target = 6;

        System.out.println("Pairs with sum " + target + ":");
        targetSumPair(arr, target);
    }
}
