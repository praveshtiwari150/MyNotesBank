## 🔁 Problem: Print All Permutations of a String

### Description
Given a string `str`, print **all possible permutations** of its characters. The permutations should be printed in **lexicographic order of factorial numbering**, not necessarily dictionary order.

Use the **factorial number system** approach to generate the permutations without recursion.

---

### Input Format
- A single line containing a string `str`.

---

### Output Format
- Print all permutations of the string, each on a new line.

---

### Constraints
- `1 ≤ str.length() ≤ 8`
- The string will consist of **distinct characters only**.

---

### Sample Input
```
abc
```

### Sample Output
```
abc  
acb  
bac  
bca  
cab  
cba
```

---

### Explanation
There are `3! = 6` permutations of the string `"abc"`, and all of them are generated and printed using the factorial number system method, which maps an index `0` to `n!-1` to a unique permutation.