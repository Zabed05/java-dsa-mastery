//Q: Find nth Magic number

public class BM06_MagicNumber {
    public static void main(String[] args) {
        int n = 6;
        
        int ans = 0;
        int base = 5;

        while(n > 0){
            int last = n&1; // (n&1 give the last digit of the number in bianry)
            n = n >> 1; // right shift(ignore the last)

            ans += last*base;
            base = base*5;
        }

        System.out.println(ans);
    }
}
