Excellent — let’s create a clean problem statement and a starter code template for **displaying a linked list in reverse order using recursion**.

---

## 📖 Problem Statement:

**Title:** Display Linked List in Reverse (Recursive)

You are given a singly linked list. Your task is to display its elements in **reverse order** using **recursion**.

You **must not modify** the linked list structure or reverse it permanently — just display its elements in reverse by recursively traversing to the end and printing them on the way back.

---

## 📥 Input Format:

* First line: An integer `n` representing the number of elements in the linked list.
* Second line: `n` space-separated integers representing the elements of the linked list.

## 📤 Output Format:

* A single line containing the elements of the linked list in reverse order, separated by spaces.

---

## 📑 Constraints:

* 1 ≤ n ≤ 10⁴

---

## 🔍 Example

**Example 1**

```
Input:
5
10 20 30 40 50

Output:
50 40 30 20 10
```

**Example 2**

```
Input:
3
5 15 25

Output:
25 15 5
```

**Example 3**

```
Input:
1
99

Output:
99
```

**Example 4**

```
Input:
6
1 2 3 4 5 6

Output:
6 5 4 3 2 1
```

---

## 📦 Starter Code Template

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
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // 🔴 Write your solution here
        public void displayReverse() {
            displayReverseHelper(head);
            System.out.println();
        }

        private void displayReverseHelper(Node node) {
            // your code here
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        LinkedList ll = new LinkedList();
        for (int i = 0; i < n; i++) {
            ll.addLast(sc.nextInt());
        }

        ll.displayReverse();
    }
}
```

---

## ✅ Notes:

* Implement the `displayReverseHelper(Node node)` method using recursion to print values in reverse.
* Don't modify the linked list structure itself.
* Don’t add any additional data structures like stacks or arrays for storing elements — purely recursion.

---

Would you like a full solution implementation too, or leave it for practice? 🚀
