**“Is Linked List a Palindrome”** with constraints, input/output format, notes, and examples.

---

## 📖 Problem Statement: Is Linked List a Palindrome?

You are given a singly linked list of integers. Your task is to determine whether the linked list represents a palindrome sequence or not.

A palindrome is a sequence that reads the same forwards and backwards.

---

## 📑 Input Format:

* The first line contains an integer `n` — the number of nodes in the linked list.
* The second line contains `n` space-separated integers — the elements of the linked list.

---

## 📑 Output Format:

* Print `true` if the linked list is a palindrome, otherwise print `false`.

---

## 📏 Constraints:

* 1 ≤ n ≤ 10⁴
* -10⁶ ≤ each element ≤ 10⁶

---

## ✳️ Note:

* You may not use extra space proportional to `n` (like an array or list).
* Aim for **O(n) time and O(1) extra space** solution (bonus for in-place techniques using linked list manipulation).

---

## 📚 Examples

### 📘 Example 1:

**Input**

```
5
1 2 3 2 1
```

**Output**

```
true
```

---

### 📘 Example 2:

**Input**

```
4
1 2 2 3
```

**Output**

```
false
```

---

### 📘 Example 3:

**Input**

```
1
7
```

**Output**

```
true
```

---

## 💡 Explanation:

In Example 1, the sequence `1 → 2 → 3 → 2 → 1` reads the same forwards and backwards, so it's a palindrome.

In Example 2, the sequence `1 → 2 → 2 → 3` is not a palindrome.

---

Awesome — here’s a clean, **contest-style starter template in Java** for
**"Is Linked List a Palindrome"** problem. It includes linked list structure, input handling, and a placeholder method where contestants can implement their logic.

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

        // ✅ You need to implement this method
        boolean isPalindrome() {
            // write your code here
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        LinkedList list = new LinkedList();

        for (int i = 0; i < n; i++) {
            list.addLast(sc.nextInt());
        }

        boolean result = list.isPalindrome();
        System.out.println(result);
    }
}
```

---

## 📌 Contest Instructions:

* Complete the `isPalindrome()` method inside the `LinkedList` class.
* You may use recursive or iterative approaches.
* Bonus if done in **O(n) time and O(1) extra space** by reversing the second half in-place.

---
