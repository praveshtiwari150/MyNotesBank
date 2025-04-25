import java.util.*;

public class main {

    public static class Person {
        int age;
        String name;

        void saysHi() {
            System.out.println(name + "[" + age + "]" + " says " + "hi");
        }

        // if we forge java provides our class a default constructor
        // default constructor
        Person() {
            System.out.println("Default constructor fired");
        }
        
        // parameterised constructor
        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 26;
        p1.name = "Pravesh";

        p1.saysHi();

        Person p3 = new Person(35, "Nikhil");

        p3.saysHi();
    }
}