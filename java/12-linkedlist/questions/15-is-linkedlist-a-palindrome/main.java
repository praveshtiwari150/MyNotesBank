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

        // ✅ You need to implement this method

        private boolean isPalindromeHelper(Node right) {
            if (right == null) {
                return true;
            }
            boolean rres = isPalindromeHelper(right.next);

            if (rres == false) {
                return false;
            } else if (pleft.data != right.data) {
                return false;
            } else {
                pleft = pleft.next;
                return true;
            }
        }

        Node pleft;
        public boolean isPalindrome() {
            // write your code here
            pleft = head;
            return isPalindromeHelper(head);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        LinkedList list = new LinkedList();

        for (int i = 0; i < n; i++) {
            list.addLast(sc.nextInt());
        }

        boolean result = list.isPalindrome();
        System.out.println(result);
    }
}
