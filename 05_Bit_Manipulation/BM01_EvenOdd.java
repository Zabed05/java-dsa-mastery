// Q: Given a number n find if it is odd or even (using bitwise operator)

public class BM01_EvenOdd {
    public static void main(String[] args) {
        int n = 12;

        if((n & 1) == 1){
            System.out.println(n + " is a odd number");
        }
        else{
            System.out.println(n + " is a even number");
        }
    }
}
