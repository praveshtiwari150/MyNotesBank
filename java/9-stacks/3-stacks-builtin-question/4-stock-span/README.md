
### **Stock Span Problem**  

#### **Problem Statement**  
You are given an array of stock prices for `n` days. You need to compute the stock span for each day.  
The stock span of a stock’s price on a particular day is defined as the **number of days passed between the current day and the first day before today when the price was higher than today**.  

#### **Input Format**  
- An integer `n` (1 ≤ n ≤ 10^5) representing the number of days.  
- An array of `n` integers where each integer represents the stock price on a given day.  

#### **Output Format**  
- An array of `n` integers where each integer represents the stock span for that day.  

#### **Constraints**  
- 1 ≤ stock price ≤ 10^9  
- 1 ≤ n ≤ 10^5  

#### **Example**  

##### **Input**  
```
7  
100 80 60 70 60 75 85
```

##### **Output**  
```
1 1 1 2 1 4 6
```

#### **Explanation**  
- Day 1: Price = 100 → No previous day has a higher price → Span = **1**  
- Day 2: Price = 80 → No previous day has a higher price → Span = **1**  
- Day 3: Price = 60 → No previous day has a higher price → Span = **1**  
- Day 4: Price = 70 → First day before today with a higher price is **Day 2 (Price 80)** → Span = **2**  
- Day 5: Price = 60 → No previous day has a higher price → Span = **1**  
- Day 6: Price = 75 → First day before today with a higher price is **Day 4 (Price 70)** → Span = **4**  
- Day 7: Price = 85 → First day before today with a higher price is **Day 1 (Price 100)** → Span = **6**  

#### **Hint**  
- Use a **monotonic decreasing stack** to efficiently compute spans in O(n) time complexity.  
```