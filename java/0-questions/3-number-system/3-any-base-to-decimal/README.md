## 🔢 Java Programming Question: Convert Any Base to Decimal

### Problem Statement  
Write a Java program that takes two inputs from the user:
1. A **number in a given base** (string format).
2. The **base** of that number (an integer from 2 to 36).

The program should convert the given number from its base to a **decimal (base 10)** number and print the result.

---

### Example Input/Output

#### Example 1  
**Input:**
```
Enter number: 1A
Enter base (2-36): 16
```
**Output:**
```
26
```

#### Example 2  
**Input:**
```
Enter number: 1101
Enter base (2-36): 2
```
**Output:**
```
13
```

#### Example 3  
**Input:**
```
Enter number: Z
Enter base (2-36): 36
```
**Output:**
```
35
```

---

### Constraints
- Input number will only contain valid characters for the given base.
- Base must be between `2` and `36` inclusive.
- Case-insensitive (e.g., `A` and `a` are both treated as 10 in base 16).

---

### 🚀 Challenge  
Don't use `Integer.parseInt(String s, int radix)` or `BigInteger(String val, int radix)` methods. Implement the logic manually.
