
### 💻 Problem: Partition Array Around Pivot

You are given an array of `n` integers and a **pivot element** `p`. Your task is to rearrange (or partition) the array so that:

- All elements **less than or equal to the pivot** appear before all elements **greater than the pivot**.
- The relative order of elements **within each group (<= pivot and > pivot)** must be preserved.

Implement this using **in-place swapping**.  

---

### ✍️ Input Format:
- The first line contains two integers `n` (size of array) and `p` (the pivot).
- The second line contains `n` space-separated integers denoting the array elements.

---

### 📤 Output Format:
- Print the rearranged array after partitioning.

---

### ✅ Constraints:
- `1 <= n <= 10^5`  
- `-10^9 <= arr[i], p <= 10^9`

---

### 🧪 Sample Input:
```
7 5
7 2 9 4 3 6 1
```

### 🎯 Sample Output:
```
2 4 3 1 7 9 6
```

---

### 💡 Explanation:
- Elements ≤ 5: `2, 4, 3, 1`
- Elements > 5: `7, 9, 6`
- The relative order is preserved within both groups.

