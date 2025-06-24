import java.util.*;

public class main {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

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
            size++;
        }

        // Display elements from head to tail
        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // 🔴 Corrected Recursive function to reverse linked list using pointers
        private void reversePRHelper(Node node) {
            if (node == null) {
                return;
            }

            if (node == tail) {
                return;
            }

            reversePRHelper(node.next);

            node.next.next = node;
        }

        // Public method to initiate recursion
        public void reversePointerRecursively() {
            if (size <= 1)
                return;

            reversePRHelper(head);

            // Swap head and tail
            Node temp = head;
            head = tail;
            tail = temp;

            // Break the old head's next pointer
            tail.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        LinkedList ll = new LinkedList();

        for (int i = 0; i < n; i++) {
            ll.addLast(sc.nextInt());
        }

        ll.reversePointerRecursively();
        ll.display();
    }
}