import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class S01_InBuiltExamples {
    public static void main(String[] args) {

        //Stack  (LIFO)
        Stack<Integer> stack = new Stack<>();

        stack.push(14);
        stack.push(12);
        stack.push(10);
        stack.push(8);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("Peek Element of the stack: " + stack.peek());


        //Queue   (FIFO)
        Queue<Integer> queue = new LinkedList<>(); // LinkedList<>() bcz Queque is not a class its an interface, so we can't create object of Queue type thats why LinedList.

        queue.add(3);
        queue.add(6);
        queue.add(5);
        queue.add(19);

        System.out.println(queue.remove());

        System.out.println(queue.peek());
        


        // Deque or Deck  (Can insert and remove from both the side)
        Deque<Integer> deque = new ArrayDeque<>(); // Object type is ArrayDeque<>() 

        deque.add(3);
        deque.add(5);
        deque.add(8);
        deque.add(9);
        deque.addFirst(2);

        System.out.println(deque.remove());
        System.out.println(deque);
        System.out.println(deque.peekLast());

    }
}
