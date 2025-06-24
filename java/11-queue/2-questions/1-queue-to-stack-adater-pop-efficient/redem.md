Awesome — let’s carefully frame this problem for you. Here's a clean **problem statement** along with a **starter code template** for **Queue to Stack Adapter (Pop Efficient)** implementation.

---

## 📖 Problem Statement: Queue to Stack Adapter — Pop Efficient

You are required to create a **Stack** data structure by using the **Queue** data structure(s) and implement it in such a way that **pop()** and **top()** operations are efficient (i.e., in **O(1)** time), while **push()** operation takes linear time.

Implement the following operations:

* `push(int val)` — Adds an element to the stack.
* `pop()` — Removes and returns the top element of the stack. If the stack is empty, print "Stack underflow" and return `-1`.
* `top()` — Returns the top element of the stack without removing it. If the stack is empty, print "Stack underflow" and return `-1`.
* `size()` — Returns the number of elements present in the stack.

Use the `Queue` class from `java.util` package.

---

## 📥 Input Format:

* First line: `n`, number of operations.
* Next `n` lines: operations in the form:
  `"push x"`
  `"pop"`
  `"top"`
  `"size"`

---

## 📤 Output Format:

* Output of each `pop()`, `top()`, and `size()` operation on a new line.

---

## 📌 Example:

### Input

```
8
push 10
push 20
push 30
top
pop
top
size
pop
```

### Output

```
30
30
20
2
20
```

---
