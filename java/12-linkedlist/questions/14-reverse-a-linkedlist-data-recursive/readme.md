
---

## 📖 Problem Statement: Reverse a Linked List (Data Recursive)

You are given a singly linked list of integers. Your task is to reverse the **data of the linked list nodes using recursion** (without changing the actual links/pointers between the nodes).

In other words, swap the values stored in the nodes so that the data appears in reverse order while the links remain as they are.

---

## 📑 Input Format:

* The first line contains an integer `n` — the number of nodes in the linked list.
* The second line contains `n` space-separated integers — the elements of the linked list.

---

## 📑 Output Format:

* Print the linked list elements after reversing the data, separated by spaces.

---

## 📏 Constraints:

* 1 ≤ n ≤ 10⁴
* -10⁶ ≤ each element ≤ 10⁶

---

## ✳️ Note:

You must reverse **the data using recursion** only. Do not modify the next pointers of the linked list.

---

## 📚 Examples

### 📘 Example 1:

**Input**

```
5
1 2 3 4 5
```

**Output**

```
5 4 3 2 1
```

---

### 📘 Example 2:

**Input**

```
3
7 11 19
```

**Output**

```
19 11 7
```

---

### 📘 Example 3:

**Input**

```
1
42
```

**Output**

```
42
```

---

## 💡 Explanation:

In Example 1, after reversing the data recursively:

* Original: 1 → 2 → 3 → 4 → 5
* After data reversal: 5 → 4 → 3 → 2 → 1

But links remain unchanged.

---

## 📦 Starting Code Template (Java)

```java
import java.util.*;

public class Main {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        // ✅ You need to implement this function
        void reverseDataRecursive() {
            // write your code here
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        LinkedList list = new LinkedList();

        for (int i = 0; i < n; i++) {
            list.addLast(sc.nextInt());
        }

        list.reverseDataRecursive();
        list.display();
    }
}
```

---

## 📌 Instructions for Contestants:

* Complete the `reverseDataRecursive()` method inside the `LinkedList` class.
* Do not modify the `next` pointers.
* Use recursion to swap data values only.
* After implementing, submit the full program.

---