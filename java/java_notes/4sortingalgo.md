# Sorting Algorithms

Sorting algorithms are used to rearrange a given array or list elements in a specified order, typically ascending or descending. Below are some of the most common sorting algorithms, their working principles, and their time complexities.

## 1. Bubble Sort
### Description:
Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order. This process is repeated until the array is sorted.

### Algorithm:
1. Iterate through the array.
2. Compare adjacent elements and swap if necessary.
3. Repeat the process for each element until no swaps are needed.

### Time Complexity:
- **Best Case (Already Sorted):** O(n)
- **Average Case:** O(n²)
- **Worst Case (Reversed Order):** O(n²)

---

## 2. Selection Sort
### Description:
Selection Sort divides the array into sorted and unsorted parts. It repeatedly finds the minimum element from the unsorted section and swaps it with the leftmost unsorted element.

### Algorithm:
1. Find the minimum element in the unsorted portion.
2. Swap it with the first unsorted element.
3. Move the boundary of the sorted section one step right.
4. Repeat until the entire array is sorted.

### Time Complexity:
- **Best Case:** O(n²)
- **Average Case:** O(n²)
- **Worst Case:** O(n²)

---

## 3. Insertion Sort
### Description:
Insertion Sort builds the sorted array one element at a time by picking the next element and placing it in the correct position.

### Algorithm:
1. Start with the second element and compare it with the first.
2. Insert it into the correct position.
3. Repeat for all remaining elements.

### Time Complexity:
- **Best Case (Already Sorted):** O(n)
- **Average Case:** O(n²)
- **Worst Case (Reversed Order):** O(n²)

---

## 4. Merge Sort
### Description:
Merge Sort follows the divide and conquer approach. It recursively splits the array into halves, sorts them, and then merges the sorted halves.

### Algorithm:
1. Divide the array into two halves.
2. Recursively sort both halves.
3. Merge the sorted halves.

### Time Complexity:
- **Best Case:** O(n log n)
- **Average Case:** O(n log n)
- **Worst Case:** O(n log n)

---

## 5. Quick Sort
### Description:
Quick Sort selects a pivot element, partitions the array around the pivot, and recursively sorts the partitions.

### Algorithm:
1. Pick a pivot element.
2. Partition the array so that elements smaller than the pivot go left and larger ones go right.
3. Recursively apply the process to left and right subarrays.

### Time Complexity:
- **Best Case:** O(n log n)
- **Average Case:** O(n log n)
- **Worst Case (When pivot is smallest or largest element):** O(n²)

---

## 6. Heap Sort
### Description:
Heap Sort builds a binary heap from the array and extracts the largest element iteratively to get a sorted array.

### Algorithm:
1. Build a max heap.
2. Swap the root with the last element and reduce heap size.
3. Heapify the root.
4. Repeat until sorted.

### Time Complexity:
- **Best Case:** O(n log n)
- **Average Case:** O(n log n)
- **Worst Case:** O(n log n)

---

## 7. Counting Sort (For Small Integer Ranges)
### Description:
Counting Sort works by counting the frequency of each element and placing them in the correct order.

### Algorithm:
1. Count occurrences of each element.
2. Compute the prefix sum of counts.
3. Place elements in their correct position using the count array.

### Time Complexity:
- **Best Case:** O(n + k)
- **Average Case:** O(n + k)
- **Worst Case:** O(n + k)  
Where `k` is the range of input values.

---

## 8. Radix Sort (For Numbers and Strings)
### Description:
Radix Sort processes elements digit by digit using a stable sorting algorithm (e.g., Counting Sort).

### Algorithm:
1. Start with the least significant digit.
2. Sort numbers based on the current digit.
3. Move to the next digit and repeat until all digits are processed.

### Time Complexity:
- **Best Case:** O(nk)
- **Average Case:** O(nk)
- **Worst Case:** O(nk)  
Where `k` is the number of digits in the largest number.

---

## Conclusion
- **For small arrays:** Insertion Sort or Selection Sort can be useful.
- **For large datasets:** Merge Sort or Quick Sort is preferred.
- **For nearly sorted data:** Insertion Sort is efficient.
- **For integer sorting in a limited range:** Counting Sort or Radix Sort works best.

