// Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class
class LinkedList {
    Node head;

    // Method to add a new node at the end
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Method to display the linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class AddTwoLinkedLists {

    public static int addListHelper(Node one, int pv1, Node two, int pv2, LinkedList res) {

        if(one == null && two == null){
            return 0;
        }
        if (pv1 > pv2) {
            addListHelper(one.next, pv1-1, two.next, pv2-1, res);
        } else if (pv1 < pv2) {
            int oc = addListHelper(one.next, pv1 - 1, two.next, pv2 - 1, res);
            int data = one.data + two.data + oc;

            int nd = data % 10;
            int nc = data / 10;

            res.a
        } else {
            
        }
    }
    // Method to add two numbers represented by linked lists
    public static LinkedList addTwoNumbers(Node l1, Node l2) {
        // Your logic here
        return null;
    }

    public static void main(String[] args) {

        // First number: 2 -> 4 -> 3
        LinkedList num1 = new LinkedList();
        num1.add(2);
        num1.add(4);
        num1.add(3);

        // Second number: 5 -> 6 -> 4
        LinkedList num2 = new LinkedList();
        num2.add(5);
        num2.add(6);
        num2.add(4);

        // Display input numbers
        System.out.print("First Number  : ");
        num1.display();
        System.out.print("Second Number : ");
        num2.display();

        // Add the numbers
        LinkedList result = addTwoNumbers(num1.head, num2.head);

        // Display result
        System.out.print("Result        : ");
        result.display();
    }
}
