public class AVL {
    public AVL(){

    }

    class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public int getvalue(){
            return value;
        }

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;


    public int height(){
        return height(root);
    }
    private int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    // insertion
    public void insert(int value){
        root = insert(value, root);
    }
    private Node insert(int value, Node node){
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(value < node.value){
            node.left = insert(value, node.left);
        }
        else if(value > node.value){
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return rotate(node);
    }

    // Self balancing
    private Node rotate(Node node){
        if(height(node.left) - height(node.right) > 1){
            // Left heavy
            if(height(node.left.left) - height(node.left.right) > 0){
                // left-left case
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0){
                // left-right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.left) - height(node.right) < -1){
            // Right heavy
            if(height(node.right.left) - height(node.right.right) < 0){
                // right-right case
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0){
                // right-left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    // Left & Right rotate function
    private Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        // re-calculating heights
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    private Node leftRotate(Node p){
        Node c = p.right;
        Node t = c.left;

        c.left = p;
        p.right = t;

        // re-calculating heights
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    // populate
    public void populate(int[] arr){
        for (int i : arr) {
           this.insert(i); 
        }
    }
}