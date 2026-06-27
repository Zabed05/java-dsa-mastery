public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList(){
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node prev;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }        
    }

    // Insert Node at first
    public void insertFirst(int value){
        Node node = new Node(value);

        node.next = head;
        node.prev = null;

        if(head != null){
            head.prev = node;
        }
        head = node;

        if(tail == null){
            tail = head;
        }

        size++;
    }

    // Traversal
    public void display(){
        Node current = head;

        System.out.println("Traversing the LL:");
        while(current != null){
            System.out.print(current.value + "--> ");
            current = current.next;
        }
        System.out.println("END");
    }

    // Reverse Traversal
    public void displayRev(){
        Node current = tail;

        System.out.println("Reverse Traversing: ");
        while(current != null){
            System.out.print(current.value + "--> ");
            current = current.prev;
        }
        System.out.println("START");
    }

    // Insert Last
    public void insertLast(int value){
    
        if(tail == null){
            insertFirst(value);
            return;
        }

        Node node = new Node(value);
        node.prev = tail;
        // node.next = null; /* Dont need to write it. Bcz java automatically initialize object reference to null */
        tail.next = node;

        tail = node;
        size++;
    }

    // Insert after a given index
    public void insertAfter(int index, int value){
        if(index == size-1){
            insertLast(value);
            return;
        }

        Node prevNode = head;
        for (int i = 1; i <= index; i++) {
            prevNode = prevNode.next;
        }
        if(prevNode == null){
            System.out.println(index + " index's node does not exist");
            return;
        }

        Node node = new Node(value);
        node.next = prevNode.next;
        prevNode.next.prev = node;

        prevNode.next = node;
        node.prev = prevNode;

        size++;
    }

    //Main Function
    public static void main(String[] args) {
        
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertFirst(3);
        list.insertFirst(5);
        list.insertFirst(8);

        // list.display();
        // list.displayRev();

        list.insertLast(12);
        list.display();

        list.insertAfter(2, 10);
        list.display();
    }
}