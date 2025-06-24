Sure — here’s a clean and precise **problem statement** for your code:

---

## 📖 Problem Statement: Linked List-based Stack Adapter

### 💡 Objective:
Design a **Stack Adapter** class using a Java `LinkedList` that simulates stack operations. Implement a console-based interactive program to perform stack operations based on user input.

---

### 📚 Description:
You are required to implement a class called `LLToStackAdapter` which internally uses Java's `LinkedList` to mimic the behavior of a stack. The stack follows the **Last In First Out (LIFO)** principle.

The program should accept the following commands from the user via standard input:

- `push <value>` → Push an integer value onto the stack.
- `pop` → Remove and print the top element of the stack. If the stack is empty, print `"Stack underflow"` and return `-1`.
- `top` → Print the top element of the stack without removing it. If the stack is empty, print `"Stack underflow"` and return `-1`.
- `size` → Print the current number of elements in the stack.
- `quit` → Exit the program.

---

### 📑 Input Format:
- Each command will be provided as a string on a new line.
- `push` command is followed by a space and an integer value.
- The sequence of commands ends when the user enters `quit`.

---

### 📤 Output Format:
- For `pop` and `top` commands, print the result (unless it’s underflow, then print `"Stack underflow"` and return `-1`).
- For `size` command, print the current size of the stack.
- No output is required for `push` or `quit`.

---

### 📌 Constraints:
- Operations are only for integer values.
- The number of commands is not limited but should end with `quit`.
- Perform operations in **O(1)** time complexity for `push`, `pop`, and `top`.

---

### 📊 Example:

#### Input:
```
push 10
push 20
push 30
top
pop
top
size
quit
```

#### Output:
```
30
30
20
2
```

---

### ✅ Expected Class and Methods:

```java
public class LLToStackAdapter {
    LLToStackAdapter();       // constructor
    int size();               // returns current stack size
    void push(int val);       // pushes value to stack
    int pop();                // removes and returns top, or -1 if empty
    int top();                // returns top, or -1 if empty
}
```

---