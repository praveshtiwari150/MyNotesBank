
---

## 📄 Problem Statement:

**Odd-Even Linked List Rearrangement**

You are given a singly linked list of integers. Your task is to rearrange the linked list such that all the **odd-valued elements** come first, followed by all the **even-valued elements**, while maintaining the relative order of elements within each group.

**Implement the `oddEven()` method in the `LinkedList` class to perform this operation.**

---

### 📌 Input Format:

* A series of integers added to the linked list using the `addLast(int val)` method.

---

### 📌 Output Format:

* After calling `oddEven()`, use the `display()` method to print the rearranged list in a single line, with each element separated by a space.

---

## 📚 Example Test Cases:

### 🔹 Test Case 1:

**Input:**

```
1 2 3 4 5 6
```

**Output:**

```
1 3 5 2 4 6
```

---

### 🔹 Test Case 2:

**Input:**

```
2 4 6 8
```

**Output:**

```
2 4 6 8
```

---

### 🔹 Test Case 3:

**Input:**

```
1 3 5 7
```

**Output:**

```
1 3 5 7
```

---

### 🔹 Test Case 4:

**Input:**

```
7 8 5 2 3 4 1
```

**Output:**

```
7 5 3 1 8 2 4
```

---

## 📦 Starter Code:

```java
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

        public void oddEven() {
            // Write your solution here
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Example Test Case
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

        System.out.print("Original List: ");
        list.display();

        // Call the method
        list.oddEven();

        System.out.print("After oddEven rearrangement: ");
        list.display();
    }
}
```

---


