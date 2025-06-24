# **Queue in Java (Detailed Explanation)**  

## **1. What is a Queue?**  
A **Queue** is a **linear data structure** that follows the **First-In-First-Out (FIFO)** principle. This means that elements are added at the **rear** (end) and removed from the **front** (beginning).  

📌 **Key Characteristics of a Queue:**  
✔ **FIFO (First In, First Out)** – The first element added is the first to be removed.  
✔ **Insertion (Enqueue)** – Performed at the **rear** of the queue.  
✔ **Deletion (Dequeue)** – Performed from the **front** of the queue.  
✔ **Used in real-world scenarios** such as **task scheduling, buffering, and breadth-first search (BFS)** in graphs.  

---

## **2. Queue Implementation in Java**  
### **Java provides the `Queue` interface in the `java.util` package.**  
It is implemented by different classes such as:  
✔ `LinkedList` (Doubly Linked List-based Queue)  
✔ `PriorityQueue` (Heap-based Priority Queue)  
✔ `ArrayDeque` (Resizable Array-based Queue)  

---

## **3. Queue Interface in Java**  
📌 The `Queue<E>` interface extends the `Collection<E>` interface and provides methods for queue operations.  

### **Queue Methods in Java**  

| Method          | Description |
|----------------|------------|
| `add(E e)`    | Inserts an element into the queue (throws an exception if full). |
| `offer(E e)`  | Inserts an element into the queue (returns `false` if full). |
| `remove()`    | Removes and returns the head of the queue (throws an exception if empty). |
| `poll()`      | Removes and returns the head of the queue (returns `null` if empty). |
| `element()`   | Retrieves but does not remove the head of the queue (throws an exception if empty). |
| `peek()`      | Retrieves but does not remove the head of the queue (returns `null` if empty). |

---

## **4. Implementing a Queue using `LinkedList`**  
Java's `LinkedList` class implements the `Queue` interface.  
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Create a Queue
        Queue<Integer> queue = new LinkedList<>();

        // Enqueue (Add elements)
        queue.add(10);
        queue.add(20);
        queue.offer(30);  // `offer()` is safer

        // Display queue
        System.out.println("Queue: " + queue); // [10, 20, 30]

        // Dequeue (Remove elements)
        System.out.println("Removed: " + queue.poll()); // 10
        System.out.println("Queue after removal: " + queue); // [20, 30]

        // Peek (Check front element)
        System.out.println("Front element: " + queue.peek()); // 20
    }
}
```
✅ **Output:**  
```
Queue: [10, 20, 30]  
Removed: 10  
Queue after removal: [20, 30]  
Front element: 20  
```

---

## **5. Implementing a Queue using `ArrayDeque`**  
- **`ArrayDeque` is faster** than `LinkedList` and is preferred for queues.  
```java
import java.util.ArrayDeque;
import java.util.Queue;

public class ArrayDequeExample {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();

        queue.offer("Apple");
        queue.offer("Banana");
        queue.offer("Cherry");

        System.out.println("Queue: " + queue); // [Apple, Banana, Cherry]
        System.out.println("Peek: " + queue.peek()); // Apple
        System.out.println("Removed: " + queue.poll()); // Apple
        System.out.println("Queue after removal: " + queue); // [Banana, Cherry]
    }
}
```

---

## **6. Implementing a `PriorityQueue` in Java**  
A **Priority Queue** processes elements based on **priority instead of FIFO**.  
```java
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(50);
        priorityQueue.offer(20);
        priorityQueue.offer(40);
        priorityQueue.offer(10);

        System.out.println("Priority Queue: " + priorityQueue); 
        // Order is based on natural sorting, but internal structure is not a simple list.

        System.out.println("Polled element: " + priorityQueue.poll()); // Removes 10 (smallest)
        System.out.println("Queue after poll: " + priorityQueue); // [20, 50, 40]
    }
}
```
✅ **Output:**  
```
Priority Queue: [10, 20, 40, 50]  
Polled element: 10  
Queue after poll: [20, 50, 40]  
```
✔ `PriorityQueue` **orders elements in ascending order by default**.  
✔ **For custom ordering**, use a **Comparator**.  

---

## **7. Implementing a Custom Queue using an Array**  
```java
class CustomQueue {
    private int[] arr;
    private int front, rear, size, capacity;

