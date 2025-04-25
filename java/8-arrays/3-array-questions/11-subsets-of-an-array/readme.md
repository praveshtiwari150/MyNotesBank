## 🧩 Problem: Generate All Subsets of an Array Using Bit Manipulation

### Description

Given an array of integers, generate and print all possible subsets (also known as the power set) of the array. Each subset should be displayed on a new line, with elements separated by tabs (`\t`). If an element is not included in a particular subset, you may represent its position with a dash (`-`) or simply omit it, depending on your formatting preference.

### Input Format

- The first line contains an integer `n` — the number of elements in the array.
- The second line contains `n` space-separated integers — the elements of the array.

### Output Format

- Print all `2^n` subsets of the array, each on a new line.
- Each subset should display the included elements in their original order, separated by tabs (`\t`).
- For positions where elements are excluded, you may use a dash (`-`) or omit them, based on your chosen formatting.

### Constraints

- `1 ≤ n ≤ 10`
- `-10^9 ≤ arr[i] ≤ 10^9`

### Sample Input
```
3
1 2 3
```

### Sample Output
```
-	-	-
-	-	3
-	2	-
-	2	3
1	-	-
1	-	3
1	2	-
1	2	3
```

### Explanation

The array `[1, 2, 3]` has `2^3 = 8` possible subsets. Each subset corresponds to a binary number from `0` to `7`:

- `000`: All elements excluded → `-	-	-`
- `001`: Only 3 included → `-	-	3`
- `010`: Only 2 included → `-	2	-`
- `011`: 2 and 3 included → `-	2	3`
- `100`: Only 1 included → `1	-	-`
- `101`: 1 and 3 included → `1	-	3`
- `110`: 1 and 2 included → `1	2	-`
- `111`: All elements included → `1	2	3`

Each bit in the binary representation indicates whether to include (`1`) or exclude (`0`) the corresponding element from the array.

### Note

This problem utilizes bit manipulation to efficiently generate all subsets of a set. For each number from `0` to `2^n - 1`, its binary representation determines which elements are included in the corresponding subset. This approach is efficient and commonly used in problems involving subsets and combinations.

For further reading and alternative approaches, you may refer to the following resources:

- [Print all subsets of a given Set or Array | GeeksforGeeks](https://www.geeksforgeeks.org/backtracking-to-find-all-subsets/)
- [Fun With Bits: Print all subsets of a set - HackerEarth](https://www.hackerearth.com/practice/notes/fun-with-bits-print-all-subsets-of-a-set/)

--- 