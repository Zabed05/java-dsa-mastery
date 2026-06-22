public class M06_Power {
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }


    public static double myPow(double x, int n) { // x = base, n = power
        // return Math.pow(x,n);
        long N = n; // for very big n
        double ans = 1;

        if(N < 0){
            x = 1/x;
            N = -N;
        }

        while(N > 0){
            if((N&1) == 1){ //check if exponent is odd
                ans = ans * x;
            }
            x *= x;
            N = N >> 1; // Divide exponent by 2 (Right-shift)
        }
        return ans;
    }
}