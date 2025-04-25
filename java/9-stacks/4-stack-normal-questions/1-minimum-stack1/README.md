### **Minimum Stack 1 - Question**  

You need to design a **MinStack** data structure that supports the following operations in **constant time (O(1))**:  

1. **push(int val)** – Pushes an integer `val` onto the stack.  
2. **pop()** – Removes and returns the top element of the stack. If the stack is empty, print `"Stack under flow"` and return `-1`.  
3. **top()** – Returns the top element without removing it. If the stack is empty, print `"Stack under flow"` and return `-1`.  
4. **min()** – Returns the minimum element present in the stack. If the stack is empty, print `"Stack under flow"` and return `-1`.  
5. **size()** – Returns the number of elements in the stack.  

### **Example**  

#### **Input:**
```java
MinStack minStack = new MinStack();
minStack.push(10);
minStack.push(20);
minStack.push(5);
System.out.println(minStack.min());  // Output: 5
System.out.println(minStack.pop());  // Output: 5
System.out.println(minStack.min());  // Output: 10
System.out.println(minStack.pop());  // Output: 20
System.out.println(minStack.pop());  // Output: 10
System.out.println(minStack.min());  // Output: Stack under flow, -1
```

#### **Constraints:**  
- You must implement the **min()** function in **O(1) time complexity**.  
- You **cannot** use sorting or iterate through the stack to find the minimum.  
- The stack should function correctly for multiple push and pop operations.  

Can you implement this efficiently? 🚀