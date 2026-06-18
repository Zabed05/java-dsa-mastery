public class Q04_SumOfDigits {
    public static void main(String[] args) {
        int n = 1342;
        System.out.println("Sum of digits: " + sum(n));
        System.out.println("Product of digits: " + product(n));
    }

    static int sum(int n){
        if(n == 0){
            return 0;
        }
        
        return (n%10) + sum(n/10);
    }

    // this is for ProductOfDigits :
    static int product(int n){
        if(n%10 == n){ // when 1 digit is remaining return that number
            return n;
        }
        return (n%10) * product(n/10);
    }
}
