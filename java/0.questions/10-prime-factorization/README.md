# Prime Factorization of a Number

## Problem Statement

Given a positive integer `n`, write a function to find its prime factorization.

The prime factorization of a number is the representation of the number as a product of its prime factors. Your function should return all prime factors in ascending order, with each factor repeated according to its multiplicity in the factorization.

## Examples

### Example 1:
```
Input: n = 12
Output: 2 2 3
Explanation: 12 = 2 × 2 × 3
```

### Example 2:
```
Input: n = 315
Output: 3 3 5 7
Explanation: 315 = 3 × 3 × 5 × 7
```

### Example 3:
```
Input: n = 1440
Output: 2 2 2 2 2 3 5
Explanation: 1440 = 2^5 × 3^1 × 5^1 = 2 × 2 × 2 × 2 × 2 × 3 × 5
```

### Example 4:
```
Input: n = 17
Output: 17
Explanation: 17 is a prime number, so its only prime factor is itself.
```

### Example 5:
```
Input: n = 1
Output: 
Explanation: 1 has no prime factors by definition.
```

## Constraints
- 1 ≤ n ≤ 10^9

## Follow-up Questions
1. What is the time complexity of your solution?
2. Can you optimize your solution for very large numbers?
3. How would you modify your solution to return the prime factors in the form of (prime, exponent) pairs?

## Notes
- A prime number is a natural number greater than 1 that is not divisible by any number other than 1 and itself.
- All prime factors of a number n (except the number itself if it's prime) are less than or equal to √n.


# Prime Factorization - The Intuitive Approach

## Intuition

The key insight for finding the prime factorization of a number is to work systematically from the smallest possible prime factor:

1. Start with the smallest prime number, which is 2.
2. Repeatedly divide the number by 2 as long as it's divisible (i.e., gives a remainder of 0).
3. Each time the number is divisible, record 2 as a prime factor.
4. Once the number is no longer divisible by 2, move to the next prime number (3).
5. Repeat the process with consecutive prime numbers (3, 5, 7, 11, 13, ...).
6. Continue until the remaining number becomes 1.

This approach works because:
- If a number is divisible by a smaller prime, we extract that factor completely before moving to larger primes
- Any composite (non-prime) factor would have already been broken down by its constituent primes
- We never need to check divisibility by composite numbers
- The process naturally finds prime factors in ascending order

## Example Walkthrough

Let's apply this intuition to find the prime factorization of 1440:

1. Start with the smallest prime: 2
   - 1440 ÷ 2 = 720 (divisible, so 2 is a factor)
   - 720 ÷ 2 = 360 (divisible, so 2 is a factor)
   - 360 ÷ 2 = 180 (divisible, so 2 is a factor)
   - 180 ÷ 2 = 90 (divisible, so 2 is a factor)
   - 90 ÷ 2 = 45 (divisible, so 2 is a factor)

2. 45 is not divisible by 2, so move to the next prime: 3
   - 45 ÷ 3 = 15 (divisible, so 3 is a factor)

3. 15 is not divisible by 3, so move to the next prime: 5
   - 15 ÷ 5 = 3 (divisible, so 5 is a factor)

4. 3 is not divisible by 5, so move to the next prime: 3 itself
   - 3 ÷ 3 = 1 (divisible, so 3 is a factor)

5. We've reached 1, so we're done.

The prime factorization of 1440 is: 2 × 2 × 2 × 2 × 2 × 3 × 5

Or written as: 2^5 × 3 × 5

## Optimization Note

We only need to check potential prime factors up to the square root of the current number. If we reach a point where our potential prime factor is greater than the square root of the remaining number and that number is not 1, then the remaining number must itself be prime.