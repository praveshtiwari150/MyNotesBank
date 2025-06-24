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

        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // 🔴 Write your solution here
        public void displayReverse() {
            displayReverseHelper(head);
            System.out.println();
        }

        private void displayReverseHelper(Node node) {
            // your code here

            if (node == null) {
                return;
            }
            displayReverseHelper(node.next);
            System.out.print(node.data + " ");
            
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        LinkedList ll = new LinkedList();
        for (int i = 0; i < n; i++) {
            ll.addLast(sc.nextInt());
        }

        ll.displayReverse();
    }
}
