## 📑 Problem Statement: Find First and Last Occurrence of an Element in a Sorted Array

Given a **sorted array of integers** in ascending order and a target integer `data`, determine:

- The **first index** at which `data` occurs in the array
- The **last index** at which `data` occurs in the array

If `data` is not present in the array, output `-1` for both positions.

---

### 📥 Input Format:
- The first line contains an integer `n` — the number of elements in the array.
- The second line contains `n` space-separated integers — elements of the array (sorted in ascending order).
- The third line contains an integer `data` — the target value to search.

---

### 📤 Output Format:
- Print two lines:
  - First line: the index of the first occurrence of `data`
  - Second line: the index of the last occurrence of `data`  

If `data` is not found, both values should be `-1`.

---

### 📎 Constraints:
- `1 <= n <= 10^5`
- `-10^9 <= arr[i], data <= 10^9`
- Array is sorted in **non-decreasing order**

---

### 📈 Example:

**Input**
```
8
1 2 2 2 3 4 5 6
2
```

**Output**
```
1
3
```

**Input**
```
6
2 4 6 8 10 12
5
```

**Output**
```
-1
-1
```

---

### 📌 Note:
The solution must use **binary search** to achieve `O(log n)` time complexity for each search.