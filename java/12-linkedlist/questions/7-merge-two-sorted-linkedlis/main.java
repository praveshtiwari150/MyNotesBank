
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
            }

            else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }

            System.out.println();
        }
    }
    public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
        Node one = l1.head;
        Node two = l2.head;

        LinkedList res = new LinkedList();

        while (one != null && two != null) {
            if (one.data < two.data) {
                res.addLast(one.data);
                one = one.next;
            }

            else {
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
    
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast(1);
        list1.addLast(3);
        list1.addLast(5);
        list1.addLast(7);

        LinkedList list2 = new LinkedList();
        list2.addLast(2);
        list2.addLast(4);
        list2.addLast(6);
        list2.addLast(8);

        System.out.print("List 1: ");
        list1.display();

        System.out.print("List 2: ");
        list2.display();

        LinkedList mergedList = mergeTwoSortedLists(list1, list2);

        System.out.print("Merged List: ");
        mergedList.display();
    }
}
