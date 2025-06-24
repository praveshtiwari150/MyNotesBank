public class main {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        // Add element at the beginning
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

        // Add element at the end
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

        // Add element at a specific index
        void addAt(int val, int index) {
            if (index < 0 || index > size) {
                System.out.println("Invalid arguments");
            } else if (index == 0) {
                addFirst(val);
            } else if (index == size) {
                addLast(val);
            } else {
                Node node = new Node();
                node.data = val;

                Node temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }

                node.next = temp.next;
                temp.next = node;
                size++;
            }
        }

        // Display the linked list
        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public int getLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        public int getAt(int idx) {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid Arguments");
                return -1;
            } else {
                Node temp = head;
                for (int i = 0; i < idx; i++) {
                    temp = temp.next;
                }

                return temp.data;
            }
        }

        // Remove first element
        public int removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (size == 1) {
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            } else {
                int val = head.data;
                head = head.next;
                size--;
                return val;
            }
        }

        // Remove last element
        public int removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (size == 1) {
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            } else {
                Node temp = head;
                for (int i = 0; i < size - 2; i++) {
                    temp = temp.next;
                }
                int val = tail.data;
                tail = temp;
                temp.next = null;
                size--;
                return val;
            }
        }

        // Remove element at a given index
        public int removeAtIndex(int idx) {
            // answer
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid Arguments");
                return -1;
            } else if (idx == 0) {
                return removeFirst();
            } else if (idx == size - 1) {
                return removeLast();
            } else {
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                int val = temp.next.data;
                temp.next = temp.next.next;
                size--;
                return val;
            }
        }

        public void kReverse(int k) {
            LinkedList prev = null;

            while (this.size > 0) {
                LinkedList curr = new LinkedList();

                if (size >= k) {
                    for (int i = 0; i < k; i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addFirst(val);
                    }
                } else {
                    int os = this.size;
                    for (int i = 0; i < os; i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addFirst(val);
                    }
                }

                if (prev == null) {
                    prev = curr;
                } else {
                    prev.tail.next = curr.head;
                    prev.tail = curr.tail;
                    prev.size += curr.size;
                }
            }

            this.head = prev.head;
            this.tail = prev.tail;
            this.size = prev.size;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // Add elements to the linked list
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.addLast(9);

        System.out.println("Original Linked List:");
        ll.display();

        int k = 3; // set the group size for reversal
        ll.kReverse(k);

        System.out.println("Linked List after k-Reverse (k = " + k + "):");
        ll.display();

    }
}
