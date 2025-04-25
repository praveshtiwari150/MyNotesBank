### ❓ Balanced Brackets Problem

🛠️ Given a string containing only the characters `{`, `}`, `(`, `)`, `[` and `]`, determine whether the input string is **balanced**. A string is considered balanced if:

1️⃣ Every opening bracket has a corresponding **closing bracket**.  
2️⃣ Brackets are closed in the **correct order** (e.g., `{[()]}` is valid but `{[(])}` is not).  

---

## ✅ Input Format  

- A single string `s` consisting of `{`, `}`, `(`, `)`, `[` and `]`.

## ✅ Output Format  

- Print `YES` if the string is balanced.  
- Print `NO` if the string is not balanced.  

---

## ✅ Constraints  

- `1 ≤ |s| ≤ 10^5` (Length of the string)  
- The input string contains only `{`, `}`, `(`, `)`, `[` and `]`.  

---

## ✅ Example  

### 🔹 Example 1  

**Input:**  
```
{[()]}
```
**Output:**  
```
YES
```
**Explanation:**  
All brackets are properly nested.

---

### 🔹 Example 2  

**Input:**  
```
{[(])}
```
**Output:**  
```
NO
```
**Explanation:**  
The brackets `[` and `]` are not closed in the correct order.

---

### 🔹 Example 3  

**Input:**  
```
{{[[(())]]}}
```
**Output:**  
```
YES
```
**Explanation:**  
All brackets are correctly nested and balanced.

---

> 💡 **Note:** You must implement an efficient approach (O(n) time complexity) to check for balanced brackets, as `|s|` can be large.
