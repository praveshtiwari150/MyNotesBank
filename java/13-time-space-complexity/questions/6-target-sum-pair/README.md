**Target Sum Pair**

## Target Sum Pair

### Problem Statement

Given an array of integers and a target sum, write a function that finds all unique pairs of integers in the array whose sum equals the target sum. The function should print each pair in ascending order.

### Input

- An array of integers, `arr`.
- An integer, `target`, representing the target sum.

### Output

- For each unique pair of integers in `arr` that sum up to `target`, print the pair in ascending order, separated by a comma. Each pair should be printed on a new line.

### Constraints

- Each input will have at least two integers.
- The same element cannot be used twice to form a pair.
- If no such pair exists, the function should not produce any output.

### Example


```java
Input:
arr = {1, 5, 7, -1, 5}
target = 6

Output:
1, 5
1, 5
7, -1
```


**Explanation**:

- The pairs `(1, 5)`, `(1, 5)`, and `(7, -1)` each sum to the target value of 6.
- Note that the pair `(1, 5)` appears twice because the number `5` appears twice in the array.

**Note**: This problem is similar to the "Two Sum" problem commonly found in coding interviews, where the goal is to find two numbers in an array that add up to a specific target number. citeturn0search1 