public class S04_CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int rear = -1;
    int front = 0;
    int size = 0;

    public S04_CircularQueue(){
        this(DEFAULT_SIZE);
    }

    public S04_CircularQueue(int capacity){
        this.data = new int[capacity];
    }

    public boolean isFull(){
        return size == data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void insert(int item){
        if(isFull()){
            System.out.println("Queue Overflow");
            return;
        }

        rear = (rear+1) % data.length;
        data[rear] = item;
        size++;

    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        int removed = data[front];
        front = (front+1) % data.length;
        size--;

        return removed;
    }

    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }

        return data[front];
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.print(data[(front + i)% data.length] + " <- ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {

        S04_CircularQueue cq = new S04_CircularQueue(5);

        cq.insert(5);
        cq.insert(8);
        cq.insert(9);
        cq.insert(12);
        cq.insert(14);
        // cq.insert(22);

        cq.display();

        System.out.println(cq.peek());

        System.out.println(cq.remove());
        System.out.println(cq.remove());

        cq.display();

        cq.insert(20);
        cq.insert(22);

        cq.display();


    }
}
