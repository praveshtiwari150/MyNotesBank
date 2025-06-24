# 🔹 **Object-Oriented Programming (OOP) in Java**

## ✅ **What is OOP?**
Object-Oriented Programming (OOP) is a programming paradigm that organizes code using **objects** and **classes**. It provides modularity, reusability, and scalability.

---

## ✅ **Key OOP Principles**
| Principle       | Description |
|---------------|-------------|
| **Encapsulation** | Wrapping data (variables) and code (methods) into a single unit (class) and restricting direct access. |
| **Abstraction** | Hiding implementation details and exposing only necessary features through interfaces or abstract classes. |
| **Inheritance** | Enabling one class (child) to inherit properties and behavior from another class (parent). |
| **Polymorphism** | Allowing methods to have multiple forms (method overloading and method overriding). |

---

## ✅ **OOP Concepts with Examples**

### 🔹 **1. Class & Object**
- A **class** is a blueprint for creating objects.
- An **object** is an instance of a class.

#### **Example**
```java
class Car {
    String brand;
    int speed;

    void display() {
        System.out.println("Brand: " + brand + ", Speed: " + speed);
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.brand = "Toyota";
        myCar.speed = 120;
        myCar.display();
    }
}
```

---

### 🔹 **2. Encapsulation**
- **Protects data** using private variables and provides access via public methods.

#### **Example**
```java
class Person {
    private String name;

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("John");
        System.out.println(p.getName());
    }
}
```

---

### 🔹 **3. Abstraction**
- **Hides** unnecessary details using `abstract` classes or `interface`.

#### **Example (Abstract Class)**
```java
abstract class Animal {
    abstract void makeSound();
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark!");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.makeSound();
    }
}
```

---

### 🔹 **4. Inheritance**
- **Allows a child class** to inherit properties and behaviors from a parent class.

#### **Example**
```java
class Animal {
    void eat() {
        System.out.println("This animal eats food.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();  // Inherited method
        d.bark();
    }
}
```

---

### 🔹 **5. Polymorphism**
- **Method Overloading** (same method name, different parameters)
- **Method Overriding** (subclass changes the behavior of a parent class method)

#### **Example (Method Overloading)**
```java
class MathOperations {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        MathOperations obj = new MathOperations();
        System.out.println(obj.add(5, 10));      // Calls int version
        System.out.println(obj.add(5.5, 10.5));  // Calls double version
    }
}
```

#### **Example (Method Overriding)**
```java
class Animal {
    void makeSound() {
        System.out.println("Some sound...");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.makeSound();  // Calls Dog's overridden method
    }
}
```

---

## ✅ **Key Advantages of OOP**
✔️ **Modularity** – Code is divided into smaller, reusable units.  
✔️ **Reusability** – Inheritance allows reusing code.  
✔️ **Security** – Encapsulation hides sensitive data.  
✔️ **Flexibility** – Polymorphism enables dynamic method execution.  
✔️ **Maintainability** – Code is structured and easy to modify.  

---

> 💡 **Tip:** Mastering OOP concepts is essential for writing scalable and efficient Java applications.
