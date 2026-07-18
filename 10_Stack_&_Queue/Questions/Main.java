package Questions;

public class Main {
    public static void main(String[] args) throws Exception{
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);

        System.out.println(queue.remove());
        System.out.println(queue.remove());

        System.out.println(queue.peek());
    }
}