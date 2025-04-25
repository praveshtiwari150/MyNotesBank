# Reverse a Linked List (Data Iterative Approach)

## Problem Statement

Given a singly linked list, reverse the order of its elements by swapping the data of nodes iteratively from both ends towards the center. The structure of the linked list (i.e., the `next` pointers) should remain unchanged; only the data values should be swapped. Implement a method `reverseDI()` in a custom linked list class to achieve this.

You are provided with a basic singly linked list implementation in Java that includes:
- A `Node` class with `int data` and `Node next`.
- A `linkedlist` class with `head`, `tail`, and `size` fields.
- Methods like `addLast(int val)`, `display()`, and a helper `getNodeAt(int idx)` to access nodes by index.

Your task is to implement the `reverseDI()` method to reverse the data in the list.

### Function Signature
```java
public void reverseDI()
```

## Input
- A singly linked list with integer data values.
- The list can be empty, have one node, or multiple nodes.

## Output
- The same linked list with its data values reversed.
- The `head` and `tail` pointers should point to the same nodes as before, but their data should reflect the reversed order.

## Examples

### Example 1
**Input:**
```
List: 1 -> 4 -> 46
```
**Output:**
```
List: 46 -> 4 -> 1
```

### Example 2
**Input:**
```
List: 5
```
**Output:**
```
List: 5
```

### Example 3
**Input:**
```
List: (empty)
```
**Output:**
```
List: (empty)
```

### Example 4
**Input:**
```
List: 10 -> 20 -> 30 -> 40
```
**Output:**
```
List: 40 -> 30 -> 20 -> 10
```

## Constraints
- The linked list contains integers between `-10^9` and `10^9`.
- The size of the linked list is between 0 and 10^6.
- Time Complexity: O(n), where n is the number of nodes in the list.
- Space Complexity: O(1), excluding the space used by the list itself.

## Starter Code
```java
import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node next;
    }

    public static class linkedlist {
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

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        private Node getNodeAt(int idx) {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        }

        public void reverseDI() {
            // Your implementation here
        }
    }

    public static void main(String[] args) {
        linkedlist list = new linkedlist();
        list.addLast(1);
        list.addLast(4);
        list.addLast(46);
        System.out.println("Before:");
        list.display();
        list.reverseDI();
        System.out.println("After:");
        list.display();
    }
}
```

## Expected Output for Starter Code
```
Before:
1 4 46 
After:
46 4 1 
```

## Solution Approach
- Use two pointers: one starting from the left (`li = 0`) and one from the right (`ri = size - 1`).
- While `li < ri`, swap the data of the nodes at `li` and `ri` using the `getNodeAt` helper method.
- Increment `li` and decrement `ri` until they meet or cross.
- Handle edge cases (empty list or single node) implicitly, as no swaps are needed.

## Notes
- This is a data reversal approach. If you need to reverse the linked list by changing the `next` pointers (structural reversal), please specify, and the question can be adjusted accordingly.
- Ensure your implementation maintains the O(n) time complexity and O(1) extra space requirement.
```