Choosing the right sorting algorithm depends on the problem constraints, input size, and time complexity considerations.

## **Bubble Sort Algorithm**
Bubble Sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The process is repeated until the list is sorted.

### **Working Principle**
1. Compare adjacent elements in the array.
2. Swap them if they are in the wrong order (i.e., the left element is greater than the right element).
3. Move to the next adjacent pair and repeat.
4. After one full pass, the largest element will be at the last position.
5. Repeat the process for the remaining elements until the entire array is sorted.

### **Time Complexity**
- **Best Case (Already Sorted):** \( O(n) \)
- **Worst Case (Reversed Order):** \( O(n^2) \)
- **Average Case:** \( O(n^2) \)

---

## **Basic Bubble Sort Implementation in Java**
```java
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        System.out.println("Original Array:");
        printArray(arr);

        bubbleSort(arr);
        
        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
```
### **Explanation:**
1. The **outer loop** runs \( n - 1 \) times because after each pass, the largest element is placed at its correct position.
2. The **inner loop** iterates from index `0` to `n - 1 - i` because after each pass, the largest elements are already sorted at the end.
3. Inside the inner loop, we compare adjacent elements and swap them if needed.

---

## **Optimized Bubble Sort (With Early Termination)**
A key optimization is to track whether any swaps were made in the inner loop. If no swaps occur in a pass, the array is already sorted, and we can terminate early.

```java
public class OptimizedBubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps occurred, the array is already sorted
            if (!swapped) break;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("Original Array:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
```
### **Why is this optimized?**
- If the array is **already sorted**, the algorithm will terminate in **O(n)** time instead of **O(n²)**.
- The `swapped` variable checks if any swaps occurred. If not, the loop stops early, improving efficiency.

---

## **Advantages and Disadvantages of Bubble Sort**
### **Advantages:**
✅ Simple and easy to implement.  
✅ Works well for nearly sorted data (**O(n) best case with optimization**).  

### **Disadvantages:**
❌ **Slow** for large datasets (**O(n²) time complexity**).  
❌ Not efficient compared to other sorting algorithms like **Quick Sort, Merge Sort, or Heap Sort**.  

---

## **Conclusion**
- Bubble Sort is a basic sorting algorithm, good for teaching purposes but inefficient for large datasets.
- The optimized version improves performance by terminating early if no swaps occur.
- For better efficiency, use **Merge Sort, Quick Sort, or Heap Sort** for larger datasets.

Sure! Here's a detailed explanation of **Selection Sort** in Java, including how it works, its time complexity, and a sample implementation.

---

## ✅ **What is Selection Sort?**

Selection Sort is a simple comparison-based sorting algorithm. It works by dividing the array into two parts:
- **Sorted part** (initially empty)
- **Unsorted part** (initially the whole array)

In each pass:
1. Find the **minimum element** from the unsorted part.
2. Swap it with the **first element** of the unsorted part.
3. Move the boundary of the sorted part one step forward.

---

## 🔄 **How Selection Sort Works (Step-by-step)**

Example:  
Input array: `[29, 10, 14, 37, 13]`

### Pass 1:
- Minimum in `[29, 10, 14, 37, 13]` → 10
- Swap 10 and 29 → `[10, 29, 14, 37, 13]`

### Pass 2:
- Minimum in `[29, 14, 37, 13]` → 13
- Swap 13 and 29 → `[10, 13, 14, 37, 29]`

### Pass 3:
- Minimum in `[14, 37, 29]` → 14 (already in correct place)

### Pass 4:
- Minimum in `[37, 29]` → 29
- Swap 29 and 37 → `[10, 13, 14, 29, 37]`

Sorted array ✅

---

## 🧠 **Time Complexity**
| Case         | Time        |
|--------------|-------------|
| Best Case    | O(n²)       |
| Average Case | O(n²)       |
| Worst Case   | O(n²)       |

### Space Complexity:  
- **O(1)** (in-place sorting)

---

## 🧑‍💻 **Java Code: Selection Sort**
```java
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the index of the minimum element
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {29, 10, 14, 37, 13};

        System.out.println("Original Array:");
        printArray(arr);

        selectionSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
```

---

