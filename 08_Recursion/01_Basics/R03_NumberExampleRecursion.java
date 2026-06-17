// print first 5 numbers (1 2 3 4 5) using recursion

public class R03_NumberExampleRecursion {
    public static void main(String[] args) {
        print(1);
    }

    static void print(int n){
        if(n == 5){ // base case
            System.out.println(5);
            return;
        }
        System.out.println(n);

        //recursive call
        print(n+1); // this is the last function call (Tail Recursion)
    }
}
