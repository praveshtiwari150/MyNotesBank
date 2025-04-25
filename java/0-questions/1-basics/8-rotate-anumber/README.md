# Rotating a Number

## Problem Statement

Given a non-negative integer `n` and a rotation count `k`, write a function to rotate the digits of the number by `k` positions. If `k` is positive, rotate to the right. If `k` is negative, rotate to the left.

When rotating a number, the digits that rotate out from one end will rotate in at the other end, maintaining their original order.

## Examples

### Example 1:
```
Input: n = 12345, k = 2
Output: 45123
Explanation: Rotating 12345 to the right by 2 positions:
- First rotation: 51234
- Second rotation: 45123
```

### Example 2:
```
Input: n = 12345, k = -1
Output: 23451
Explanation: Rotating 12345 to the left by 1 position gives 23451
```

### Example 3:
```
Input: n = 12345, k = -3
Output: 45123
Explanation: Rotating 12345 to the left by 3 positions:
- First rotation: 23451
- Second rotation: 34512
- Third rotation: 45123
```

### Example 4:
```
Input: n = 12345, k = 5
Output: 12345
Explanation: Rotating by the length of the number returns the original number
```

### Example 5:
```
Input: n = 12345, k = 13
Output: 34512
Explanation: Since 13 % 5 = 3, this is equivalent to rotating right by 3 positions
```

## Constraints
- 0 ≤ n ≤ 10^9
- -10^9 ≤ k ≤ 10^9
- If n = 0, any rotation will result in 0

## Follow-up Questions
1. Can you solve it with O(1) extra space?
2. What if the number is very large and doesn't fit into standard integer types?
3. How would you handle leading zeros in the input number?

## Notes
- For the purpose of this problem, we're treating the number as a sequence of digits, not as a numerical value with place values.