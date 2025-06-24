import java.util.*;

public class main {

    public static class StackToQueueAdapter {
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueueAdapter() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            while (mainS.size() > 0) {
                helperS.push(mainS.pop());
            }
            mainS.push(val);
            while (helperS.size() > 0) {
                mainS.push(helperS.pop());
            }
        }

        int remove() {
            if (size() == 0) {
                return -1;
            } else {
                return mainS.pop();
            }
        }

        int peek() {
            if (size() == 0) {
                return -1;
            } else {
                return mainS.peek();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StackToQueueAdapter q = new StackToQueueAdapter();

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            if (cmd.equals("add")) {
                int val = sc.nextInt();
                q.add(val);
            } else if (cmd.equals("remove")) {
                System.out.println(q.remove());
            } else if (cmd.equals("peek")) {
                System.out.println(q.peek());
            } else if (cmd.equals("size")) {
                System.out.println(q.size());
            }
        }
    }
}
