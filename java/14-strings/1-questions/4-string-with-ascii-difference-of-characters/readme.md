## 🔡 Problem: Insert ASCII Differences Between Characters

### Description
Given a string containing lowercase or uppercase English letters, your task is to generate a new string by inserting the ASCII difference between each pair of consecutive characters.

For every two adjacent characters in the string:
- Compute the difference between their ASCII values.
- Insert that difference between the characters in the result string.

The first character of the original string should remain the first character of the output.

---

### Input Format
- A single line containing a non-empty string `str`.

---

### Output Format
- A single line containing the transformed string with ASCII gaps inserted.

---

### Constraints
- `1 ≤ str.length() ≤ 1000`
- The string will consist of only alphabetic characters (both lowercase and uppercase).

---

### Sample Input
```
abecd
```

### Sample Output
```
a1b3e-2c1d
```

---

### Explanation
- `'b' - 'a' = 1` → insert `1`
- `'e' - 'b' = 3` → insert `3`
- `'c' - 'e' = -2` → insert `-2`
- `'d' - 'c' = 1` → insert `1`

Combining these with the original characters results in: `a1b3e-2c1d`