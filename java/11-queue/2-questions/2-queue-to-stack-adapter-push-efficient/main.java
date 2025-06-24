import java.util.*;

public class main {

    public static class QueueToStackAdapter {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStackAdapter() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        // write your code here
        int size() {
            return mainQ.size();
        }

        void push(int val) {
            mainQ.add(val);
        }
        
        int pop() {
            if (size() == 0) {
                System.out.println("stack underflow");
                return -1;
            } else {
                while (mainQ.size() > 1) {
                    helperQ.add(mainQ.remove());
                }

                int val = mainQ.remove();

                while (helperQ.size() > 0) {
                    mainQ.add(helperQ.remove());
                }
                return val;
            }
        }
        
        int top() {
            if (size() == 0) {
                System.out.println("stack underflow");
                return -1;
            }
            else {
                while (mainQ.size() > 1) {
                    helperQ.add(mainQ.remove());
                }

                int val = mainQ.remove();
                helperQ.add(val);

                while (helperQ.size() > 0) {
                    mainQ.add(helperQ.remove());
                }
                return val;
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        QueueToStackAdapter st = new QueueToStackAdapter();

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            if (cmd.equals("push")) {
                int x = sc.nextInt();
                st.push(x);
            } else if (cmd.equals("pop")) {
                int x = sc.nextInt();
                st.push(x);
            } else if (cmd.equals("pop")) {
                System.out.println(st.pop());
            } else if (cmd.equals("top")) {
                System.out.println("top");
            } else if (cmd.equals("size")) {
                System.out.println(st.size());
            }
        }
    }
}
