### **Problem Statement: Sliding Window Maximum**  

#### **Question:**  
Given an array `nums` of size `n` and an integer `k`, find the **maximum value in each sliding window** of size `k` as it moves from left to right.  

#### **Example 1:**  
🔹 **Input:**  
```python
nums = [1,3,-1,-3,5,3,6,7]
k = 3
```
🔹 **Output:**  
```
[3, 3, 5, 5, 6, 7]
```
🔹 **Explanation:**  
The sliding windows and their maximums are:  
```
[1, 3, -1] → 3  
[3, -1, -3] → 3  
[-1, -3, 5] → 5  
[-3, 5, 3] → 5  
[5, 3, 6] → 6  
[3, 6, 7] → 7  
```

#### **Example 2:**  
🔹 **Input:**  
```python
nums = [9, 11, 8, 5, 7, 10]
k = 2
```
🔹 **Output:**  
```
[11, 11, 8, 7, 10]
```
🔹 **Explanation:**  
```
[9, 11] → 11  
[11, 8] → 11  
[8, 5] → 8  
[5, 7] → 7  
[7, 10] → 10  
```

#### **Constraints:**  
- `1 ≤ n ≤ 10⁵`  
- `-10⁴ ≤ nums[i] ≤ 10⁴`  
- `1 ≤ k ≤ n`  

#### **Follow-Up:**  
Can you solve this in **O(n) time complexity** instead of the brute-force **O(n*k)**? 🚀