```md
# Inverse of an Array in Java

## Problem Statement  
Write a Java program that takes an array of distinct integers from the user, computes its **inverse**, and prints the inverted array.  

The **inverse** of an array means that for each index `i` in the original array, the value at `arr[i]` should become the index, and the index `i` should become the value at that position in the inverted array.

## Input Format  
1. The first line contains an integer **n** — the number of elements in the array.  
2. The second line contains **n** space-separated integers, representing a **permutation** of numbers from **0 to n-1**.

## Output Format  
- Print the inverse of the given array as space-separated integers on a single line.

## Example  

### **Input:**  
```
5
4 0 2 3 1
```

### **Output:**  
```
1 4 2 3 0
```

## Constraints  
- \(1 \leq n \leq 10^6\)  
- The array must be a **valid permutation** of numbers from **0 to n-1** (i.e., all numbers in this range must be present exactly once).  

## Requirements  
- Implement the function with the following signature:  

```java
public static int[] inverse(int[] arr)
```

## Sample Test Case  

### **Input:**  
```
4
2 3 1 0
```

### **Output:**  
```
3 2 0 1
```

## Hints  
- Create a new array `inv` of the same length as the input array.  
- Iterate over the input array and place each index at the position given by its value.  
- Print the final inverted array.
