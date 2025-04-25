## 🔄 Java Programming Question: Convert Any Base to Any Base

### Problem Statement  
Write a Java program that converts a number from **one base to another**.  
You need to:
1. Accept a number as a string.
2. Accept the **source base** (from which to convert).
3. Accept the **target base** (to which to convert).

Then print the converted number in the **target base**.

---

### Example Input/Output

#### Example 1  
**Input:**
```
Enter number: 1A
Enter source base (2-36): 16
Enter target base (2-36): 10
```
**Output:**
```
26
```

#### Example 2  
**Input:**
```
Enter number: 1010
Enter source base (2-36): 2
Enter target base (2-36): 8
```
**Output:**
```
12
```

#### Example 3  
**Input:**
```
Enter number: Z
Enter source base (2-36): 36
Enter target base (2-36): 10
```
**Output:**
```
35
```

---

### Constraints
- Input number will be valid for the given source base.
- Both source and target bases will be between `2` and `36`.
- Case-insensitive (e.g., `A` and `a` are both treated as 10 in base 16).
- No built-in methods like `Integer.toString(num, base)` or `parseInt(str, base)` for the full conversion.

---

### 🚀 Challenge  
Implement your own logic to:
1. Convert from any base to decimal manually.
2. Then convert from decimal to the target base manually.

---

### Hint  
- Use `Character.digit(char ch, int radix)` to convert character to numeric value.
- Use modulo and division for base conversion.
