
# Reverse an Array in Java (User Input)

## Problem Statement  
Write a Java program that reads an integer array from the user, reverses the array **in-place**, and prints the reversed array.

## Input Format  
1. The first line contains an integer **n** — the number of elements in the array.  
2. The second line contains **n** space-separated integers — the elements of the array.

## Output Format  
- Print the reversed array as space-separated integers on a single line.

## Example  

### **Input:**  
```
5
1 2 3 4 5
```

### **Output:**  
```
5 4 3 2 1
```

## Constraints  
- \(1 \leq n \leq 10^6\)  
- \(-10^9 \leq\) each element of the array \(\leq 10^9\)  

## Requirements  
- Implement an **in-place reversal** using the **two-pointer approach**.  
- Do **not** use extra space (i.e., avoid creating a new array).  
- The function should have the following signature:  

```java
public static void reverseArray(int[] arr)
```

## Sample Test Case  

### **Input:**  
```
6
10 20 30 40 50 60
```

### **Output:**  
```
60 50 40 30 20 10
```

## Hints  
- Use two pointers: one starting from the beginning (`left`) and one from the end (`right`).
- Swap the elements at `left` and `right`, then move the pointers toward the center.
- Continue until `left` meets `right`.

---
