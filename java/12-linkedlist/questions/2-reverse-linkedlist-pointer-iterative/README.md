```markdown
# Reverse a Linked List (Pointer Iterative Approach)

## Problem Statement

Given a singly linked list, reverse the order of its nodes by iteratively updating the `next` pointers. The list should be structurally reversed such that the original tail becomes the new head and vice versa. Implement a method `reversePI()` in a custom linked list class.

### Function Signature
```java
public void reversePI()
```

## Input
- A singly linked list with integer data values.

## Output
- The same linked list with its nodes reversed structurally.

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
- Integers: `-10^9` to `10^9`
- Size: 0 to 10^6
- Time Complexity: O(n)
- Space Complexity: O(1)

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

        public void reversePI() {
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
        list.reversePI();
        System.out.println("After:");
        list.display();
    }
}
```

## Expected Output
```
Before:
1 4 46 
After:
46 4 1 
```
```