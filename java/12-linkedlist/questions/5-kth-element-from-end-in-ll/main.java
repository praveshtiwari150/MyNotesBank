import java.util.*;

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

        // Display the list (optional helper)
        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // Find k-th element from end
        public int kthFromLast(int k) {
            if (k > size) {
                System.out.println("Invalid arguments");
                return -1;
            }

            Node slow = head;
            Node fast = head;

            // Move fast pointer k steps ahead
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }

            // Move both slow and fast until fast reaches end
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow.data;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList list = new LinkedList();

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list.addLast(val);
        }

        int k = sc.nextInt();
        int result = list.kthFromLast(k);
        if (result != -1) {
            System.out.println(result);
        }
    }
}
