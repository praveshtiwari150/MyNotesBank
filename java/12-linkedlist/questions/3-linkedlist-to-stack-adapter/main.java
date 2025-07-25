import java.util.*;

public class main {

    public static class LLToStackAdapter {
        LinkedList<Integer> list;

        public LLToStackAdapter() {
            list = new LinkedList<>();
        }

        int size() {
            return list.size();
        }

        void push(int val) {
            list.addFirst(val);
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return list.removeFirst();
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return list.getFirst();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LLToStackAdapter stack = new LLToStackAdapter();

        while (true) {
            String command = sc.nextLine();

            if (command.startsWith("push")) {
                int val = Integer.parseInt(command.split(" ")[1]);
                stack.push(val);
            } else if (command.equals("pop")) {
                int val = stack.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (command.equals("top")) {
                int val = stack.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("quit")) {
                break;
            }
        }
    }
}
