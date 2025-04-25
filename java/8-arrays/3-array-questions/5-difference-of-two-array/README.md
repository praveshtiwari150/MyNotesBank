### Question: Difference of Two Arrays Representing Numbers

You are given two arrays where each array represents a number.  
The digits of the numbers are stored in the arrays **from left to right** (i.e., most significant digit first).  
Your task is to compute the difference between these two numbers (`n2 - n1`) and store the result in a new array.

The result should also be stored in an array, following the same format.

---

#### Input Format
1. An integer `n1`, the number of elements in the first array.
2. `n1` space-separated integers, representing the first number.
3. An integer `n2`, the number of elements in the second array.
4. `n2` space-separated integers, representing the second number.

---

#### Output Format
- An array representing the difference of the two numbers (`n2 - n1`).

---

#### Constraints
- 1 ≤ n1, n2 ≤ 100  
- 0 ≤ arr[i] ≤ 9 (each digit is between 0 and 9)  
- **It is guaranteed that `n2` represents a greater number than `n1`** (no negative results).

---

#### Sample Input
```
5
3 1 0 7 5
6
1 1 1 1 1 1
```

#### Sample Output
```
8 0 0 3 6
```

---

#### Explanation
- The first array represents the number **31075**.
- The second array represents the number **111111**.
- Their difference is **80036**, which is stored in the output array `[8, 0, 0, 3, 6]`.
