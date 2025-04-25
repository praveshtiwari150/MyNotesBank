### **Minimum Stack 2 - Question**  

You need to **optimize the MinStack** implementation further by reducing **extra space usage** while maintaining **O(1) time complexity** for all operations.

#### **Requirements:**  
1. **push(int val)** – Pushes an integer `val` onto the stack.  
2. **pop()** – Removes and returns the top element of the stack. If the stack is empty, print `"Stack under flow"` and return `-1`.  
3. **top()** – Returns the top element without removing it. If the stack is empty, print `"Stack under flow"` and return `-1`.  
4. **min()** – Returns the minimum element present in the stack. If the stack is empty, print `"Stack under flow"` and return `-1`.  
5. **Optimized Space Complexity** – You **cannot use an extra stack** (`minData` from the previous version). Instead, store the minimum value efficiently within the stack itself.  

---

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
- **Time Complexity:** `O(1)` for `push()`, `pop()`, `top()`, and `min()`.  
- **Space Complexity:** **O(1)** (You cannot use an extra stack).  
- Your approach should work for **negative numbers** as well.  

---

### **Hint**  
- Instead of using a second stack, **store the minimum value cleverly in the existing stack.**  
- Consider using a **mathematical trick** or **modified push strategy** to track the minimum without extra space.  

---

Can you solve this **efficiently**? 🚀