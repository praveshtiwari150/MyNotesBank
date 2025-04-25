### ❓ Next Greater Element on the Right

🛠️ Given an array of integers, for each element, find the **next greater element** on its right. The next greater element of an element `x` is the **first greater element** to its right in the array. If no greater element exists, print `-1` for that element.

---

## ✅ Input Format  

- The first line contains an integer `n` (size of the array).  
- The second line contains `n` space-separated integers representing the array elements.

## ✅ Output Format  

- Print `n` space-separated integers, where each element represents the next greater element for the corresponding index in the input array.

---

## ✅ Constraints  

- `1 ≤ n ≤ 10^5`  
- `-10^9 ≤ arr[i] ≤ 10^9`  

---

## ✅ Example  

### 🔹 Example 1  

**Input:**  
```
5
2 1 3 8 6
```
**Output:**  
```
3 3 8 -1 -1
```
**Explanation:**  
- `2 → 3` (next greater element)  
- `1 → 3`  
- `3 → 8`  
- `8 → -1` (no greater element)  
- `6 → -1` (no greater element)  

---

### 🔹 Example 2  

**Input:**  
```
4
10 4 2 6
```
**Output:**  
```
-1 6 6 -1
```
**Explanation:**  
- `10 → -1` (no greater element)  
- `4 → 6`  
- `2 → 6`  
- `6 → -1`  

---

> 💡 **Note:** Solve this problem in **O(n) time complexity** using **stacks** for an optimal approach.
