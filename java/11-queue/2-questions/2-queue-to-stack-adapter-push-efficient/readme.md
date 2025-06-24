
---

## Problem: **Queue to Stack Adapter (Push Efficient)**

You are asked to implement a data structure **QueueToStackAdapter** which behaves like a **Stack** but is internally built using two **Queues**. Specifically, you need to implement a **push-efficient adapter**, where the `push` operation runs in **O(1)** time, while `pop` and `top` operations may take **O(n)** time.

Your task is to complete the following methods:

* **void push(int val)**: Pushes an integer `val` onto the stack.
* **int pop()**: Removes and returns the top element of the stack. If the stack is empty, return `-1`.
* **int top()**: Returns the top element of the stack without removing it. If the stack is empty, return `-1`.
* **int size()**: Returns the number of elements currently in the stack.

---

## Input

* The first line contains an integer `n` — the number of operations.
* The next `n` lines each contain a command:

  * `"push x"` — push the integer `x` onto the stack.
  * `"pop"` — pop the top element.
  * `"top"` — get the top element.
  * `"size"` — get the current size of the stack.

---

## Output

For each `"pop"`, `"top"`, and `"size"` operation, print the result on a new line.

---

## Constraints

* `1 ≤ n ≤ 10^4`
* `-10^9 ≤ x ≤ 10^9`

---

## Example 1

**Input**

```
6
push 10
push 20
top
size
pop
top
```

**Output**

```
20
2
20
10
```

---

## Example 2

**Input**

```
4
pop
top
push 5
top
```

**Output**

```
-1
-1
5
```

---

## Example 3

**Input**

```
5
push 7
push 9
push 3
size
pop
```

**Output**

```
3
3
```

---

## Example 4

**Input**

```
8
push 15
push 25
push 35
pop
top
pop
top
size
```

**Output**

```
35
25
25
15
1
```

---

## Note

* You must make **push() efficient** (i.e., O(1) time complexity), and implement `pop()` and `top()` using the two queues.
* Use only the provided data members `mainQ` and `helperQ` in your solution.

---

