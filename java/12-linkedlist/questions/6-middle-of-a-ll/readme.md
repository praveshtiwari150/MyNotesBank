## 📖 Problem Statement: Find Middle Element of a Linked List

### 💡 Objective:
Given a singly linked list, write a program in Java to find and print the **middle element** of the linked list.

---

### 📚 Description:
You need to implement a method that returns the middle element of a linked list.  
If the number of elements is even, return the **second middle element**.  
Use the efficient **slow and fast pointer approach** to solve the problem in a single traversal.

---

### 📑 Input Format:
- The first line contains an integer `n`, the number of elements in the linked list.
- The next `n` lines contain the integer values of the linked list nodes.

---

### 📤 Output Format:
- Print the middle element of the linked list.

---

### 📌 Constraints:
- `1 ≤ n ≤ 10^5`
- All node values are integers.

---

### 📊 Example:

#### Input:
```
5
10
20
30
40
50
```

#### Output:
```
30
```

---

#### Input:
```
6
10
20
30
40
50
60
```

#### Output:
```
40
```

---

### ✅ Explanation:
- In the first case, the middle element is `30`.
- In the second case, elements are `10 20 30 40 50 60`, so middle elements are `30` and `40`.  
  As per the problem, we consider the **second middle element**, which is `40`.

---

### 📌 Expected Class and Methods:

```java
public class LinkedList {
    private class Node {
        int data;
        Node next;
    }

    void addLast(int val);       // Adds a node to the end
    void display();              // Displays the list
    int findMiddle();            // Returns the middle element
}
```

---

### 📌 Approach Hint:
- Use **two pointers (slow and fast)**:
  - Move `fast` pointer 2 steps at a time and `slow` pointer 1 step at a time.
  - When `fast` reaches the end of the list, `slow` will be at the middle.

---