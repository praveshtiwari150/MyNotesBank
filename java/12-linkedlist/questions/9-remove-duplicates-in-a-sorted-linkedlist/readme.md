
---

## 📄 Problem Statement: **Remove Duplicates from a Sorted Linked List**

You are given a sorted singly linked list that may contain duplicate values.
Your task is to implement the `removeDuplicates()` method in the provided `LinkedList` class, which removes **consecutive duplicate elements** from the list.

After calling this method, the linked list should contain only distinct elements, preserving the original order of first occurrences.

---

## 📦 Provided:

A `LinkedList` class with the following methods already implemented:

* `void addLast(int val)` → Adds a node with value `val` at the end of the list.
* `void display()` → Prints the list elements separated by a space.
* `int getFirst()`
* `int getLast()`
* `int getAt(int idx)`
* `void removeFirst()`
* `void removeLast()`
* `int size()`

---

## ✏️ You need to implement:

```java
public void removeDuplicates()
```

**Description:**
Removes consecutive duplicate elements from the linked list.

---

## 📥 Input Format:

* The first line contains an integer **N** — the number of elements to be added to the linked list.
* The second line contains **N** space-separated integers (sorted in non-decreasing order).
* Call `removeDuplicates()` method.
* Display the final linked list.

---

## 📤 Output Format:

* Print the linked list after removing duplicates.

---

## 📚 Sample Test Cases:

### ✅ Test Case 1:

**Input:**

```
9
1 1 2 3 3 4 5 5 5
```

**Output:**

```
1 2 3 4 5 
```

---

### ✅ Test Case 2:

**Input:**

```
4
5 5 5 5
```

**Output:**

```
5 
```

---

### ✅ Test Case 3:

**Input:**

```
6
1 2 3 4 5 6
```

**Output:**

```
1 2 3 4 5 6 
```

---

### ✅ Test Case 4:

**Input:**

```
1
10
```

**Output:**

```
10 
```

---

## 📌 Constraints:

* 1 ≤ N ≤ 1000
* 0 ≤ List element ≤ 10⁴
* The list is sorted in non-decreasing order.

---

## 📖 Note:

Only consecutive duplicates need to be removed since the list is sorted.

---

## ✅ Starter Code

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

        int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }

        int size() {
            return size;
        }

        public void removeDuplicates() {
            // implement this function
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        LinkedList list = new LinkedList();

        for (int i = 0; i < N; i++) {
            int val = sc.nextInt();
            list.addLast(val);
        }

        list.removeDuplicates();
        list.display();
    }
}
```

---

✅ No extra hints, no extra comments — just the `// implement this function` as you'd see in a real coding assessment.
