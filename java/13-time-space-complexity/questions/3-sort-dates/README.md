### ✅ **Question: Sort Dates Using Radix Sort**

You are given an array of `n` dates in the form of strings, where each date is represented in the format `"ddmmyyyy"` (e.g., `"12051998"` represents 12th May 1998). Your task is to **sort the dates in chronological order** using a radix sort-based approach.

#### 📥 Input:
- The first line contains a single integer `n`, the number of dates.
- The next `n` lines each contain a date string of 8 digits (`"ddmmyyyy"` format).

#### 📤 Output:
- Print the sorted dates, one on each line, in chronological order.

#### 💡 Constraints:
- `1 <= n <= 10^5`
- All dates are valid and within a reasonable range (e.g., years between 0001 and 2500).

---

#### 🔁 Example:

**Input:**
```
5
12051998
24031996
05061997
23051999
01012000
```

**Output:**
```
24031996
05061997
12051998
23051999
01012000
```

---

### 🔧 Note for Implementation:
You should:
1. Sort by day (`dd`) using count sort.
2. Then by month (`mm`).
3. Finally, by year (`yyyy`).

Make sure your sorting is **stable** to maintain the relative order where needed.