class SegmentTree {

    private static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private Node root;

    public SegmentTree(int[] arr){
        //create a Tree using the array
        this.root = constructTree(arr, 0, arr.length-1);
    }

    // Construct Tree
    private Node constructTree(int[] arr, int start, int end){
        if(start == end){ // base case
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        // create new Node (in which index you are at)
        Node node = new Node(start, end);
        int mid = (start + end)/2;

        node.left = this.constructTree(arr, start, mid); //construct left hand side
        node.right = this.constructTree(arr, mid+1, end); // construct right hand side

        node.data = node.left.data + node.right.data; // data is holding sum of interval indeces

        return node;
    }

    // display
    public void display(){
        display(this.root);
    }
    private void display(Node node){
        if(node == null){
            return;
        }
        System.out.println("Interval:[" + node.startInterval + "," + node.endInterval + "]" + "\tData:" + node.data);
        display(node.left);
        display(node.right);
    }

    // Query
    public int query(int qsi, int qei){
        return this.query(this.root, qsi, qei);
    }
    private int query(Node node, int qsi, int qei){
        // case 1 : Node is completely lying inside the query
        if(node.startInterval >= qsi && node.endInterval <= qei){
            return node.data;
        }
        // case 2 : completly outside
        else if(node.startInterval > qei || node.endInterval < qsi){
            return 0;
        }
        // case 3 : Overlapping
        else{
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    // update
    public void update(int index, int value){
        this.root.data = update(this.root, index, value);
    }
    private int update(Node node, int index, int value){
        if(index >= node.startInterval && index <= node.endInterval){
            if(index == node.startInterval && index == node.endInterval){
                node.data = value;
                return node.data;
            }
            else{
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);

                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }
}