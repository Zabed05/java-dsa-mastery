import java.util.PriorityQueue;

public class MinHeapDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.offer(30);
        minHeap.offer(10);
        minHeap.offer(20);

        System.out.println(minHeap.peek()); // 10

        while(!minHeap.isEmpty()){
            System.out.print(minHeap.poll() + " "); // removing element
        }
    }
}