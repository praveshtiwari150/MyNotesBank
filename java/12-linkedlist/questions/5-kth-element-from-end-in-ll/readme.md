
---

## 📖 Problem Statement: Find k-th Element from End in a Linked List

### 💡 Objective:
Given a singly linked list, write a program in Java to find and print the **k-th element from the end** of the list.

---

### 📚 Description:
You need to implement a method that, given a linked list and an integer `k`, returns the k-th element from the end of the list.  
If `k` is greater than the size of the list, print `"Invalid arguments"`.

You should use the **two-pointer (fast and slow)** approach to solve this problem in a single pass (without counting the total number of nodes first).

---

### 📑 Input Format:
- The first line contains an integer `n`, the number of elements in the linked list.
- The next `n` lines contain the integer values of the linked list nodes.
- The last line contains an integer `k`.

---

### 📤 Output Format:
- Print the k-th element from the end if it exists.
- If `k` is greater than the size of the linked list, print `"Invalid arguments"`.

---

### 📌 Constraints:
- `1 ≤ n ≤ 10^5`
- `1 ≤ k ≤ 10^5`
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
2
```

#### Output:
```
40
```

---

### ✅ Explanation:
- The linked list is: `10 → 20 → 30 → 40 → 50`
- The 2nd element from the end is `40`.

---

### ✅ Expected Class and Methods:

```java
public class LinkedList {
    private class Node {
        int data;
        Node next;
    }

    void addLast(int val);          // Adds a node to the end
    void display();                 // Displays the list
    int kthFromLast(int k);         // Returns the k-th element from end
}
```

### 📌 Approach Hint:
- Use **two pointers**:  
  - Move the `fast` pointer `k` steps ahead.  
  - Then move both `fast` and `slow` pointers one step at a time.  
  - When `fast` reaches the end, `slow` will be at the k-th node from the end.

---

