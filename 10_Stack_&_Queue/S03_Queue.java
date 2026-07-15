public class S03_Queue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int end = -1;

    public S03_Queue(){
        this(DEFAULT_SIZE);
    }

    public S03_Queue(int size){
        this.data = new int[size];
    }

    public boolean insert(int item){
        if(end == data.length-1){
            System.out.println("Stack Overflow");
            return false;
        }
        end++;
        data[end] = item;
        return true;
    }

    public int remove() throws Exception{
        if(end == -1){
            throw new Exception("Queue is Empty");
        }
        int removed = data[0];
        //shift the element to the left side one by one
        for (int i = 1; i <= end; i++) {
            data[i-1] = data[i];
        }
        end--;

        return removed;
    }

    public int peek() throws Exception{
        if(end == -1){
            throw new Exception("Queue is Empty");
        }
        return data[0];
    }

    public void display(){
        if(end == -1){
            System.out.println("Queue is Empty");
            return;
        }
        for (int i = 0; i <= end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.print("END");
    }

    public static void main(String[] args) throws Exception {
        S03_Queue queue = new S03_Queue(5);

        queue.insert(5);
        queue.insert(8);
        queue.insert(9);
        queue.insert(12);
        queue.insert(14);
        // queue.insert(22);

        System.out.println(queue.peek());

        queue.display();
        System.out.println();

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        System.out.println(queue.peek());
        queue.insert(7);

        queue.display();
    }
}
