//Q: Find no of digits in base b

public class BM07_DigitsInBaseB {
    public static void main(String[] args) {
        int n = 101; 
        int base = 2;

        int digits = (int)(Math.log(n) / Math.log(base)) + 1;

        System.out.println(digits);
    }
}
