// print "Hello World" 5 times by Recursion
public class R02_MessageEXRecursion {
    public static void main(String[] args) {
        message(5);
    }

    static void message(int n){
        if(n == 0){ // this is the base case (it stops the call)
            return;
        }
        System.out.println("Hello World");

        message(n-1); // Recursive call
    }
}