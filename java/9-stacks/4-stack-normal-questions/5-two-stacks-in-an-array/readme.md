
---

## Problem: Two Stacks in an Array

You need to implement two stacks using a single array of fixed size `n`.

* **Stack 1** grows from the beginning of the array (index 0) towards higher indices.
* **Stack 2** grows from the end of the array (index n-1) towards lower indices.

If at any point a push operation would cause the two stacks to overlap or exceed the array boundary, the push operation should be ignored.

You must support the following operations:

* `push1 x`: Push integer `x` onto Stack 1.
* `push2 x`: Push integer `x` onto Stack 2.
* `pop1`: Pop and print the top element of Stack 1. If Stack 1 is empty, print `-1`.
* `pop2`: Pop and print the top element of Stack 2. If Stack 2 is empty, print `-1`.

---

### Input

* The first line contains two integers `n` and `q` — the size of the array and the number of operations.
* The following `q` lines contain the operations in the formats described above.

---

### Output

For each `pop1` or `pop2` operation, print the popped element or `-1` if the stack is empty.

---

### Constraints

* `1 ≤ n, q ≤ 10^5`
* `-10^9 ≤ x ≤ 10^9`

---

### Examples

---

#### Example 1: Basic Push & Pop

**Input**

```
6 9
push1 5
push2 10
push1 15
pop1
push2 20
pop2
pop1
pop2
pop2
```

**Output**

```
15
20
5
10
-1
```

**Explanation**

* Stack 1: 5, 15
* Stack 2: 10, 20
* Pop operations remove elements in LIFO order.
* The last pop2 returns `-1` because Stack 2 is empty.

---

#### Example 2: Attempting to Overflow

**Input**

```
4 7
push1 1
push2 2
push1 3
push2 4
push1 5
pop1
pop2
```

**Output**

```
3
4
```

**Explanation**

* Array size is 4.
* After `push1 3` and `push2 4`, array is full.
* `push1 5` is ignored due to lack of space.
* Pops return top elements as expected.

---

#### Example 3: Popping from Empty Stacks

**Input**

```
5 6
pop1
push2 9
pop2
pop2
push1 4
pop1
```

**Output**

```
-1
9
-1
4
```

**Explanation**

* `pop1` on empty Stack 1 returns `-1`.
* `push2 9` followed by `pop2` returns 9.
* Another `pop2` returns `-1` because Stack 2 is empty.
* `push1 4` then `pop1` returns 4.

---

### Note

* Push operations that cause stack overlap or exceed capacity should be ignored (no effect, no output).
* Make sure to manage the stacks efficiently within the single array.

---

