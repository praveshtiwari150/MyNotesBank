## 📑 Problem Statement: Find Ceil and Floor of a Number in a Sorted Array

Given a **sorted array of integers** in ascending order and a target integer `data`, determine:

- **Ceil** of `data`: the **smallest element in the array greater than or equal to `data`**
- **Floor** of `data`: the **largest element in the array less than or equal to `data`**

If no such element exists, print `"No Ceil"` or `"No Floor"` accordingly.

---

### 📥 Input Format:
- The first line contains an integer `n` — the number of elements in the array.
- The second line contains `n` space-separated integers — elements of the array (sorted in ascending order).
- The third line contains an integer `data` — the target value.

---

### 📤 Output Format:
- Print two lines:
  - First line: `Ceil -> <value>`  
  - Second line: `Floor -> <value>`  

If no ceil or floor exists, output `No Ceil` or `No Floor` respectively.

---

### 📎 Constraints:
- `1 <= n <= 10^5`
- `-10^9 <= arr[i], data <= 10^9`
- Array is sorted in **non-decreasing order**

---

### 📈 Example:

**Input**
```
6
2 4 6 8 10 12
5
```

**Output**
```
Ceil -> 6
Floor -> 4
```

**Input**
```
5
3 7 9 15 20
21
```

**Output**
```
Ceil -> No Ceil
Floor -> 20
```

---

### 📌 Note:
The solution must use **binary search** to achieve `O(log n)` time complexity.