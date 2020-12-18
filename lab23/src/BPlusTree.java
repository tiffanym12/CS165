import java.util.*;

public class BPlusTree {
    enum Type {
        LEAF,
        INDEX
    }

    /* Do not change this class! */
    private static class Node {
        ArrayList<Integer> keys;
        ArrayList<Node> children;
        boolean isLeaf;

        Node(Type nt) {
            isLeaf = nt == Type.LEAF;

            keys = new ArrayList<>();
            children = new ArrayList<>();
        }

        // For debugging purposes.
        private String toString(int depth) {
            StringBuilder s = new StringBuilder();
            String padding = "";
            for (int i = 0; i < depth; i++) {
                padding += "  ";
            }
            s.append(padding + (isLeaf ? "LEAF NODE\n" : "INDEX NODE\n"));
            s.append(padding);
            for (int i = 0; i < keys.size(); i++) {
                s.append(String.format("key %d = %d, ",  i, keys.get(i)));
            }
            s.deleteCharAt(s.length() - 2);
            s.append("\n");
            if (!children.isEmpty()) {
                for (int i = 0; i < children.size(); i++) {
                    s.append(padding + "child " + i + " =\n");
                    s.append(children.get(i).toString(depth + 1));
                }
            }
            return s.toString();
        }

        public String toString() {
            return toString(0);
        }
        
    }

    int order;
    Node root;

    public BPlusTree(int order) {
        this.order = order;
        root = new Node(Type.LEAF); // The root is initially a leaf node!
    }

    /* YOUR CODE HERE
     * Of course, your code doesn't have to be all in one function. You are
     * encouraged to split the lengthy insert procedure up into more digestible
     * chunks - in fact, this is generally regarded as good programming
     * practice.
     *
     * Plan your approach before you start writing. Don't be afraid to throw
     * out code that doesn't work. It may take a few attempts to get
     * this right.
     */
    public void insert(int key) {

    }
    


    // For debugging purposes.
    public String toString() {
        return root.toString();
    }

    public static void main(String[] args) {
        BPlusTree bpt = new BPlusTree(5);

        bpt.insert(18);
        bpt.insert(23);
        bpt.insert(17);
        bpt.insert(2);

        // If you're having trouble, it's typically a good idea to check the
        // state of the tree after a few inserts.
        // Feel free to print the tree whenever you want, by invoking
        // System.out.println(bpt);

        bpt.insert(26);
        bpt.insert(5);
        bpt.insert(1);
        bpt.insert(8);

        bpt.insert(20);
        bpt.insert(4);
        bpt.insert(16);
        bpt.insert(10);

        bpt.insert(9);
        bpt.insert(0);
        bpt.insert(11);
        bpt.insert(15);

        bpt.insert(19);
        bpt.insert(13);
        bpt.insert(7);
        bpt.insert(25);

        System.out.println(bpt);
    }
}
