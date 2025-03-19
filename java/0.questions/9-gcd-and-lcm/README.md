# GCD and LCM Problem

## Problem Statement

You are given two positive integers `a` and `b`. Write a function to find both the Greatest Common Divisor (GCD) and the Least Common Multiple (LCM) of these two numbers.

The GCD of two integers is the largest positive integer that divides both numbers without a remainder.

The LCM of two integers is the smallest positive integer that is divisible by both numbers.

## Examples

### Example 1:
```
Input: a = 12, b = 18
Output: GCD = 6, LCM = 36
Explanation: 
- The factors of 12 are 1, 2, 3, 4, 6, 12
- The factors of 18 are 1, 2, 3, 6, 9, 18
- The common factors are 1, 2, 3, 6, with 6 being the greatest
- LCM = (a * b) / GCD = (12 * 18) / 6 = 36
```

### Example 2:
```
Input: a = 35, b = 10
Output: GCD = 5, LCM = 70
Explanation:
- The factors of 35 are 1, 5, 7, 35
- The factors of 10 are 1, 2, 5, 10
- The common factors are 1, 5, with 5 being the greatest
- LCM = (35 * 10) / 5 = 70
```

### Example 3:
```
Input: a = 31, b = 17
Output: GCD = 1, LCM = 527
Explanation:
- 31 and 17 are both prime numbers
- Their only common factor is 1
- LCM = 31 * 17 = 527
```

## Constraints
- 1 ≤ a, b ≤ 10^9

## Follow-up Questions
1. Can you implement the GCD using the Euclidean algorithm?
2. How would you handle the case where one of the inputs is 0?
3. How would you extend your solution to find the GCD and LCM of more than two numbers?
4. Can you prove that LCM(a, b) = (a * b) / GCD(a, b)?

## Notes
- Remember that GCD and LCM are related by the formula: LCM(a, b) = (a * b) / GCD(a, b)
- Consider using the Euclidean algorithm for an efficient GCD calculation