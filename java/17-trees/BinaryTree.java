import java.util.*;

public class BinaryTree {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void display(Node node) {
        if (node == null)
            return;

        StringBuilder str = new StringBuilder();

        if (node.left != null) {
            str.append(node.left.data);
        } else {
            str.append(".");
        }

        str.append(" <- " + node.data + " -> ");

        if (node.right != null) {
            str.append(node.right.data);
        }

        else {
            str.append(".");
        }

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void displayIndented(Node node, int level) {
        if (node == null)
            return;

        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(node.data);

        displayIndented(node.left, level + 1);
        displayIndented(node.right, level + 1);
    }

    public static int size(Node node) {

        if (node == null) {
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);

        int ts = ls + rs + 1;

        return ts;
    }
    
    public static int sum(Node node) {

        if (node == null) {
            return 0;
        }
        int lsm = sum(node.left);
        int rsm = sum(node.right);

        int tsm = lsm + rsm + node.data;

        return tsm;
    }

    public static int max(Node node) {

        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int lm = max(node.left);
        int rm = max(node.right);

        int m = Math.max(node.data, Math.max(lm, rm));

        return m;
    }
    
    public static int height(Node node, boolean isNodeBased) {

        if (node == null) {
            return isNodeBased ? 0 : -1;
        }
        int lh = height(node.left, isNodeBased);
        int rh = height(node.right, isNodeBased);
        int th = Math.max(lh, rh) + 1;

        return th;
    }

    public static void traversal(Node node, StringBuilder pre, StringBuilder in, StringBuilder post) {
        if (node == null)
            return;

        pre.append(node.data).append(" ");
        traversal(node.left, pre, in, post);
        in.append(node.data).append(" ");
        traversal(node.right, pre, in, post);
        post.append(node.data).append(" ");
    }
    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };

        Stack<Pair> st = new Stack<>();
        Node root = new Node(arr[0], null, null);
        Pair rootPair = new Pair(root, 1);

        st.push(rootPair);
        
        int index = 0;

        while (!st.isEmpty()) {
            Pair top = st.peek();

            // left
            if (top.state == 1) {
                index++;
                if (arr[index] != null) {
                    Node leftNode = new Node(arr[index], null, null);
                    top.node.left = leftNode;

                    Pair leftPair = new Pair(leftNode, 1);
                    st.push(leftPair);
                }

                top.state++;
            }

            // right
            else if (top.state == 2) {
                index++;
                if (arr[index] != null) {
                    Node rightNode = new Node(arr[index], null, null);
                    top.node.right = rightNode;

                    Pair rightPair = new Pair(rightNode, 1);
                    st.push(rightPair);
                }

                top.state++;
            }

            // pop
            else {
                st.pop();
            }

        }
        // display(root);
        displayIndented(root, 0);
        System.out.println("Size -> " + size(root) + " , " + " Sum -> " + sum(root));
        System.out.println("Max: " + max(root));
        System.out.println("Height based on edge: " + height(root, false));
        System.out.println("Height based on node: " + height(root, true));
        
        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        StringBuilder post = new StringBuilder();

        traversal(root, pre, in, post);

        System.out.println("Pre order: " + pre);
        System.out.println("In order: " + in);
        System.out.println("Post order: " + post);
    }
}
