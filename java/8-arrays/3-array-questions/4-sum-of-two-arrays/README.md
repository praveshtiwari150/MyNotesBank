### Question: Sum of Two Arrays Representing Numbers

You are given two arrays where each array represents a number.  
The digits of the numbers are stored in the arrays **from left to right** (i.e., most significant digit first).  
Your task is to compute the sum of these two numbers and store the result in a new array.

The result should also be stored in an array, following the same format.

---

#### Input Format
1. An integer `n1`, the number of elements in the first array.
2. `n1` space-separated integers, representing the first number.
3. An integer `n2`, the number of elements in the second array.
4. `n2` space-separated integers, representing the second number.

---

#### Output Format
- An array representing the sum of the two numbers.

---

#### Constraints
- 1 ≤ n1, n2 ≤ 100  
- 0 ≤ arr[i] ≤ 9 (each digit is between 0 and 9)

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
1 4 2 1 8 6
```

---

#### Explanation
- The first array represents the number **31075**.
- The second array represents the number **111111**.
- Their sum is **142186**, which is stored in the output array `[1, 4, 2, 1, 8, 6]`.
