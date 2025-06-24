public class main {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
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
                tail = temp; // ✅ important fix — updating tail
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

        static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            Node one = l1.head;
            Node two = l2.head;

            LinkedList res = new LinkedList();

            while (one != null && two != null) {
                if (one.data < two.data) {
                    res.addLast(one.data);
                    one = one.next;
                } else {
                    res.addLast(two.data);
                    two = two.next;
                }
            }

            while (one != null) {
                res.addLast(one.data);
                one = one.next;
            }

            while (two != null) {
                res.addLast(two.data);
                two = two.next;
            }

            return res;
        }
    }

    public static Node midNode(Node head, Node tail) {
        Node f = head;
        Node s = head;

        while (f != tail && f.next != tail) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }

    public static LinkedList mergeSort(Node head, Node tail) {
        if (head == tail) {
            LinkedList br = new LinkedList();
            br.addLast(head.data);
            return br;
        }

        Node mid = midNode(head, tail);
        LinkedList fsh = mergeSort(head, mid);
        LinkedList ssh = mergeSort(mid.next, tail);
        LinkedList cl = LinkedList.mergeTwoSortedLists(fsh, ssh);
        return cl;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(34);
        list.addLast(86);
        list.addLast(12);

        System.out.println("Original list:");
        list.display();

        LinkedList sortedList = mergeSort(list.head, list.tail);

        System.out.println("Sorted list:");
        sortedList.display();
    }
}
