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

        private void foldHelper(Node right, int floor) {
            if (right == null) {
                return;
            }
            foldHelper(right.next, floor+1);

            if (floor > size / 2) {
                Node temp = fleft.next;
                fleft.next = right;
                right.next = temp;
                fleft = temp;
            } else if (floor == size / 2) {
                Node temp = fleft.next;
                tail = right;
                tail.next = null;
            }

        }

        Node fleft;

        // ✅ Complete this method
        public void fold() {
            fleft = head;
            foldHelper(head, 0);
        }

        void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        LinkedList list = new LinkedList();

        for (int i = 0; i < n; i++) {
            list.addLast(sc.nextInt());
        }

        list.fold();
        list.display();
    }
}
