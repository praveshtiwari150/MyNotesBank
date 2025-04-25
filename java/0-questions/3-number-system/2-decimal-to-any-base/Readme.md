## 🧠 Java Programming Question: Decimal to Any Base Converter

### Problem Statement  
Write a Java program that takes two inputs from the user:
1. A **decimal number** (base 10).
2. A **target base** (between 2 and 36).

The program should convert the decimal number into the given base and print the result.

---

### Example Input/Output

#### Example 1  
**Input:**
```
Enter decimal number: 255
Enter target base (2-36): 16
```
**Output:**
```
FF
```

#### Example 2  
**Input:**
```
Enter decimal number: 100
Enter target base (2-36): 2
```
**Output:**
```
1100100
```

#### Example 3  
**Input:**
```
Enter decimal number: 31
Enter target base (2-36): 8
```
**Output:**
```
37
```

---

### Constraints
- The decimal number should be a non-negative integer.
- The target base should be in the range `[2, 36]`.

---

### Hints
- You can use `Character.forDigit(int digit, int radix)` to convert numbers to characters for bases above 10.
- You may use a loop to repeatedly divide the number by the base and collect the remainders.

---

### 🚀 Challenge  
Don't use built-in methods like `Integer.toString(int num, int radix)` or `Integer.toBinaryString()` for the conversion. Implement the logic manually.
