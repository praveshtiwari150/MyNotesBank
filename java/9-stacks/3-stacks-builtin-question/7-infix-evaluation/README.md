### **Question: Infix Expression Evaluation (Single-Digit Operands Only)**  

**Problem Statement:**  
You are given a mathematical expression in **infix notation**, which consists of **single-digit integers (0-9)** and the operators `+`, `-`, `*`, `/`, along with parentheses `()`. Your task is to evaluate the expression and return the computed result.  

**Constraints:**  
- The expression contains only **single-digit integers** (`0-9`) and the operators `+`, `-`, `*`, and `/`.  
- Division `/` is **integer division**, meaning it **truncates toward zero**.  
- The expression follows standard operator precedence:  
  - Multiplication (`*`) and division (`/`) have higher precedence than addition (`+`) and subtraction (`-`).  
  - Operators with the same precedence are evaluated **left to right**.  
  - Parentheses **override** operator precedence.  
- The input is guaranteed to be **a valid expression** (i.e., no division by zero or invalid syntax).  

---  

### **Examples**  

🔹 **Example 1**  
**Input:**  
```
"3 + 5 * 2"
```  
**Output:**  
```
13
```  
**Explanation:**  
Multiplication (`*`) has higher precedence than addition (`+`), so the expression evaluates as:  
`3 + (5 * 2) = 3 + 10 = 13`  

---  

🔹 **Example 2**  
**Input:**  
```
"(1 + 2) * 6"
```  
**Output:**  
```
18
```  
**Explanation:**  
Parentheses override precedence:  
`(1 + 2) * 6 = 3 * 6 = 18`  

---  

🔹 **Example 3**  
**Input:**  
```
"8 / 2 + 6"
```  
**Output:**  
```
10
```  
**Explanation:**  
Integer division first, then addition:  
`(8 / 2) + 6 = 4 + 6 = 10`  

---  

🔹 **Example 4**  
**Input:**  
```
"7 - 3 + 2"
```  
**Output:**  
```
6
```  
**Explanation:**  
Operators with the same precedence are evaluated **left to right**:  
`(7 - 3) + 2 = 4 + 2 = 6`  

---  

### **Follow-Up:**  
1. Implement the evaluation using **two stacks (operand stack & operator stack)**.  
2. Handle **spaces** between numbers/operators in the input.  
3. Extend your solution to handle **negative numbers** and **unary minus** (e.g., `-5 + 3`).  