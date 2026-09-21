import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeapDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.offer(30);
        maxHeap.offer(10);
        maxHeap.offer(20);

        while(!maxHeap.isEmpty()){
            System.out.print(maxHeap.poll() + " ");
        }
        
    }
}
