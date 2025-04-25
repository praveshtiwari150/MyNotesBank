## 🧮 Problem: Remove Prime Numbers from a List

### 📘 Description
You are given a list of integers. Your task is to remove all **prime numbers** from the list and print the remaining elements in the same order.

A **prime number** is a natural number greater than 1 that has no positive divisors other than 1 and itself.

### 🔢 Input Format
- The first line contains an integer `n` — the number of elements in the list.
- The second line contains `n` space-separated integers.

### 🖥️ Output Format
- Print the list after removing all prime numbers.
- Elements should be space-separated and printed in the original order (excluding the removed primes).

### 🚫 Constraints
- `1 <= n <= 1000`
- `-10^5 <= arr[i] <= 10^5`

### 🔍 Note
- Negative numbers and `0` or `1` are **not** considered prime.

### 🧪 Sample Input
```
6
2 4 5 6 7 9
```

### ✅ Sample Output
```
4 6 9
```

### 💡 Explanation
- The prime numbers in the list are `2`, `5`, and `7`.
- After removing them, the remaining list is `4 6 9`.