# Problem Statement: Sorting a Binary Array

## Objective

Given an array consisting solely of 0s and 1s, the task is to sort the array such that all 0s appear before all 1s.

## Input Format

- An integer `N`, representing the number of elements in the array.
- An array `arr` of `N` integers where each element is either 0 or 1.

## Output Format

- A sorted array where all 0s precede all 1s.

## Constraints

- 1 ≤ N ≤ 10^6
- Each element in `arr` is either 0 or 1.

## Example

**Input:**


```
N = 8
arr = [1, 0, 1, 1, 0, 0, 1, 0]
```


**Output:**


```
[0, 0, 0, 0, 1, 1, 1, 1]
```


**Explanation:**

The input array contains four 0s and four 1s. After sorting, all 0s are positioned before all 1s.

## Note

The sorting should be performed in-place with a time complexity of O(N) and a space complexity of O(1). 