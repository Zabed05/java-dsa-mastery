import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        
        // BinaryTree bt = new BinaryTree();
        // bt.populate(sc);
        // bt.prettyDisplay();


        BinarySearchTree bst = new BinarySearchTree();
        int[] arr = {15, 10, 5, 20, 12, 18, 24};
        bst.populate(arr);
        bst.inOrder();
        bst.search(18);


        // AVL avl = new AVL();
        // for (int i = 0; i < 1000; i++) {
        //     avl.insert(i);
        // }
        // System.out.println(avl.height());


        int[] arr1 = {3, 8, 7, 6, -2, -8, 4, 9};
        SegmentTree st = new SegmentTree(arr1);
        st.display();
        System.out.println(st.query(0, 7));

        st.update(7, 2);

        st.display();
        System.out.println(st.query(0, 7));
    }
}