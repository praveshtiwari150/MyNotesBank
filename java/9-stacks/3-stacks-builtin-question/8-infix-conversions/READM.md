Here’s a **coding question** based on your provided Java code for **infix to postfix and prefix conversion**:

---

### **Question: Convert Infix Expression to Postfix and Prefix Using Stacks**

#### **Problem Statement**  
You are given a valid **mathematical expression** in **infix notation** containing:  
- **Single-character operands** (like `a`, `b`, `c`, … or `A`, `B`, `C`, …).  
- The **operators** `+`, `-`, `*`, and `/` which follow standard operator precedence:  
  - Multiplication (`*`) and division (`/`) have **higher precedence** than addition (`+`) and subtraction (`-`).
  - Operators with **equal precedence** are evaluated **left to right**.
  - **Parentheses** `()` can be used to explicitly define precedence.  

Your task is to **convert the given infix expression** into:  
1. **Postfix notation** (Reverse Polish Notation, RPN).  
2. **Prefix notation** (Polish Notation, PN).  

---

#### **Input Format**  
- A **single line** containing a valid **infix expression** consisting of:  
  - **Operands**: Lowercase/uppercase English letters (`a-z, A-Z`).  
  - **Operators**: `+`, `-`, `*`, `/`.  
  - **Parentheses**: `(` and `)`.  
- **No spaces** will be present in the input.  

---

#### **Output Format**  
- Print **two lines**:  
  1. The **prefix expression**.  
  2. The **postfix expression**.  

---

#### **Constraints**  
- The given infix expression is **guaranteed to be valid**.  
- The expression contains **only single-character operands**.  
- The length of the expression will not exceed **100** characters.  

---

### **Example 1**  

#### **Input:**  
```
a+(b-c)*d+r/2-c
```

#### **Output:**  
```
Prefix: +a-*bcd-/r2c
Postfix: abc-d*+r2/c-
```

---

### **Example 2**  

#### **Input:**  
```
(a+b)*(c/d)```

#### **Output:**  
```
Prefix: *+ab/cd
Postfix: ab+cd/*
```

---

### **Follow-Up Enhancements:**  
1. Modify your code to **handle multi-digit numbers** instead of just single-character operands.  
2. Allow spaces in the input and handle them properly while parsing.  
3. Extend your implementation to **evaluate** both prefix and postfix expressions after conversion.  

---

### **Hints for Implementation:**  
- **Use two stacks:**  
  - One for **operands** (`postfix` and `prefix` stacks).  
  - One for **operators** (`ops` stack).  
- **Follow operator precedence rules** while pushing and popping from stacks.  
- **Process parentheses carefully**, ensuring sub-expressions are handled before moving forward.  
- **After scanning the entire input**, make sure to process any remaining operators.  

---

This question directly aligns with your code. By solving this, you’ll **reinforce your understanding** of infix to postfix/prefix conversion while practicing **stack-based algorithms** in Java. 🚀 Let me know if you need hints or explanations!