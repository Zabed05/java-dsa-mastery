// Special example to return same value to above function calls

public class Q07_CountZeroes {
    public static void main(String[] args) {
        int n = 3010204;

        System.out.println(count(n));

    }

    static int count(int n){
        return helper(n, 0);
    }

    static int helper(int n, int c){
        while(n!= 0){
            if(n%10 == 0){
                return helper(n/10, c+1);
            }
            return helper(n/10, c);
        }
        return c;
    }
}