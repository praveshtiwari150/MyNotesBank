
## 📖 Problem: Merge Two Sorted Linked Lists

**Problem Statement:**

You are given two sorted singly linked lists. Each list is implemented using a predefined `LinkedList` class that provides:

* A `Node` class with `int data` and `Node next`.
* A `head` pointer pointing to the first node of the list.
* An `addLast(int val)` method to add a node at the end of the list.
* A `display()` method to print the list elements.

Your task is to write a function `mergeTwoSortedLists` that merges the two sorted linked lists into a new sorted linked list in **non-decreasing order** and returns it.

---

### 📌 Function Signature:

```java
public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2)
```

---

### 📌 Input:

* `l1`: A sorted linked list.
* `l2`: A sorted linked list.

---

### 📌 Output:

* A new sorted linked list containing all the elements from `l1` and `l2` in non-decreasing order.

---

### 📌 Constraints:

* The linked lists may have different lengths.
* The linked lists may be empty.
* Do not modify the original linked lists; create a new list for the result.

---

## 📌 Examples

**Example 1**

**Input:**

```
List 1: 1 3 5 7  
List 2: 2 4 6 8
```

**Output:**

```
Merged List: 1 2 3 4 5 6 7 8
```

---

**Example 2**

**Input:**

```
List 1: 10 20 30  
List 2: 5 15 25 35
```

**Output:**

```
Merged List: 5 10 15 20 25 30 35
```

---

**Example 3**

**Input:**

```
List 1: (empty)  
List 2: 1 2 3
```

**Output:**

```
Merged List: 1 2 3
```