### Question: Print Vertical Bar Chart of an Array

You are given an array of `n` non-negative integers.  
You need to print a **vertical bar chart** to represent the elements in the array.

Each bar's height is based on the value of the element, using `*` (star) to represent part of the bar.  
Empty spaces are shown using `_` (underscore) to align the output properly.  
The chart is printed from **top to bottom**, where the top row corresponds to the highest number in the array.

---

#### Input Format
- An integer `n`, representing the number of elements in the array  
- `n` space-separated integers representing the elements of the array

---

#### Output Format
- A vertical bar chart where each column corresponds to an element in the array.
- Each bar uses `*` to show filled levels and `_` for empty levels.
- Values are printed from top (max value) to bottom (1), row by row.
- Each value in a row is followed by a tab (`\t`) for alignment.

---

#### Constraints
- 1 ≤ n ≤ 100  
- 0 ≤ arr[i] ≤ 50

---

#### Sample Input
```
5
3 1 0 7 5
```

#### Sample Output
```
_	_	_	*	_	
_	_	_	*	_	
_	_	_	*	_	
*	_	_	*	*	
*	_	_	*	*	
*	_	_	*	*	
*	*	_	*	*	
```

---

#### Explanation
- Each column represents an element in the array.
- The tallest bar (value 7) decides the number of rows.
- A `*` is printed where the current level (from top to bottom) is less than or equal to the array element.
- An `_` is printed otherwise.
