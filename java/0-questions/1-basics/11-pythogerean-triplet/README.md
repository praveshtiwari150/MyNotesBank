# Finding Pythagorean Triplets

## Problem Statement

A Pythagorean triplet is a set of three positive integers a, b, and c that satisfy the equation:

a² + b² = c²

Given a positive integer n, write a function to determine if there exists a Pythagorean triplet where a, b, and c are all less than or equal to n. If such a triplet exists, return any one such triplet [a, b, c]. If no such triplet exists, return an empty array.

## Examples

### Example 1:
```
Input: n = 5
Output: [3, 4, 5]
Explanation: 3² + 4² = 9 + 16 = 25 = 5²
```

### Example 2:
```
Input: n = 10
Output: [3, 4, 5] or [6, 8, 10]
Explanation: Both are valid Pythagorean triplets. 3² + 4² = 5² and 6² + 8² = 10²
```

### Example 3:
```
Input: n = 2
Output: []
Explanation: There are no Pythagorean triplets with all values ≤ 2.
```

## Follow-up Questions

1. Can you find all Pythagorean triplets with values less than or equal to n?
2. How would you modify your solution to find a Pythagorean triplet where a + b + c = sum for a given sum?
3. Can you optimize your solution to run in O(n²) time?
4. Are there any mathematical properties or formulas that can help generate Pythagorean triplets efficiently?

## Constraints
- 1 ≤ n ≤ 10^4

## Notes
- A Pythagorean triplet is sometimes called a Pythagorean triple.
- The triplet should be returned in ascending order [a, b, c] where a ≤ b < c.
- Euclid's formula for generating Pythagorean triplets: For any two positive integers m and n with m > n, the triplet (m² - n², 2mn, m² + n²) forms a Pythagorean triplet.