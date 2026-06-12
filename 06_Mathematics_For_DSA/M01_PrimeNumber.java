// Q: Find given number is prime or not

public class M01_PrimeNumber {
    public static void main(String[] args) {
        int n = 36;
        System.out.println(isPrime(n));
    }
    // Brute Force approach (repeated happening over here)
    // static boolean isPrime(int n){
    //     if(n <= 1){
    //         return false;
    //     }
    //     for (int i = 2; i < n; i++) {
    //         if(n % i == 0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // Optimal solution
    static boolean isPrime(int n){
        if(n <= 1){
            return false;
        }
        int c = 2;
        while(c*c <= n){
        // [condition is c <= squareRoot(n); by squaring both side we got c*c <= n]
            if(n % c == 0){
                return false;
            }
            c++;
        }
        return true;
    }
}
