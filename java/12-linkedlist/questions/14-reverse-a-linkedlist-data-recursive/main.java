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
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        // ✅ You need to implement this function
        private void reverseDRHelper(Node right, int floor) {
            if (right == null) {
                return;
            }
            reverseDRHelper(right.next, floor+1);

            if (floor > size / 2) {
                int temp = right.data;
                right.data = rleft.data;
                rleft.data = temp;
                
                rleft = rleft.next;
            }
            
        }

        Node rleft;
        void reverseDR() {
            // write your code here
            rleft = head;
            reverseDRHelper(head, 0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        LinkedList list = new LinkedList();

        for (int i = 0; i < n; i++) {
            list.addLast(sc.nextInt());
        }

        list.reverseDR();
        list.display();
    }
}
