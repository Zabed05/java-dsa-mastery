public class BinarySearchTree {
    public BinarySearchTree(){

    }

    public class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value){ // condtructor
            this.value = value;
        }

        public int getValue(){ // getter
            return value;
        }
    }
    private Node root;

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    // Insertion
    public void insert(int value){
        root = insert(value, root);
    }
    private Node insert(int value, Node node){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.value){ // if < root then add in the Left side
            node.left = insert(value, node.left);
        }
        else if(value > node.value){ // if > root then in the right
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1; // updating height

        return node;
    }

    // taking input from array
    public void populate(int[] arr){
        for (int i : arr) {
            insert(i);
        }
    }
    // What if the given array is sorted --> Do it like this :
    // take the middle -> insert  -> call the LHS -> call the RHS
    public void populateSorted(int[] arr){
        populateSorted(arr, 0, arr.length);
    }
    private void populateSorted(int[] arr, int start,  int end){
        if(start >= end){
            return;
        }
        int mid = (start + end)/2;

        this.insert(mid);
        populateSorted(arr, start, mid); // for LHS
        populateSorted(arr, mid+1, end); // for RHS
    }

    // Display
    public void display(){
        display(this.root, "Root Node: ");
    }
    private void display(Node node, String s){
        if(node == null){
            return;
        }
        System.out.println(s + node.value);

        display(node.left, "left child of " + node.value + " : ");
        display(node.right, "right child of " + node.value + " : ");
    }

    // Inorder Traversal
    public void inOrder(){
        System.out.println("In-Order Traversal: ");
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    // Searching
    public void search(int key){
        Node node = (search(root, key));
        System.out.println();
        if(node != null){
            System.out.println(key + " Node is present");
        }
        else{
            System.out.println(key + " Node is not there");
        }
    }
    private Node search(Node node, int key){
        while(node != null){
            if(key == node.value){
                return node;
            }
            else if(key < node.value){
                node = node.left;
            }
            else{
                node = node.right;
            }
        }
        return null;
    }
}