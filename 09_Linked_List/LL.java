public class LL {
    private Node head;
    private Node tail;
    int size;

    public LL(){
        this.size = 0;
    }
    
    private class Node {
        int value;
        Node next;
        
        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size++;
    }

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

    public void display(){
        Node current = head;

        while(current != null){
            System.out.print(current.value + " --> ");
            current = current.next;
        }
        System.out.print("null");
    }


    //--------------------- QUESTIONS ----------------------//

    // Remove Duplicates from sorted list
    public Node removeDuplicates(){
        Node curr = head;
        while(curr.next != null){
            if(curr.value == curr.next.value){
                curr.next = curr.next.next;
                size--;
            }
            else{
                curr = curr.next;
            }
        }
        tail = curr;
        tail.next = null;
        return head;
    }

    // Merge two sorted linkedlist
    public static LL merge(LL node1, LL node2){
        Node head1 = node1.head;
        Node head2 = node2.head;

        LL ans = new LL();

        while(head1 != null && head2 != null){
            if(head1.value < head2.value){
                ans.insertLast(head1.value);
                head1 = head1.next;
            }
            else{
                ans.insertLast(head2.value);
                head2 = head2.next;
            }
        }

        //  For remaining list elements
        while(head1 != null){
            ans.insertLast(head1.value);
            head1 = head1.next;
        }
        while(head2 != null){
            ans.insertLast(head2.value);
            head2 = head2.next;
        }

        return ans;
    }

    // Reverse LL using recursion
    public void reverse_rec(Node node){
        if(node == tail){
            head = tail;
            return;
        }

        reverse_rec(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // Main Function
    public static void main(String[] args) {
        
        LL list1 = new LL();
        LL list2 = new LL();

        list1.insertLast(1);
        list1.insertLast(3);
        list1.insertLast(5);

        list2.insertLast(1);
        list2.insertLast(1);
        list2.insertLast(2);
        list2.insertLast(14);

        list1.display();
        System.out.println();
        list2.display();
        System.out.println();

        // list2.removeDuplicates();
        // list2.display();

        // LL mergeLl = LL.merge(list1, list2);
        // mergeLl.display();

        list1.reverse_rec(list1.head);
        list1.display();
        
    }
}