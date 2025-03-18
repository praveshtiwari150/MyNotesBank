
### 1. How to Print Output in Java

#### 🧠 Key Concepts:
- `System.out.print()` → Prints text without moving to the next line.
- `System.out.println()` → Prints text and moves to the next line.
- `System.out.printf()` → Prints formatted output using format specifiers.

#### 🧮 Syntax:
1. `System.out.print("text");`  
2. `System.out.println("text");`  
3. `System.out.printf("format", values);`  
   - `%d` → integer  
   - `%f` → float/double  
   - `%s` → string  
   - `%.2f` → float with 2 decimal places

#### ✅ Points to Remember:
- Every Java print statement ends with a semicolon `;`.
- `println()` adds a line break automatically.
- `printf()` gives control over output formatting.
- Use escape characters like `\n` (newline), `\t` (tab).

#### 🧪 Example:
**Q:** Print "Hello" and "World" on separate lines  
**A:**  
```java
System.out.println("Hello");
System.out.println("World");
```

---

### 2. What is a Variable in Java?

#### 🧠 Key Concepts:
- Variables are containers used to store data values.
- Java requires you to declare the type of variable before using it.
- The type defines what kind of data the variable can hold.

#### 🧮 Formulae (Syntax):
1. `datatype variableName = value;`
2. Examples:  
   - `int age = 20;`  
   - `String name = "Rahul";`  
   - `float price = 99.5f;`

#### ✅ Points to Remember:
- Variable names are case-sensitive and follow camelCase convention.
- Cannot start with numbers or use Java keywords.
- Use `int`, `double`, `char`, `boolean`, `String`, etc., based on the data type.
- Variables can be declared without assigning values initially.

#### 🧪 Example:
**Q:** Declare a string and an integer variable, then print them  
**A:**  
```java
String city = "Mumbai";
int population = 20000000;
System.out.println(city + " has population of " + population);
```

---

### 3. What are Conditionals in Java?

#### 🧠 Key Concepts:
- Conditionals allow a program to make decisions based on certain conditions.
- Common conditional statements in Java are:  
  - `if`  
  - `if-else`  
  - `if-else if-else`  
  - `switch`

#### 🧮 Syntax:
```java
// if statement
if (condition) {
    // code block
}

// if-else
if (condition) {
    // block if true
} else {
    // block if false
}

// if-else if-else
if (condition1) {
    // block 1
} else if (condition2) {
    // block 2
} else {
    // default block
}

// switch statement
switch (expression) {
    case value1:
        // code
        break;
    case value2:
        // code
        break;
    default:
        // default code
}
```

---

### 4. What are Loops in Java?

#### 🧠 Key Concepts:
- Loops are used to execute a block of code repeatedly.
- Java has three main types of loops:
  - `for` loop — when number of iterations is known.
  - `while` loop — when the condition is checked before the block runs.
  - `do-while` loop — executes the block at least once, then checks the condition.

#### 🧮 Syntax:
```java
// for loop
for (initialization; condition; update) {
    // code to run
}

// while loop
while (condition) {
    // code to run
}

// do-while loop
do {
    // code to run
} while (condition);
```

---

### 5. How to Take Input in Java?

#### 🧠 Key Concepts:
- **Input:** Receiving data from the user during program execution.
- **Scanner Class:** A built-in Java class (`java.util.Scanner`) used to read input from the keyboard.
- **Object Creation:** Create a `Scanner` object to use its methods like `nextInt()`, `nextLine()`.

#### 🧮 Syntax:
1. **Import Scanner:** `import java.util.Scanner;` (at the top of the file)
2. **Create Scanner Object:** `Scanner sc = new Scanner(System.in);`
3. **Read Input:**
   - `int num = sc.nextInt();` → Reads an integer
   - `double val = sc.nextDouble();` → Reads a decimal
   - `String text = sc.nextLine();` → Reads a line of text

#### ✅ Points to Remember:
- Always import `Scanner` before using it.
- `System.in` connects the Scanner to the keyboard.
- After `nextInt()`, add `sc.nextLine()` to clear the buffer before reading a string.
- Close the Scanner with `sc.close();` when done (good practice).

#### 🧪 Example:
**Q:** How do you take a user’s name (string) and age (integer) as input and print them?  
**A:**  
```java
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = sc.nextLine(); // Reads string first
        
        System.out.print("Enter your age: ");
        int age = sc.nextInt(); // Reads integer
        
        System.out.println("Name: " + name + ", Age: " + age);
        
        // Scenario: Integer first, then String
        System.out.print("Enter your age: ");
        age = sc.nextInt(); // Reads integer
        sc.nextLine(); // Clears leftover newline
        
        System.out.print("Enter your name: ");
        name = sc.nextLine(); // Reads string
        
        System.out.println("Name: " + name + ", Age: " + age);
        sc.close();
    }
}
```

---
