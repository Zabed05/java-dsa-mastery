//Q: Given a number n, You have to find all prime number i.e < n
// We do this in a optimal way, and this is known as Sieve of Eratosthenes

public class M02_Sieve {
    public static void main(String[] args) {
        int n = 40;
        boolean[] primes = new boolean[n+1];
        
        sieve(n, primes);
    }

    // false in array means number is prime 
    static void sieve(int n, boolean[] primes){
        
        for (int i = 2; i <= n; i++) {
            if(!primes[i]){
                for (int j = i*2; j <= n; j+=i) {
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i <= n; i++) { // here we printing all the primes number i.e <n
            if(!primes[i]){
                System.out.print(i + " ");
            }
        }
        
    }
}