## 📝 **Key Points**
- Selection Sort makes **fewer swaps** compared to Bubble Sort.
- It’s **not stable** (doesn’t preserve order of equal elements).
- Not suitable for large datasets due to **O(n²)** time.

---

# **Insertion Sort in Java – Detailed Explanation**
Insertion Sort is a simple and efficient sorting algorithm that works similarly to sorting playing cards in your hand. It builds the sorted array one element at a time by taking each element and inserting it into its correct position.

---

## ✅ **How Insertion Sort Works**
1. Assume the first element is already sorted.
2. Pick the next element.
3. Compare it with the elements in the sorted part.
4. Shift the larger elements to the right.
5. Insert the picked element at the correct position.
6. Repeat for all elements.

---

## 🔄 **Step-by-step Example**
Given array: `[9, 5, 1, 4, 3]`

| Pass | Current Element | Sorted Part Before Insert | Sorted Part After Insert |
|------|---------------|-------------------------|------------------------|
| 1    | 5            | `[9]`                    | `[5, 9]`                |
| 2    | 1            | `[5, 9]`                 | `[1, 5, 9]`             |
| 3    | 4            | `[1, 5, 9]`              | `[1, 4, 5, 9]`          |
| 4    | 3            | `[1, 4, 5, 9]`           | `[1, 3, 4, 5, 9]`       |

Sorted array ✅

---

## 🧠 **Time Complexity**
| Case         | Time Complexity |
|--------------|----------------|
| Best Case    | **O(n)** (Already sorted) |
| Average Case | **O(n²)** |
| Worst Case   | **O(n²)** (Reversed order) |

### **Space Complexity:**  
- **O(1)** (in-place sorting)

---

## 🧑‍💻 **Java Code: Insertion Sort**
```java
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Current element
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            // Insert key at its correct position
            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 1, 4, 3};

        System.out.println("Original Array:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
```

---

## 📝 **Key Points**
- **Best case runs in O(n) time** (if already sorted).
- **Stable sort** (preserves order of equal elements).
- **Efficient for small datasets**, but slow for large ones (**O(n²)**).

---

### **When to Use Insertion Sort?**
✅ When the array is **small** or **almost sorted**.  
❌ Avoid for large datasets (use **Merge Sort** or **Quick Sort** instead).  

---

Sure! Let's break down **Quick Sort** in Java with a beginner-friendly explanation, step-by-step logic, and code example.

---

### 📌 What is Quick Sort?

**Quick Sort** is a **divide-and-conquer** sorting algorithm that:
1. Picks a **pivot** element.
2. **Partitions** the array so that:
   - Elements **less than or equal to** the pivot go to the left,
   - Elements **greater** than the pivot go to the right.
3. **Recursively** applies the same process to the left and right parts.

---

### 🔁 How Quick Sort Works:
1. Choose a **pivot** (usually the last element).
2. Rearrange the array so:
   - All elements smaller than pivot go left,
   - All elements greater go right.
3. Recursively apply Quick Sort to subarrays.

---

### 🔧 Java Code for Quick Sort:

