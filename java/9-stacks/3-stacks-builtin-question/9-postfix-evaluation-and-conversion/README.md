### **Question: Postfix to Infix and Prefix Conversion**  

#### **Problem Statement:**  
Write a Java program that takes a **postfix expression** as input and converts it into:  
1. **Evaluated integer value**  
2. **Infix expression**  
3. **Prefix expression**  

Your program should correctly handle operators **(+ , -, *, /)** and single-digit operands **(0-9)**.  

#### **Example 1**  
**Input:**  
```
231*+9-
```  
**Output:**  
```
Value: -4
Infix: ((2+(3*1))-9)
Prefix: -+2*319
```  

#### **Example 2**  
**Input:**  
```
34+56*+
```  
**Output:**  
```
Value: 47
Infix: ((3+4)+(5*6))
Prefix: ++34*56
```  

#### **Constraints:**  
- The input expression will be a valid postfix expression containing only digits (0-9) and operators (+, -, *, /).  
- No spaces will be present in the input.  
- The evaluation will always result in an integer.  

#### **Hints:**  
- Use **stacks** to store operands and intermediate expressions.  
- For each **operator**, pop two operands from the stack, apply the operation, and push the result back.  
- Construct **infix** as `(operand1 operator operand2)`.  
- Construct **prefix** as `operator operand1 operand2`.