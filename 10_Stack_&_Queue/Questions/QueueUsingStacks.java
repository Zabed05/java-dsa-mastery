package Questions;

import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> first;
    private Stack<Integer> second;

    //Constructor
    public QueueUsingStacks(){
        first = new Stack<>();
        second = new Stack<>();
    }

    // Push
    public void insert(int item){
        first.push(item);
    }

    // Pop
    public int remove() throws Exception{
        // push in the second stack from first stack
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int removed = second.pop(); // first element of the second stack

        // Again push in the first from second
        while(!second.isEmpty()){
            first.push(second.pop());
        }

        return removed;
    }

    // peek
    public int peek() throws Exception{
        //same as remove
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int peeked = second.pop(); 

        while(!second.isEmpty()){
            first.push(second.pop());
        }

        return peeked;
    }
}