## 📖 Problem Statement: Linked List-based Queue Adapter

### 💡 Objective:
Design a **Queue Adapter** class using a Java `LinkedList` that simulates queue operations. Implement a console-based interactive program to perform queue operations based on user input.

---

### 📚 Description:
You are required to implement a class called `LLToQueueAdapter` which internally uses Java's `LinkedList` to mimic the behavior of a queue. The queue follows the **First In First Out (FIFO)** principle.

The program should accept the following commands from the user via standard input:

- `add <value>` → Add an integer value to the rear of the queue.
- `remove` → Remove and print the front element of the queue. If the queue is empty, print `"Queue underflow"` and return `-1`.
- `peek` → Print the front element of the queue without removing it. If the queue is empty, print `"Queue underflow"` and return `-1`.
- `size` → Print the current number of elements in the queue.
- `quit` → Exit the program.

---

### 📑 Input Format:
- Each command will be provided as a string on a new line.
- `add` command is followed by a space and an integer value.
- The sequence of commands ends when the user enters `quit`.

---

### 📤 Output Format:
- For `remove` and `peek` commands, print the result (unless it’s underflow, then print `"Queue underflow"` and return `-1`).
- For `size` command, print the current size of the queue.
- No output is required for `add` or `quit`.

---

### 📌 Constraints:
- Operations are only for integer values.
- The number of commands is not limited but should end with `quit`.
- Perform operations in **O(1)** time complexity for `add`, `remove`, and `peek`.

---

### 📊 Example:

#### Input:
```
add 10
add 20
add 30
peek
remove
peek
size
quit
```

#### Output:
```
10
10
20
2
```

---

### ✅ Expected Class and Methods:

```java
public class LLToQueueAdapter {
    LLToQueueAdapter();       // constructor
    int size();               // returns current queue size
    void add(int val);        // adds value to queue
    int remove();             // removes and returns front, or -1 if empty
    int peek();               // returns front, or -1 if empty
}
```

---