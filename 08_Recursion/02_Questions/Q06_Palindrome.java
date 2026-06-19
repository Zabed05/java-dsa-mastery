public class Q06_Palindrome {
    public static void main(String[] args) {
        int n = 12321;

        System.out.println(isPalindrome(n));
    }

    static boolean isPalindrome(int n ){
        if(n < 0){
            return false;
        }
        return n == rev(n);
    }

    static int rev(int n){
       int digits = (int)(Math.log10(n)) + 1;

       return helper(n, digits);
    }

    private static int helper(int n, int digits){
        if(n%10 == n){
            return n;
        }
        int rem = n % 10;
        return rem * (int)(Math.pow(10, digits-1)) + helper(n/10, digits - 1);
    }
}