```java
public class QuickSort {

    // Helper function to swap elements
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Partition function
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivot is the last element
        int i = low - 1; // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high); // place pivot in correct position
        return i + 1; // return pivot index
    }

    // Quick sort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // partitioning index

            quickSort(arr, low, pi - 1);  // sort left part
            quickSort(arr, pi + 1, high); // sort right part
        }
    }

    // Main method
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

---

### 📈 Output:
```
Sorted array:
1 5 7 8 9 10
```

---

### 🧠 Time Complexity:
| Case        | Time          |
|-------------|---------------|
| Best Case   | O(n log n)    |
| Average Case| O(n log n)    |
| Worst Case  | O(n²)         |

> Worst case happens when pivot is always the smallest or largest element (unbalanced partition).

---

### ✅ Key Points:
- **In-place** algorithm (no extra array).
- **Unstable** sort (relative order not preserved).
- **Fast in practice** for large datasets with random data.

---

Sure! Let's break down **Quick Select** in a beginner-friendly and visual way.

---

## 💡 What is Quick Select?

Quick Select is an efficient **selection algorithm** used to find the **kth smallest** or **kth largest** element in an **unsorted array**.

> 🔍 It is similar to Quick Sort, but instead of sorting the whole array, it focuses only on the part where the **kth element** could be.

---

## 🧠 When to Use It?

You want to find:
- 1st smallest = **Minimum**
- nth smallest = **Maximum**
- n/2-th smallest = **Median**
- kth largest = `n - k` smallest

✅ Without sorting the entire array.

---

## ⚙️ How Does Quick Select Work?

1. **Pick a Pivot** (usually the last element).
2. **Partition** the array:
   - Elements **less than or equal** to pivot go to the left.
   - Elements **greater** than pivot go to the right.
3. After partitioning, check the **pivot’s final index**:
   - If it’s **equal to k**, return that element.
   - If it’s **greater than k**, the kth smallest is on the **left** side.
   - If it’s **less than k**, the kth smallest is on the **right** side.

> 🎯 The idea is to **narrow down** the search space.

---

## 🧮 Example:

```java
int[] arr = {7, 10, 4, 3, 20, 15};
int k = 3;
```

We want the **3rd smallest** element.

Steps:
1. Choose a pivot (say 15).
2. Partition the array → `[7, 10, 4, 3, 15, 20]`
3. Pivot 15 is at index 4 (0-based). We want index `k-1 = 2`.
4. Recurse on the left part: `[7, 10, 4, 3]`
5. Repeat until you find the element at index 2: **7**

---

## 🕒 Time Complexity

| Case | Time |
|------|------|
| Average | **O(n)** |
| Worst (bad pivots every time) | **O(n²)** |

> But much faster than sorting the whole array (which is O(n log n)).

---

## 🧠 Why is Quick Select Efficient?

Because it **only works on one side** of the array after partitioning. It doesn't sort everything—just what’s necessary.

---

## ✅ In Summary

| Feature | Value |
|--------|-------|
| Purpose | Find kth smallest/largest |
| Based on | Quick Sort partitioning |
| Time Complexity (Avg) | O(n) |
| Modifies array? | Yes (in-place) |
| Stable? | No |

---

Sure! Let's break down **Counting Sort** in a very simple and beginner-friendly way 👇

---

## 🧠 What is Counting Sort?

**Counting Sort** is a **non-comparison-based sorting algorithm** that works well when:
- The elements are **integers**
- The range of elements is **not very large**

Instead of comparing elements like Quick Sort or Merge Sort, it **counts how many times each value appears** and uses that to build the sorted array.

---

## 📦 Key Idea

> Count how many times each number appears, and then place them in order using that count.

---

## 📊 How It Works (Step by Step)

Let’s sort:  
```java
arr = {4, 2, 2, 8, 3, 3, 1}
```

### Step 1: Find the **maximum** element (say `max = 8`)

### Step 2: Create a **count array** of size `max + 1`  
```java
count = new int[9] // index 0 to 8
```

### Step 3: **Count the frequency** of each number in `arr`

```
arr:    [4, 2, 2, 8, 3, 3, 1]
count:  [0, 1, 2, 2, 1, 0, 0, 0, 1]
 index:  0  1  2  3  4  5  6  7  8
```

### Step 4: Build the **sorted array**

Go through the `count` array, and for each index, place it as many times as it appeared.

```
Sorted: [1, 2, 2, 3, 3, 4, 8]
```

---

## ✅ Code in Java

```java
import java.util.*;

public class CountSort {

    public static void countSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();

        int[] count = new int[max + 1];

        // Count frequency
        for (int num : arr) {
            count[num]++;
        }

