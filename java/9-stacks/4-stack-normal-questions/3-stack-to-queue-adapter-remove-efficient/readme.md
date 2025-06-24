**Stack to Queue Adapter — Remove Efficient**.
I’ll include constraints, input-output format, explanation, and a couple of examples.

---

## 📑 Problem Statement: Stack to Queue Adapter — Remove Efficient

You have to implement a custom data structure called `StackToQueueAdapter` which behaves like a **Queue** but is internally built using two **Stacks**. Specifically, you need to implement a **remove-efficient adapter**, where the `remove` and `peek` operations run in **O(1) amortized time**, while `add` may take **O(n)** time.

Your task is to complete the following methods:

* **void add(int val)**: Adds an integer `val` to the back of the queue.
* **int remove()**: Removes and returns the front element of the queue. If the queue is empty, return `-1`.
* **int peek()**: Returns the front element of the queue without removing it. If the queue is empty, return `-1`.
* **int size()**: Returns the number of elements currently in the queue.

---

## 📥 Input

* The first line contains an integer `n` — the number of operations.
* The next `n` lines each contain a command:

  * `"add x"` — adds integer `x` to the queue.
  * `"remove"` — removes the front element.
  * `"peek"` — retrieves the front element.
  * `"size"` — retrieves the number of elements in the queue.

---

## 📤 Output

For each `"remove"`, `"peek"`, and `"size"` operation, print the result on a new line.

---

## 📊 Constraints

* `1 ≤ n ≤ 10^4`
* `-10^9 ≤ x ≤ 10^9`

---

## 📎 Example 1

**Input**

```
6
add 10
add 20
peek
size
remove
peek
```

**Output**

```
10
2
10
20
```

---

## 📎 Example 2

**Input**

```
4
remove
peek
add 5
peek
```

**Output**

```
-1
-1
5
```

---

## 📝 Note

* You must make **remove() efficient** (i.e., O(1) amortized), and implement `add()` using two stacks.
* Use only the provided data members `mainS` and `helperS` in your solution.

---