# Primality Testing Using the Square Root Method

## Key Principles of Prime Number Testing

A prime number is a natural number greater than 1 that is divisible only by 1 and itself. We can efficiently test if a number is prime using the square root property.

## Mathematical Foundation

Let's consider a number n and its possible factorization:
- If n is composite (not prime), it can be written as n = p × q where p and q are integers greater than 1
- For any such factorization, at least one of the factors must be ≤ √n

### Proof

1. Assume n = p × q where both p > √n and q > √n
2. This would mean p × q > √n × √n = n
3. But this contradicts our original statement that p × q = n
4. Therefore, at least one factor must be ≤ √n

## Practical Application

To determine if a number n is prime:
1. Test divisibility of n by all integers from 2 to √n
2. If none of these numbers divides n evenly, then n is prime
3. If any number in this range divides n, then n is composite

## Example

To test if 37 is prime:
- √37 ≈ 6.08
- Check divisibility by: 2, 3, 4, 5, 6
- None of these divide 37 evenly
- Therefore, 37 is prime

## Conclusion

This approach significantly reduces the computational effort required for primality testing. Instead of checking all numbers from 2 to n-1, we only need to check up to √n, which is a much smaller range, especially for large numbers.