        // Fill original array
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                arr[idx++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
```

---

## ⏱️ Time and Space Complexity

| Aspect | Complexity |
|--------|------------|
| Time   | O(n + k)   |
| Space  | O(k)       |

Where:
- `n` = size of input array
- `k` = range of input values (max value)

---

## ⚠️ When to Use / Avoid

✅ Use Counting Sort if:
- You have **small range** integers (e.g., 0–100)
- You want **linear time sorting**

🚫 Avoid if:
- Numbers are **very large** (e.g., 1 to 1,000,000)
- You have **negative numbers** (need extra logic)
- Input is **not integers**

Absolutely! Let's break down **Radix Sort** step-by-step in a super easy way 👇

---

## 🧠 What is Radix Sort?

**Radix Sort** is a **non-comparison-based sorting algorithm** that sorts numbers **digit by digit**, starting from the **least significant digit (LSD)** to the **most significant digit (MSD)**.

It uses a **stable sorting algorithm**, like **Counting Sort**, as a subroutine to sort digits.

---

## 🔁 How It Works

Imagine sorting the numbers:
```
[170, 45, 75, 90, 802, 24, 2, 66]
```

We'll sort them by:
1. Units digit (1s place)
2. Tens digit (10s place)
3. Hundreds digit (100s place)

At each step, we group and sort based on that digit.

---

### 🧮 Step-by-Step Example:

**Initial Array:**
```
[170, 45, 75, 90, 802, 24, 2, 66]
```

### ✅ Step 1: Sort by 1s digit
```
[170, 90, 802, 2, 24, 45, 75, 66]
```

### ✅ Step 2: Sort by 10s digit
```
[802, 2, 24, 45, 66, 170, 75, 90]
```

### ✅ Step 3: Sort by 100s digit
```
[2, 24, 45, 66, 75, 90, 170, 802]
```

**Final Sorted Array 🎉**

---

## ✅ Java Code for Radix Sort

```java
public class RadixSort {

    // A utility function to get the maximum value in arr[]
    static int getMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max)
                max = i;
        }
        return max;
    }

    // A function to do counting sort of arr[] according to the digit represented by exp.
    static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // digits 0–9

        // Count occurrences
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Prefix sum for stable sort
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array (go backwards for stability)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy to original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    static void radixSort(int[] arr) {
        int max = getMax(arr);

        // Sort for each digit: 1s, 10s, 100s, ...
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

---

## ⏱️ Time and Space Complexity

| Aspect         | Complexity     |
|----------------|----------------|
| Time           | O(n × k)       |
| Space          | O(n + k)       |

Where:
- `n` = number of elements
- `k` = number of digits in the maximum number (log10(max))

---

## ⚠️ Notes

- Only works for **non-negative integers** by default.
- Can be extended to handle **negative numbers** with extra logic.
- Radix Sort is great when:
  - You're sorting **large number of integers**
  - The values are **not too large** in digit length

---

Sure! Here's the updated table with a **note highlighting the most efficient sorting algorithm(s)** based on typical use cases:

---

### 📊 Time and Space Complexities of Sorting Algorithms

| Sorting Algorithm   | Best Case Time | Average Case Time | Worst Case Time | Space Complexity | Stable? |
|---------------------|----------------|--------------------|------------------|------------------|---------|
| **Bubble Sort**      | O(n)           | O(n²)              | O(n²)            | O(1)             | Yes     |
| **Selection Sort**   | O(n²)          | O(n²)              | O(n²)            | O(1)             | No      |
| **Insertion Sort**   | O(n)           | O(n²)              | O(n²)            | O(1)             | Yes     |
| **Merge Sort**       | O(n log n)     | O(n log n)         | O(n log n)       | O(n)             | Yes     |
| **Quick Sort**       | O(n log n)     | O(n log n)         | O(n²)            | O(log n)         | No      |
| **Heap Sort**        | O(n log n)     | O(n log n)         | O(n log n)       | O(1)             | No      |
| **Counting Sort**    | O(n + k)       | O(n + k)           | O(n + k)         | O(k)             | Yes     |
| **Radix Sort**       | O(nk)          | O(nk)              | O(nk)            | O(n + k)         | Yes     |
| **Bucket Sort**      | O(n + k)       | O(n + k)           | O(n²)            | O(n + k)         | Yes     |
| **Tim Sort** (Java’s default) | O(n)  | O(n log n)         | O(n log n)       | O(n)             | Yes     |

---

### 📝 Note:
✅ **Tim Sort**, which is a hybrid of Merge Sort and Insertion Sort (used in Java and Python’s built-in sorting), is considered one of the **most efficient general-purpose sorting algorithms** for real-world data due to its stability and performance on partially sorted data.

For specific use cases:
- Use **Counting/Radix/Bucket Sort** when the input is constrained (e.g., integers in a known range).
- Use **Quick Sort** for performance, but **Merge Sort** or **Tim Sort** when stability is important.