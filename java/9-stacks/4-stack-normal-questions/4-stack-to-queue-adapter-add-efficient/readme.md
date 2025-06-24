
---

## Problem: Stack to Queue Adapter — Add Efficient

You are given a task to implement a **Queue** data structure using two **Stacks**. The implementation should be **add-efficient**, meaning that the **add (enqueue)** operation must run in **O(1)** time, while the **remove (dequeue)** and **peek** operations may run in **amortized O(n)** time.

Implement the following operations for the queue:

* **add(x)**: Add the integer `x` to the back of the queue.
* **remove()**: Remove and return the element at the front of the queue. If the queue is empty, return `-1`.
* **peek()**: Return the element at the front of the queue without removing it. If the queue is empty, return `-1`.
* **size()**: Return the number of elements currently in the queue.

---

### Input

* The first line contains an integer `n` — the number of operations.
* The next `n` lines each contain an operation in one of the following forms:

  * `"add x"` — add the integer `x` to the queue.
  * `"remove"` — remove the front element and print it.
  * `"peek"` — print the front element without removing it.
  * `"size"` — print the current size of the queue.

---

### Output

For each `"remove"`, `"peek"`, and `"size"` operation, print the result on a new line.

---

### Constraints

* `1 ≤ n ≤ 10^5`
* `-10^9 ≤ x ≤ 10^9`

---

### Example

**Input**

```
8
add 5
add 10
peek
remove
peek
size
remove
remove
```

**Output**

```
5
5
10
1
10
-1
```

---

### Explanation

* After adding 5 and 10, the front is 5.
* Removing the front returns 5.
* Now the front is 10.
* The size is 1.
* Removing again returns 10.
* The last remove returns -1 because the queue is empty.

---

### Note

* Your implementation must use two stacks internally.
* The **add** operation must be efficient (O(1)), while **remove** and **peek** may have higher complexity.
* Use only standard stack operations (`push`, `pop`, `peek`, `isEmpty`) for the stacks.

---