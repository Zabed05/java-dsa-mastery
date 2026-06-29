public class CircularLinkedList {
    private Node head;
    private Node tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    private class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    //insert
    public void insert(int value){
        Node node = new Node(value);
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        head = node;
    }

    // Display
    public void display(){
        Node curr = head;
        if(head != null){
            do{
                System.out.print(curr.value + "--> ");
                curr = curr.next;
            }
            while(curr != head);
        }
        System.out.println("HEAD");
    }

    //Delete
    public void delete(int value){
        Node node = head;
        if(node == null){
            return;
        }
        if(node.value == value){
            head = head.next;
            tail.next = head;
            return;
        }

        do{
            Node n = node.next;
            if(n.value == value){
                node.next = n.next;
                break;
            }
            node = node.next;
        }while(node != head);
    }

    // Main
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.insert(8);
        list.insert(9);
        list.insert(2);
        list.insert(7);

        list.delete(8);

        list.display();
    }
}