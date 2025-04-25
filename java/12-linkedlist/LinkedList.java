import java.util.*;

public class LinkedList {
    public static class Node {
        int data;
        Node next;
    }

    public static class linkedlist {
        Node head;
        Node tail;
        int size;

        void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if (size == 0) {
                tail = temp;
            }
            size++;
        }

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++; // Size should only increment once, after node is added
        }

        void addAt(int idx, int val) {
            if (idx < 0 || idx > size) {
                System.out.println("Invalid arguments. Index cannot be negative or greater than size.");
            } else if (idx == 0) {
                addFirst(val);
            } else if (idx == size) {
                addLast(val);
            } else {
                Node node = new Node();
                node.data = val;
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }

                node.next = temp.next;
                temp.next = node;

                size++;
            }
        }

        public int size() {
            return size;
        }

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " "); // Changed println to print for better formatting
                temp = temp.next;
            }
            System.out.println();
        }

        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public int getLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        public int getAt(int idx) {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid Arguments");
                return -1;
            } else {
                Node temp = head;
                for (int i = 0; i < idx; i++) {
                    temp = temp.next;
                }

                return temp.data;
            }
        }

        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }

        public void removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                Node temp = head;
                for (int i = 0; i < size - 2; i++) {
                    temp = temp.next;
                }

                tail = temp;
                temp.next = null;
                size--;
            }
        }

        public void removeAtIndex(int idx) {
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid Arguments");
            } else if (idx == 0) {
                removeFirst();
            } else if (idx == size - 1) {
                removeLast();
            } else {
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }

                temp.next = temp.next.next;
                size--;
            }
        }
    }

    public static void testAddAt() {
        linkedlist list = new linkedlist();

        System.out.println("Test 1 - AddAt to Empty List at Index 0");
        list.addAt(0, 5);
        System.out.println("Expected: 5, Actual: ");
        list.display();
        System.out.println("Size: " + list.size());
        System.out.println("---");

        System.out.println("Test 2 - AddAt Invalid Index");
        list.addAt(2, 10); // Should fail (size is 1)
        System.out.println("Expected: 5 (unchanged), Actual: ");
        list.display();
        System.out.println("Size: " + list.size());
        System.out.println("---");

        System.out.println("Test 3 - AddAt in Middle");
        list.addLast(15);
        list.addAt(1, 10);
        System.out.println("Expected: 5 10 15, Actual: ");
        list.display();
        System.out.println("Size: " + list.size());
        System.out.println("---");

        System.out.println("Test 4 - AddAt at End");
        list.addAt(3, 20);
        System.out.println("Expected: 5 10 15 20, Actual: ");
        list.display();
        System.out.println("Size: " + list.size());
        System.out.println("---");
    }

    public static void main(String[] args) {
        testAddAt();
        linkedlist lt = new linkedlist();

        lt.addLast(1);
        lt.addLast(4);
        lt.addLast(46);
        System.out.println("Size: " + lt.size());
        lt.display();
        lt.removeFirst();
        lt.display();
    }
}