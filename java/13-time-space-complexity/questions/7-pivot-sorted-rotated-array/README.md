# 🔍 Problem: Find Pivot in Rotated Sorted Array

## 🧠 Description

You are given a **sorted array** that has been **rotated at an unknown pivot**. Your task is to write a function that finds and returns the **minimum element** in this rotated sorted array.

The array contains **distinct integers** and was originally sorted in **ascending order**, but it may have been rotated 1 or more times.

For example, the array `[0, 1, 2, 4, 5, 6, 7]` might become `[4, 5, 6, 7, 0, 1, 2]` after rotation.

## ✅ Constraints

- The array contains **at least one element**.
- All integers are **distinct**.
- Time complexity must be **O(log n)**.
- Space complexity must be **O(1)**.

## 📥 Input

- An integer array `arr[]` representing a rotated sorted array.

## 📤 Output

- An integer representing the **smallest element** (pivot) in the array.

## 🧪 Example

### Input:
```java
int[] arr = {6, 7, 8, 1, 2, 3, 4, 5};
```

### Output:
```
1
```

### Explanation:
The array is rotated, and the smallest element is `1`, which is the **pivot point** where the rotation occurred.

## 🧑‍💻 Function Signature
```java
public static int findPivot(int[] arr)
```