# Finding the Inverse of a Number

## Problem Statement
Given a positive integer that contains unique digits, find its "inverse number". The inverse of a number is defined as the number created by interchanging the face value and index of each digit in the original number.

For a digit at position `i` with value `v`, in the inverse number, the digit at position `v` will be `i`.

**Note:** Positions are counted from right to left, starting with position 1 (not 0).

## Requirements
1. Write a function that takes a positive integer `n` and returns its inverse.
2. The input number will contain unique digits (no repeated digits).
3. For a valid inverse to exist, if a digit `d` appears in the number, then the position `d` must be within the range of the number's length.

## Examples
```
Input: n = 24153
Output: 24153
Explanation: 
- The digit 3 is at position 1, so in the inverse, position 3 gets the digit 1
- The digit 5 is at position 2, so in the inverse, position 5 gets the digit 2
- The digit 1 is at position 3, so in the inverse, position 1 gets the digit 3
- The digit 4 is at position 4, so in the inverse, position 4 gets the digit 4
- The digit 2 is at position 5, so in the inverse, position 2 gets the digit 5
So the inverse is 32415, which when read from left to right is 24153.

Input: n = 2134
Output: 1243
Explanation:
- The digit 4 is at position 1, so in the inverse, position 4 gets the digit 1
- The digit 3 is at position 2, so in the inverse, position 3 gets the digit 2
- The digit 1 is at position 3, so in the inverse, position 1 gets the digit 3
- The digit 2 is at position 4, so in the inverse, position 2 gets the digit 4
So the inverse is 3421, which when read from left to right is 1243.
```

## Constraints
- 1 ≤ n ≤ 10^9
- If n is a k-digit number, it will contain all digits from 1 to k without missing any and without repetition.

## Follow-up Questions
1. Can a number be its own inverse? If yes, find an example.
2. For a number with digits 1 to n, how many different numbers can be their own inverse?