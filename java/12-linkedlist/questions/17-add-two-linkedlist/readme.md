
---

## 📌 Problem Statement: Add Two Numbers Represented by Linked Lists

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list in the same reversed order.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

---

## ✳️ Example

**Example 1:**

```
Input:
l1 = [2, 4, 3]
l2 = [5, 6, 4]

Output:
[7, 0, 8]

Explanation:
342 + 465 = 807
```

---

**Example 2:**

```
Input:
l1 = [0]
l2 = [0]

Output:
[0]
```

---

**Example 3:**

```
Input:
l1 = [9, 9, 9, 9]
l2 = [9, 9, 9]

Output:
[8, 9, 9, 0, 1]

Explanation:
9999 + 999 = 10998
```

---

**Example 4:**

```
Input:
l1 = [1, 8]
l2 = [0]

Output:
[1, 8]

Explanation:
81 + 0 = 81
```

---

## ✳️ Constraints

* The number of nodes in each linked list is in the range \[1, 100].
* `0 <= Node.val <= 9`
* It is guaranteed that the list represents a number without leading zeros.

---

## 📦 Starter Code Template (Java)

```java
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Your logic here
        return null;
    }

    // Helper method to create linked list from array
    public static ListNode createLinkedList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print linked list
    public static void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1
        ListNode l1 = createLinkedList(new int[]{2, 4, 3});
        ListNode l2 = createLinkedList(new int[]{5, 6, 4});
        ListNode result = addTwoNumbers(l1, l2);
        printLinkedList(result);  // Expected: 7 -> 0 -> 8
    }
}
```

---

