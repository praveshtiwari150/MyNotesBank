## Java ArrayList Notes

### What is an ArrayList?
- A resizable array in Java.
- Part of the `java.util` package.
- Grows and shrinks dynamically.
- Can store objects (not primitives directly).

---

### Import Statement
```java
import java.util.ArrayList;
```

---

### Declaration and Initialization
```java
ArrayList<Integer> list = new ArrayList<>();
ArrayList<String> names = new ArrayList<>();
```

---

### Adding Elements
```java
list.add(10);           // adds 10 at the end
list.add(1, 20);        // inserts 20 at index 1
```

---

### Removing Elements
```java
list.remove(2);                      // removes element at index 2
list.remove(Integer.valueOf(10));    // removes value 10 (first occurrence)
```

---

### Updating Elements
```java
list.set(0, 99);        // sets index 0 to 99
```

---

### Accessing Elements
```java
int val = list.get(1);  // gets value at index 1
```

---

### Size
```java
int size = list.size(); // returns number of elements
```

---

### Looping
```java
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}

for (int val : list) {
    System.out.println(val);
}
```

---

### Searching
```java
list.contains(30);      // returns true if 30 is present
list.indexOf(30);       // returns index of 30 or -1 if not found
```

---

### Clearing All Elements
```java
list.clear();
```

---

### Notes
- Maintains insertion order
- Allows duplicate values
- Cannot store primitive types directly (use wrapper classes like `Integer`, `Double`, etc.)