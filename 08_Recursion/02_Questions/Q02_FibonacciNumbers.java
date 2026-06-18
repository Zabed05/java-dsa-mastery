public class Q02_FibonacciNumbers {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fib(n));
    }

    static int fib(int n){
        if(n < 2){ // base condition
            return n;
        }
        else{
            return fib(n-1) + fib(n-2);
        }
    }
}
