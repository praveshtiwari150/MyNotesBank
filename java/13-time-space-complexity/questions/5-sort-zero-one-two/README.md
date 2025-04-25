# Problem Statement: Sort an Array of 0s, 1s, and 2s

## Objective

Given an array consisting solely of 0s, 1s, and 2s, the task is to sort the array in-place so that all 0s appear first, followed by all 1s, and then all 2s.

## Input Format

- An integer `N`, representing the number of elements in the array.
- An array `arr` of `N` integers where each element is either 0, 1, or 2.

## Output Format

- The array sorted in non-decreasing order.

## Constraints

- 1 ≤ N ≤ 10^6
- Each element in `arr` is either 0, 1, or 2.

## Example

**Input:**


```
N = 8
arr = [2, 0, 2, 1, 1, 0, 0, 1]
```


**Output:**


```
[0, 0, 0, 1, 1, 1, 2, 2]
```


**Explanation:**

The input array contains three 0s, three 1s, and two 2s. After sorting, all 0s are positioned first, followed by all 1s, and then all 2s.

## Note

The sorting should be performed in-place with a time complexity of O(N) and a space complexity of O(1). This problem is commonly known as the Dutch National Flag problem. citeturn0search1 