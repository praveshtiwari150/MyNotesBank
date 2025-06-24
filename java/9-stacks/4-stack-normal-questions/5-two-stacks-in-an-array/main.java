import java.util.*;

public class main {

    public static class TwoStack {

        int[] data;
        int tos1;
        int tos2;

        public TwoStack(int cap) {
            data = new int[cap];
            tos1 = -1;
            tos2 = data.length;
        }

        int size1() {
            return tos1 + 1;
        }

        int size2() {
            return data.length - tos2;
        }

        void push1(int val) {
            if (tos2 == tos1 + 1) {
                System.out.println("Stack overflow");
            } else {
                tos1++;
                data[tos1] = val;
            }
        }

        void push2(int val) {
            if (tos2 == tos1 + 1) {
                System.out.println("Stack overflow");
            } else {
                tos2--;
                data[tos2] = val;
            }
        }

        int pop1() {
            if (size1() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = data[tos1];
                tos1--;
                return val;
            }
        }

        int pop2() {
            if (size2() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = data[tos2];
                tos2++;
                return val;
            }
        }

        int top1() {
            if (size1() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return data[tos1];
            }
        }

        int top2() {
            if (size2() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return data[tos2];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt();
        int q = sc.nextInt();
        TwoStack ts = new TwoStack(cap);

        for (int i = 0; i < q; i++) {
            String cmd = sc.next();

            if (cmd.equals("push1")) {
                int val = sc.nextInt();
                ts.push1(val);
            } else if (cmd.equals("push2")) {
                int val = sc.nextInt();
                ts.push2(val);
            } else if (cmd.equals("pop1")) {
                int val = ts.pop1();
                if (val != -1)
                    System.out.println(val);
            } else if (cmd.equals("pop2")) {
                int val = ts.pop2();
                if (val != -1)
                    System.out.println(val);
            } else if (cmd.equals("top1")) {
                int val = ts.top1();
                if (val != -1)
                    System.out.println(val);
            } else if (cmd.equals("top2")) {
                int val = ts.top2();
                if (val != -1)
                    System.out.println(val);
            } else if (cmd.equals("size1")) {
                System.out.println(ts.size1());
            } else if (cmd.equals("size2")) {
                System.out.println(ts.size2());
            }
        }
    }
}
