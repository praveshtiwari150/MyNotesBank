### **Question:**  
Write a Java program that takes a **prefix expression** (Polish notation) as input and converts it into:  
1. **Evaluated numerical value**  
2. **Equivalent infix expression**  
3. **Equivalent postfix expression**  

Your program should read a prefix expression as a string, process it using **stacks**, and output the following:  
- The **evaluated result** of the expression  
- The **infix representation** (with parentheses for clarity)  
- The **postfix representation** (Reverse Polish Notation)

---

### **Example 1**  
#### **Input:**  
```
+9*26
```
#### **Output:**  
```
Value: 21
Infix: (9+(2*6))
Postfix: 926*+
```

---

### **Example 2**  
#### **Input:**  
```
-+7*45+20
```
#### **Output:**  
```
Value: 25
Infix: ((7+(4*5))-(2+0))
Postfix: 745*+20+-
```

---

### **Constraints:**  
- The input expression **only contains** single-digit integers (`0-9`) and operators (`+`, `-`, `*`, `/`).  
- The expression is **valid** and follows **prefix notation**.  
- The program must use **stacks** to process the expression.

---

### **Hints:**  
1. Use **three stacks**:
   - One for **evaluating** the expression (operands as integers).
   - One for **building the infix expression**.
   - One for **building the postfix expression**.
2. **Process the expression from right to left**.
3. If you encounter an **operator**, pop two operands from each stack, apply the operation, and push back the result.  
4. If you encounter an **operand**, push it onto all three stacks.

---

This problem will test your understanding of **prefix notation**, **stack-based evaluation**, and **expression conversion**. Happy coding! 🚀