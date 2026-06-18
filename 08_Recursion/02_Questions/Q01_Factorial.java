public class Q01_Factorial {
    public static void main(String[] args) {
        int n = 8;
        System.out.println("Factorial of "+ n + " is: " + fact(n));
    }

    static int fact(int n){
    
        if(n < 2){
            return 1;
        }
        return n*fact(n-1);
    }
}
