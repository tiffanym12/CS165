/* BSTTest class
 *  Made by Toby Patterson for CS165 at CSU
 *  6/26/2020
 *  Some tests for the Binary Tree of <extends Comparable> lab. */

public class BSTTest {
    public static void main(String[] args) {
        Double[] bst1Arr = {30.0,22.0,10.0,25.0,232.0};
        BST bsTree1 = new BST(bst1Arr);

        System.out.print("inorder, postorder, preorder for bsTree1: \n");
        System.out.println("inorder should be: \n10.0 22.0 25.0 30.0 232.0");
        bsTree1.inorder();
        System.out.println();
        System.out.println("postorder should be: \n10.0 25.0 22.0 232.0 30.0");
        bsTree1.postorder();
        System.out.println();
        System.out.println("preorder should be: \n30.0 22.0 10.0 25.0 232.0");
        bsTree1.preorder();
        System.out.println("\n");

        Integer[] bst2Arr = {50, 112, 20, 30, 2, 6, 53};
        BST bsTree2 = new BST(bst2Arr);
        System.out.print("inorder, postorder, preorder for bsTree2: \n");
        System.out.println("inorder should be: \n2 6 20 30 50 53 112");
        bsTree2.inorder();
        System.out.println();
        System.out.println("postorder should be: \n6 2 30 20 53 112 50");
        bsTree2.postorder();
        System.out.println();
        System.out.println("preorder should be: \n50 20 2 6 30 112 53");
        bsTree2.preorder();
        System.out.println("\n");

        String[] bst3Arr = {"hello", "I", "Am", "here"};
        BST bsTree3 = new BST(bst3Arr);
        System.out.print("inorder, postorder, preorder for bsTree3: \n");
        System.out.println("inorder should be: \nAm I hello here");
        bsTree3.inorder();
        System.out.println();
        System.out.println("postorder should be: \nAm I here hello");
        bsTree3.postorder();
        System.out.println();
        System.out.println("preorder should be: \nhello I am here");
        bsTree3.preorder();
        System.out.println("\n");

        System.out.println("Testing Search");
        System.out.println("bsTree1(30) should be true -> " + bsTree1.search(30.0));
        System.out.println("bsTree1(11033) should be false-> " + bsTree1.search(11030.0));
        System.out.println("bsTree2(50) should be true -> " + bsTree2.search(50));
        System.out.println("bsTree2(3) should be false -> " + bsTree2.search(3));
        System.out.println("bsTree3(\"hello\") should be true -> " + bsTree3.search("hello"));
        System.out.println("bsTree3(\"explosion\") should be false -> " + bsTree3.search("explosion"));
        System.out.println();

        /* Test Code for remove is going to be dependent on implementation.
         * For this lab, you will swap the node to be deleted with its inorder successor.
         */

        System.out.println("Testing Remove");
        System.out.println("inorder after calling bsTree1.remove(30.0) should be: \n10.0 22.0 25.0 232.0");
        bsTree1.remove(30.0);
        bsTree1.inorder();
        System.out.println();

        System.out.println("root of bsTree1 after bsTree1.remove(30.0) should be 232.0 -> " + bsTree1.getRoot().element);
        System.out.println();

        System.out.println("inorder after calling bsTree.remove(10.0) should be \n20.0 25.0 232.0");
        bsTree1.remove(10.0);
        bsTree1.inorder();
        System.out.println("\n");
    }
}
