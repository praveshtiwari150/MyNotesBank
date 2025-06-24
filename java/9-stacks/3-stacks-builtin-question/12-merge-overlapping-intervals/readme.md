## 📖 Question: Merge Overlapping Intervals

You are given a list of intervals where each interval is represented by a pair of integers `[start, end]`. Write a program to merge all overlapping intervals and print the merged intervals in sorted order (by start time).

👉 **Two intervals \[a, b] and \[c, d] overlap if `c` ≤ `b`.**

---

### ✳️ Example 1:

**Input:**

```
[ [1, 3], [2, 6], [8, 10], [15, 18] ]
```

**Output:**

```
1 6
8 10
15 18
```

**Explanation:**

* \[1,3] and \[2,6] overlap → merge to \[1,6]
* \[8,10] and \[15,18] don't overlap

---

### ✳️ Example 2:

**Input:**

```
[ [1, 4], [4, 5] ]
```

**Output:**

```
1 5
```

**Explanation:**

* \[1,4] and \[4,5] are touching (overlap at 4) → merge to \[1,5]

---

### ✳️ Example 3:

**Input:**

```
[ [6, 8], [1, 9], [2, 4], [4, 7] ]
```

**Output:**

```
1 9
```

**Explanation:**

* All intervals overlap directly or indirectly → merge into \[1,9]

---

## ✅ Constraints:

* `1 ≤ number of intervals ≤ 10^4`
* `start ≤ end` for each interval.