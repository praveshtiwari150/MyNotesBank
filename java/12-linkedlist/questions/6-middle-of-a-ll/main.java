import java.util.Scanner;

public class main {
    public static class LinkedList {
        private class Node {
            int data;
            Node next;
        }

        private Node head;
        private Node tail;
        private int size;

        // Add element to the end of the list
        public void addLast(int val) {
            Node newNode = new Node();
            newNode.data = val;

            if (size == 0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        // Display the list
        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // Find middle element
        public int findMiddle() {
            if (head == null) {
                System.out.println("List is empty");
                return -1;
            }

            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow.data;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list.addLast(val);
        }

        System.out.println("Linked List:");
        list.display();

        System.out.println("Middle element: " + list.findMiddle());
    }
}
