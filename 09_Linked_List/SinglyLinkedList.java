public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value){  // Constructor 1: creates  value = a, next = null
            this.value = value;
        }

        public Node(int value, Node next) { // Constructor 2: creates value = a, next = head
            this.value = value;
            this.next = next;
        }
  
        
    }

    // Node Insertion At Beginnning
    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size++;
    }

    // Traversal
    public void display(){
        Node current = head;

        while(current != null){
            System.out.print(current.value + " --> ");
            current = current.next;
        }
        System.out.print("null");
    }

    // Insert At End
    public void insertLast(int value){
        if(tail == null){
            insertFirst(value);
            return;
        }

        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    // Insertion At Specific Position
    public void insertPosition(int index, int value){
        if(index == 0){
            insertFirst(value);
            return;
        }
        if(index == (size-1)){
            insertLast(value);
            return;
        }
        
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(value, temp.next);
        temp.next = node;

        size++;
        
    }

    // Delete First Node
    public void deleteFirst(){
        if(head == null){
            tail = null;
        }
        System.out.println("\n" + head.value + " deleted");
        head = head.next;
        size--;
    }

    // Delete Last Node
    public void deleteLast(){
        if(size <= 1){
            deleteFirst();
            return;
        }

        Node temp = head;
        for (int i = 1; i < size-2; i++) { // assigning temp to the Second Last Node
            temp = temp.next;
        }

        System.out.println(tail.value + " deleted");
        tail = temp.next;
        tail.next = null;
        size--;
    }

    // Delete a particular Node
    public void deletePosiition(int index){
        if(index == 0){
            deleteFirst();
            return;
        }

        if(index == size-1){
            deleteLast();
            return;
        }

        Node prev = head;
        for (int i = 1; i < index; i++) {
            prev = prev.next;
        }
 
        // Node temp = prev.next;
        // System.out.println("\n" + temp.value + " deleted");
        // temp = temp.next;

        // prev.next = temp;
        //size--;

        System.out.println("\n" + prev.next.value + " deleted");

        prev.next = prev.next.next;
        size--;
    }

    // Searching Node
    // public Node search(int value){
    //     Node node = head;
    //     while(node != null){
    //         if(node.value == value){
    //             return node;
    //         }
    //         node = node.next;
    //     }
    //     return null;
    // }
    
    public int search(int value){
        if(value == head.value){
            return 0;
        }
        if(value == tail.value){
            return size-1;
        }

        Node temp = head.next;
        for (int i = 1; i < size-1; i++) {
            if(temp.value == value){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    // Insert using Recursion
    public void insertRec(int index, int value){
        head = insertRec(index, value, head);
    }
    private Node insertRec(int index, int value, Node node){

        if(index == 0){ //Base case
            Node temp = new Node(value, node);
            size++;
            return temp;
        }

        node.next = insertRec(index-1, value, node.next);
        return node;
    }
    
    
    // Main Function
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertFirst(30);
        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(40);

        list.insertPosition(2, 25);

        list.display();

        list.deleteFirst();
        // list.deleteLast();

        // list.display();

        list.deletePosiition(3);
        // list.display();

        // System.out.println("\n" + "At index: " + list.search(25));

        list.insertRec(3, 30);

        list.insertFirst(10);
        list.insertLast(40);
        list.insertPosition(3, 25);
        list.display();

    }
}