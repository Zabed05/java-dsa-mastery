public class S02_Stack {

    protected int[] data; 
    private static final int DEFAULT_SIZE = 10; 
    /*static bcz this value is same for all the object of the S02_Stack class,
    private bcz we dont want that people change it,
    final bcz we dont to change it never during this program */

    int top = -1;

    // when nothing passed -->
    public S02_Stack(){
        this(DEFAULT_SIZE);
    }

    // if size is passed -->
    public S02_Stack(int size){
        this.data = new int[size]; // create block of passes size in the data array
    }


    // Push
    public boolean push(int item){
        if(top == data.length -1){
            System.out.println("Stack Overflow");
            return false;
        }

        top++;
        data[top] = item;
        return true;
    }

    // Pop
    public int pop() throws Exception{
        if(top == -1){
            throw new Exception("Cannot pop from an empty stack!");
        }

        return data[top--];
    }
    
    // Peek
    public int peek() throws Exception{
        if(top == -1){
            throw new Exception("Cannot peek from an empty stack!");
        }

        return data[top];
    }

    public static void main(String[] args) throws Exception {
        S02_Stack stack = new S02_Stack(5);

        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        // stack.push(7);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        // System.out.println(stack.peek());
    }
}

// We created a DynamicStack(means if stack is getting full then its size will be increase)

class DynamicStack extends S02_Stack{

    public DynamicStack(){
        super(); // it will call S02_Stack()
    }

    public DynamicStack(int size){
        super(size); // it will call S02_Stack(int size)
    }

    @Override
    public boolean push(int item) {
        if(this.top == data.length-1){ // if stack is getting full then
            int[] temp = new int[data.length * 2]; // double the array

            // copy all previous items in new array
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp; // now temp is become data
        }
        // insert items
        return super.push(item);
    }

    
}