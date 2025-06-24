import java.util.*;

public class main {

    public static class LLToQueueAdapter {
        LinkedList<Integer> list;

        public LLToQueueAdapter() {
            list = new LinkedList<>();
        }

        int size() {
            return list.size();
        }

        void add(int val) {
            list.addLast(val);
        }

        int remove() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return list.removeFirst();
            }
        }

        int peek() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return list.getFirst();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LLToQueueAdapter queue = new LLToQueueAdapter();

        while (true) {
            String command = sc.nextLine();

            if (command.startsWith("add")) {
                int val = Integer.parseInt(command.split(" ")[1]);
                queue.add(val);
            } else if (command.equals("remove")) {
                int val = queue.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (command.equals("peek")) {
                int val = queue.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (command.equals("size")) {
                System.out.println(queue.size());
            } else if (command.equals("quit")) {
                break;
            }
        }
    }
}
