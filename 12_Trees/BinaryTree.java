import java.util.Scanner;

public class BinaryTree {

    public BinaryTree(){

    }

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;



    //insert element
    public void populate(Scanner sc){
        System.out.println("Enter the value of root element:");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc, root); // helper function
    }
    private void populate(Scanner sc, Node node){
        // for left insertion
        System.out.println("Do you want to insert at left of " + node.value);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of " + node.value);
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(sc, node.left);
        }

        // for right insertion
        System.out.println("Do you want to insert at right of " + node.value);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of " + node.value);
            int value = sc.nextInt();
            node.right = new Node(value);
            populate(sc, node.right);
        }
    }


    // Display
    public void display(){
        display(this.root, "");
    }
    private void display(Node node, String indent){
        if(node == null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "L---"); 
        display(node.right, indent + "R---"); 
    }

    // Another way to display
    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }
    private void prettyDisplay(Node node, int level){
        if(node == null){
            return;
        }
        prettyDisplay(node.right, level+1);

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.value);

        prettyDisplay(node.left, level+1);
    }



    //---TRAVERSAL METHOD---//

    // PRE-ORDER (root -> left -> right)
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node == null){
            return;
        }

        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    // IN-ORDER (left -> root -> right)
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    // POST-ORDER (left -> root -> right)
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}