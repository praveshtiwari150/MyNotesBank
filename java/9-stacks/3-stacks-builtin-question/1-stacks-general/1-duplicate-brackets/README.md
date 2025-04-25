```md
# Duplicate Brackets  

## Problem Statement  
You are given a mathematical expression as a string that consists of **balanced** parentheses, operators, and operands. Your task is to determine if the given expression contains **duplicate brackets**. Duplicate brackets exist if a **pair of brackets** contains **no operator or operand between them**.  

## Input Format  
- A single string containing the expression. The expression is **guaranteed** to have balanced parentheses.  

## Output Format  
- Print **"true"** if the expression contains duplicate brackets.  
- Otherwise, print **"false"**.  

## Constraints  
- **1 ≤ |expression| ≤ 100**  
- The expression contains **only** parentheses `()`, operators `+`, `-`, `*`, `/`, and single-character operands (e.g., `a, b, c`).  

## Example  
### **Input 1:**  
```
((a + b) + ((c + d)))
```  
### **Output 1:**  
```
true
```  
### **Input 2:**  
```
(a + (b * c))
```  
### **Output 2:**  
```
false
```  
### **Input 3:**  
```
((a + b))
```  
### **Output 3:**  
```
true
```  

## Hints  
- Use a **stack** to track opening and closing brackets.  
- If you encounter a `')'`, check if the top of the stack contains another `'('` right after it.  
- If yes, then **duplicate brackets** exist.  
- Otherwise, pop elements until `'('` is found.  
```