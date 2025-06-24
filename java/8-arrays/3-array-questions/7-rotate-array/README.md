# Rotate an Array in Java (User Input)

## Problem Statement  
Write a Java program that takes an array of integers and an integer **k** as input from the user, rotates the array **k** times to the right, and prints the rotated array.

## Input Format  
1. The first line contains two integers **n** (size of the array) and **k** (number of right rotations).  
2. The second line contains **n** space-separated integers representing the elements of the array.

## Output Format  
- Print the rotated array as space-separated integers on a single line.

## Example  

### **Input:**  
```
7 3
1 2 3 4 5 6 7
```

### **Output:**  
```
5 6 7 1 2 3 4
```

## Constraints  
- \(1 \leq n \leq 10^6\)  
- \(-10^9 \leq\) each element of the array \(\leq 10^9\)  
- \( -10^6 \leq k \leq 10^6 \)  

## Requirements  
- The program should handle negative **k** values (i.e., rotating left when **k** is negative).  
- The rotation should be performed **in-place** without using extra space.  
- The function should have the following signature:  

```java
public static void rotateArray(int[] arr, int n, int k)
```

## Sample Test Case  

### **Input:**  
```
6 2
10 20 30 40 50 60
```

### **Output:**  
```
50 60 10 20 30 40
```

## Hints  
- **Use the reverse method to rotate efficiently**:
  - Reverse the first **n-k** elements.
  - Reverse the last **k** elements.
  - Reverse the entire array.
- Handle cases where **k** is greater than **n** using `k = k % n`.
- If **k** is negative, convert it to a positive rotation using `k = k + n`.
