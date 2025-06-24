
---

## 📖 Problem Statement:

**Title:** K-Reverse a Linked List

You are given a singly linked list and a positive integer `k`. Your task is to reverse the nodes of the list in groups of size `k`.
If the number of nodes in the last group is less than `k`, leave them as-is.

Implement a method `kReverse(int k)` in the `LinkedList` class to perform this operation.

---

## 📥 Input Format:

* First line: An integer `n` representing the number of elements in the linked list.
* Second line: `n` space-separated integers representing the elements of the linked list.
* Third line: An integer `k` representing the group size for reversal.

## 📤 Output Format:

* The linked list after performing k-group reversals.

---

## 📑 Constraints:

* 1 ≤ n ≤ 10⁴
* 1 ≤ k ≤ n

---

## 🔍 Example

**Example 1**

```
Input:
9
1 2 3 4 5 6 7 8 9
3

Output:
3 2 1 6 5 4 9 8 7
```

**Example 2**

```
Input:
5
10 20 30 40 50
2

Output:
20 10 40 30 50
```

**Example 3**

```
Input:
7
5 15 25 35 45 55 65
4

Output:
35 25 15 5 55 45 65
```

**Example 4**

```
Input:
3
11 22 33
5

Output:
11 22 33
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

        int removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (size == 1) {
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            } else {
                int val = head.data;
                head = head.next;
                size--;
                return val;
            }
        }

        int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        // 🔴 Write your solution here
        public void kReverse(int k) {
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

        int k = sc.nextInt();

        ll.kReverse(k);
        ll.display();
    }
}
```

---

## ✅ Notes:

* The `LinkedList` class is ready for use.
* You only need to implement the `kReverse` method as per the problem statement.
* Don't change other parts of the code.

---