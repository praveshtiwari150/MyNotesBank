Certainly! Here's a well-structured coding problem based on the Java program you've been working with:

---

## 🧩 Problem: Form Minimum Number from 'D' and 'I' Pattern

### **Problem Statement**

Given a string `pattern` consisting of characters `'D'` (decrease) and `'I'` (increase), your task is to generate the lexicographically smallest sequence of unique digits that follows this pattern.

* Each character in the input string represents a relationship between two adjacent digits in the output sequence:

  * `'D'` means the next digit is smaller than the previous one.
  * `'I'` means the next digit is greater than the previous one.

* You must use the digits from `1` to `9` without repetition.

* The length of the output sequence should be one more than the length of the input pattern.

### **Input**

* A single string `pattern` of length `n` (1 ≤ n ≤ 8), consisting only of characters `'D'` and `'I'`.

### **Output**

* A single line containing the lexicographically smallest sequence of digits that follows the given pattern.

### **Examples**

#### Example 1

**Input:**

```

D
```



**Output:**

```

21
```



**Explanation:**

The pattern `'D'` indicates that the first digit should be greater than the second. The smallest such sequence using unique digits is `21`.

#### Example 2

**Input:**

```

I
```



**Output:**

```

12
```



**Explanation:**

The pattern `'I'` indicates that the first digit should be less than the second. The smallest such sequence using unique digits is `12`.

#### Example 3

**Input:**

```

DDIDDIID
```



**Output:**

```

321654798
```



**Explanation:**

The sequence `321654798` follows the pattern `'DDIDDIID'`:

* `3 > 2 > 1` → `'D'`, `'D'`
* `1 < 6` → `'I'`
* `6 > 5 > 4` → `'D'`, `'D'`
* `4 < 7 < 9` → `'I'`, `'I'`
* `9 > 8` → `'D'`

### **Constraints**

* 1 ≤ length of `pattern` ≤ 8
* The pattern consists only of characters `'D'` and `'I'`.
* Digits from `1` to `9` must be used without repetition.

### **Note**

This problem is inspired by the "Form minimum number from given sequence" challenge, which involves generating the smallest number that fits a given pattern of increases and decreases.([GeeksforGeeks][1])

---

This problem is excellent for practicing stack operations and understanding how to manipulate sequences based on specific patterns.

If you'd like, I can also provide a sample solution or further explanation on how to approach this problem.

[1]: https://www.geeksforgeeks.org/form-minimum-number-from-given-sequence/?utm_source=chatgpt.com "Form minimum number from given sequence | GeeksforGeeks"
