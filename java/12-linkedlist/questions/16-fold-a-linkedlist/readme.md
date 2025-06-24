
---

## 📄 Problem Statement: **Fold a Linked List**

**You are given a singly linked list of integers. You need to 'fold' the list from both ends towards the center.**

Folding means:

* The first node links to the last node,
* then the second node links to the second last node,
* then the third node links to the third last node, and so on,
  until the middle of the list is reached.

The relative order should follow this pattern:

```
Before Folding: 1 → 2 → 3 → 4 → 5 → 6 → 7
After Folding : 1 → 7 → 2 → 6 → 3 → 5 → 4
```

---

## 📌 Input Format:

* First line: Integer `N` — number of elements in the linked list.
* Second line: `N` space-separated integers — elements of the linked list.

## 📌 Output Format:

* Print the elements of the folded linked list in a single line, space-separated.

---

## 📌 Constraints:

* 1 ≤ N ≤ 10⁵
* -10⁹ ≤ value ≤ 10⁹

---

## 📌 Example:

**Input**

```
7
1 2 3 4 5 6 7
```

**Output**

```
1 7 2 6 3 5 4
```

---

## 📌 Explanation:

The list is folded from both ends towards the center as per the given pattern.

---

## 📦 Starter Code Template (Java)

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

        // ✅ Complete this method
        public void fold() {
            // Your code here
        }

        void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        LinkedList list = new LinkedList();

        for (int i = 0; i < n; i++) {
            list.addLast(sc.nextInt());
        }

        list.fold();
        list.display();
    }
}
```

---

## ✅ Notes:

* You need to implement the `fold()` function inside `LinkedList` class.
* You may use recursion or iterative pointer manipulation.
* Aim for **O(N)** time and **O(N)** space for recursion stack or **O(1)** if iterative.

---