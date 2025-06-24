

## 📖 Question: Find the Celebrity

In a party of **N people**, a celebrity is defined as a person who:

* **Is known by everyone else**.
* **Knows no one** in the party.

You are given a **NxN matrix `arr`** where:

* `arr[i][j] == 1` means person `i` knows person `j`.
* `arr[i][j] == 0` means person `i` does not know person `j`.

**Find if there is a celebrity in the party.**
If there is one, print `Potential: X` where `X` is the index of the celebrity.
If there is no celebrity, print `none`.

---

### 📑 Input:

* An integer `N` representing the number of people.
* A NxN matrix `arr` with values 0 or 1.

---

### 📑 Output:

* Print the index of the potential celebrity in the format `Potential: X`
* Or print `none` if no celebrity exists.

---

### 📌 Constraints:

* `1 ≤ N ≤ 1000`

---

## 📊 Examples

### Example 1:

**Input:**

```
4
0 1 1 0
0 0 1 0
0 0 0 0
0 1 1 0
```

**Output:**

```
Potential: 2
```

---

### Example 2:

**Input:**

```
3
0 1 0
0 0 0
1 1 0
```

**Output:**

```
Potential: 1
```

---

### Example 3:

**Input:**

```
3
0 1 0
0 0 1
1 0 0
```

**Output:**

```
none
```

---

### Example 4:

**Input:**

```
2
0 0
0 0
```

**Output:**

```
none
```

---

## 📌 Explanation:

* In **Example 1**, person `2` is the celebrity as everyone knows `2`, and `2` knows no one.
* In **Example 2**, person `1` is the celebrity.
* In **Example 3**, no celebrity exists because no one satisfies both conditions.
* In **Example 4**, no one knows anyone in a 2-person group, so no celebrity.