    public CustomQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        int removedValue = arr[front];
        front = (front + 1) % capacity;
        size--;
        return removedValue;
    }

    public int peek() {
        return (size == 0) ? -1 : arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class QueueArrayExample {
    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek()); // 10
        System.out.println("Dequeued: " + queue.dequeue()); // 10
        System.out.println("Front element after dequeue: " + queue.peek()); // 20
    }
}
```

---

## **8. Applications of Queue in Java**  
✔ **Task Scheduling** – OS Process Scheduling (Round-Robin Scheduling).  
✔ **Print Spoolers** – Managing print jobs in a queue.  
✔ **Breadth-First Search (BFS)** – Graph traversal.  
✔ **Call Center Management** – Handling customer service calls in order.  
✔ **Message Queues** – RabbitMQ, Kafka, etc.  

---

## **9. Summary**
- **Queue is a FIFO-based data structure.**
- **Implemented using `LinkedList`, `ArrayDeque`, and `PriorityQueue`.**
- **Use `PriorityQueue` for ordered processing.**
- **Use `ArrayDeque` for faster queue operations.**
- **Custom queue can be implemented using an array.**

🚀 **Queues are widely used in real-world applications for efficient processing and scheduling tasks!**

Declaring a queue like this:  

```java
Queue<Integer> que = new ArrayDeque<>();
```  

**is done for flexibility and adherence to best practices in Java programming.** Let's break it down step by step.

---

## **1. Why Use `Queue<Integer>` Instead of `ArrayDeque<Integer>`?**
Declaring the queue as:  
```java
Queue<Integer> que = new ArrayDeque<>();
```  
**instead of:**  
```java
ArrayDeque<Integer> que = new ArrayDeque<>();
```  
**is beneficial because:**

### **a) Follows the "Program to an Interface" Principle**  
- `Queue` is an **interface** in Java that represents a queue behavior.  
- `ArrayDeque` is a **concrete implementation** of the `Queue` interface.  
- By using `Queue<Integer>`, you make your code **more flexible** and **loosely coupled** to the specific implementation.  
- If you later decide to use a different queue implementation (`LinkedList`, `PriorityQueue`), you can change only the right-hand side.

✅ **Example of flexibility:**  
```java
Queue<Integer> que = new LinkedList<>();  // Now using LinkedList instead of ArrayDeque
```
This **would not be possible** if you declared:
```java
ArrayDeque<Integer> que = new ArrayDeque<>();
```
because `LinkedList` cannot be assigned to `ArrayDeque`.

---

### **b) Encourages Code Reusability and Extensibility**  
- If your code relies on the `Queue` interface, it can work with **any queue implementation** without modifications.
- This is useful in real-world applications where you might need to switch from `ArrayDeque` to `PriorityQueue` or a custom queue.

✅ **Example: Easy switching of queue implementations**
```java
public void processQueue(Queue<Integer> queue) {
    queue.offer(10);
    queue.offer(20);
    System.out.println(queue.poll()); // Process and remove first element
}
```
Now, you can pass **any queue type** (`ArrayDeque`, `LinkedList`, `PriorityQueue`) to this method:
```java
processQueue(new ArrayDeque<>());
processQueue(new LinkedList<>());
processQueue(new PriorityQueue<>());
```

🚀 **This makes the code modular and reusable!**

---

## **2. Why `new ArrayDeque<>()` Instead of `new Queue<>()`?**
- `Queue` is **an interface**, so you **cannot instantiate it directly**.
- `ArrayDeque` is **a concrete class** that implements `Queue`, so it can be instantiated.

✅ **Correct:**  
```java
Queue<Integer> que = new ArrayDeque<>();
```
❌ **Incorrect (won’t compile):**  
```java
Queue<Integer> que = new Queue<>(); // ❌ Error: Queue is abstract and cannot be instantiated
```

---

## **3. Why Not Use `LinkedList` for Queue?**
You could also declare:  
```java
Queue<Integer> que = new LinkedList<>();
```
But `LinkedList` is **slower** than `ArrayDeque` because:
- `ArrayDeque` does not allow nulls, avoiding `NullPointerException` risks.
- `ArrayDeque` performs **faster** than `LinkedList` due to **better memory locality** and **less overhead**.
- `LinkedList` has **extra overhead** for maintaining node pointers.

🚀 **For a pure queue, `ArrayDeque` is the best option.**

---

## **Conclusion**
✅ `Queue<Integer> que = new ArrayDeque<>();`  
- **Follows best practices** ("program to an interface").  
- **Keeps code flexible** (can switch queue types easily).  
- **Uses `ArrayDeque` because it is more efficient** than `LinkedList`.  
- **Cannot instantiate `Queue` directly** since it's an interface.  

🚀 **Always prefer this declaration for best flexibility and performance!**