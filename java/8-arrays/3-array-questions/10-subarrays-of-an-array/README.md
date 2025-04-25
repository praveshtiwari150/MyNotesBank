## 🧩 Problem: Print All Contiguous Subarrays of an Array

### Description
Given an array of integers, print all possible **contiguous subarrays**. A subarray is a sequence of elements within the array that are contiguous and maintain the original order.

### Input Format
- The first line contains an integer `n` — the number of elements in the array.
- The second line contains `n` space-separated integers — the elements of the array.

### Output Format
- Print each contiguous subarray on a new line.
- Elements in a subarray should be separated by a tab character (`\t`).

### Constraints
- `1 ≤ n ≤ 1000`
- `-10^9 ≤ arr[i] ≤ 10^9`

### Sample Input
```
3
1 2 3
```

### Sample Output
```
1
1	2
1	2	3
2
2	3
3
```

### Explanation
The array `[1, 2, 3]` has the following contiguous subarrays:
- `[1]`
- `[1, 2]`
- `[1, 2, 3]`
- `[2]`
- `[2, 3]`
- `[3]`

Each subarray is printed on a new line with elements separated by tabs.

### Note
The total number of contiguous subarrays of an array with `n` elements is `n*(n+1)/2`.

--- 