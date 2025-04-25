### **Problem Statement: Largest Rectangle in Histogram**  

#### **Question:**  
You are given an array `heights` of size `n`, where `heights[i]` represents the height of a bar in a histogram. The width of each bar is `1`.  

Find the **area of the largest rectangle** that can be formed within the histogram.  

#### **Example 1:**  
🔹 **Input:**  
```python
heights = [2,1,5,6,2,3]
```
🔹 **Output:**  
```
10
```
🔹 **Explanation:**  
The largest rectangle is formed by bars with height `5` and `6`, covering width `2`, so **5 × 2 = 10**.  

#### **Example 2:**  
🔹 **Input:**  
```python
heights = [2,4]
```
🔹 **Output:**  
```
4
```
🔹 **Explanation:**  
The largest rectangle is a single bar of height `4` with width `1`, so **4 × 1 = 4**.  

#### **Constraints:**  
- `1 ≤ n ≤ 10⁵`  
- `0 ≤ heights[i] ≤ 10⁴`  

#### **Follow-Up:**  
Can you solve this in **O(n)** time complexity instead of **O(n²)** brute force?