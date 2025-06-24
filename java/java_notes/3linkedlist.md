# **LinkedList in Java (Detailed Explanation)**  

## **1. What is a LinkedList?**  
A **LinkedList** is a **linear data structure** in which elements (nodes) are stored **non-contiguously** in memory. Each node contains:  
1. **Data** (the actual value)  
2. **Pointer (Reference)** to the next node in the list  

Java provides `LinkedList` as a **class** in the `java.util` package, which implements both the **List** and **Deque** interfaces.  

📌 **Key Features of LinkedList in Java:**  
✔ **Doubly Linked List** implementation (each node has pointers to both next and previous nodes).  
✔ **Efficient insertions and deletions** compared to `ArrayList`.  
✔ **Supports FIFO (Queue) and LIFO (Stack) operations** using `Deque`.  

---

## **2. LinkedList Class in Java**
The `LinkedList` class implements:
- **`List` Interface** → Supports indexing and allows duplicate elements.
- **`Deque` Interface** → Allows efficient insertion/removal from both ends (acts as a queue or stack).

### **Class Declaration**
```java
public class LinkedList<E> extends AbstractSequentialList<E>
        implements List<E>, Deque<E>, Cloneable, Serializable
```

---

## **3. Creating a LinkedList in Java**
### **Syntax**
```java
LinkedList<Type> list = new LinkedList<>();
```
### **Example**
```java
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        // Creating a LinkedList of Strings
        LinkedList<String> list = new LinkedList<>();

        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Printing the LinkedList
        System.out.println("LinkedList: " + list);
    }
}
```
✅ **Output:**  
```
LinkedList: [Apple, Banana, Cherry]
```

---

## **4. Important LinkedList Methods**
| Method                 | Description |
|------------------------|------------|
| `add(E e)`            | Adds element at the end of the list |
| `addFirst(E e)`       | Adds element at the beginning |
| `addLast(E e)`        | Adds element at the end (same as `add()`) |
| `remove()`            | Removes the first element |
| `removeFirst()`       | Removes the first element |
| `removeLast()`        | Removes the last element |
| `getFirst()`          | Retrieves the first element |
| `getLast()`           | Retrieves the last element |
| `peekFirst()`         | Retrieves first element (returns `null` if empty) |
| `peekLast()`          | Retrieves last element (returns `null` if empty) |
| `pollFirst()`         | Retrieves and removes the first element |
| `pollLast()`          | Retrieves and removes the last element |

---

## **5. Adding Elements in a LinkedList**
### **Using `add()`**
```java
LinkedList<Integer> numbers = new LinkedList<>();
numbers.add(10);
numbers.add(20);
numbers.add(30);
System.out.println(numbers); // [10, 20, 30]
```

### **Using `addFirst()` and `addLast()`**
```java
numbers.addFirst(5);
numbers.addLast(40);
System.out.println(numbers); // [5, 10, 20, 30, 40]
```

---

## **6. Removing Elements in a LinkedList**
### **Using `remove()`, `removeFirst()`, `removeLast()`**
```java
numbers.removeFirst(); // Removes 5
numbers.removeLast();  // Removes 40
System.out.println(numbers); // [10, 20, 30]
```

### **Using `poll()`, `pollFirst()`, `pollLast()` (Safer)**
```java
System.out.println(numbers.poll()); // 10 (removes and returns first element)
System.out.println(numbers.pollLast()); // 30 (removes last)
```
📌 `poll()` is safer than `remove()` because it returns `null` if the list is empty.

---

## **7. Accessing Elements**
### **Using `getFirst()` and `getLast()`**
```java
System.out.println("First: " + numbers.getFirst()); // 20
System.out.println("Last: " + numbers.getLast());   // 20
```

### **Using `peek()` (Safer)**
```java
System.out.println("Peek First: " + numbers.peekFirst()); // 20
System.out.println("Peek Last: " + numbers.peekLast());   // 20
```
📌 `peek()` returns `null` instead of throwing an exception if the list is empty.

---

## **8. Iterating Over a LinkedList**
### **Using a `for` loop**
```java
for (int i = 0; i < numbers.size(); i++) {
    System.out.print(numbers.get(i) + " ");
}
```
### **Using an Enhanced `for` loop**
```java
for (Integer num : numbers) {
    System.out.print(num + " ");
}
```
### **Using an Iterator**
```java
Iterator<Integer> iterator = numbers.iterator();
while (iterator.hasNext()) {
    System.out.print(iterator.next() + " ");
}
```
### **Using `forEach()`**
```java
numbers.forEach(num -> System.out.print(num + " "));
```

---

## **9. LinkedList as a Queue**
The `LinkedList` class implements the `Queue` interface, making it usable as a **FIFO (First-In-First-Out) queue**.

```java
Queue<String> queue = new LinkedList<>();

queue.offer("A");
queue.offer("B");
queue.offer("C");

System.out.println(queue.poll()); // A (removes first element)
System.out.println(queue.peek()); // B (checks front)
```

---

## **10. LinkedList as a Stack**
The `LinkedList` class implements the `Deque` interface, making it usable as a **LIFO (Last-In-First-Out) stack**.

```java
Deque<Integer> stack = new LinkedList<>();

stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.pop()); // 30 (removes last element)
System.out.println(stack.peek()); // 20 (checks top)
```

---

## **11. Difference Between `ArrayList` and `LinkedList`**
| Feature        | ArrayList | LinkedList |
|---------------|-----------|------------|
| **Implementation** | Dynamic array | Doubly linked list |
| **Access Time** | Fast (O(1)) | Slow (O(n)) |
| **Insertion/Deletion** | Slow (O(n)) | Fast (O(1) at head/tail) |
| **Memory Usage** | Less (no extra pointers) | More (extra space for pointers) |
| **Best For** | Read-heavy applications | Insert/Delete-heavy applications |

---

## **12. When to Use LinkedList?**
✅ **Use LinkedList when:**  
- You **frequently add/remove** elements at the **beginning/middle** of the list.  
- You need a **FIFO queue** or **LIFO stack**.  

❌ **Avoid LinkedList when:**  
- You need **fast access by index** (`ArrayList` is better).  
- Memory usage is a concern (LinkedList uses extra space for pointers).  

---

## **13. Summary**
- **LinkedList is a doubly linked list** that allows fast insertions and deletions.  
- Implements **List, Queue, and Deque**, so it can be used as a **list, queue, or stack**.  
- **Slower than ArrayList for random access** but **faster for insertions/deletions**.  
- **Memory overhead is higher** due to extra node pointers.  
- **Use it when frequent modifications are required**, otherwise prefer `ArrayList`.  

🚀 **Mastering `LinkedList` helps in implementing stacks, queues, and graph traversal algorithms like BFS!**