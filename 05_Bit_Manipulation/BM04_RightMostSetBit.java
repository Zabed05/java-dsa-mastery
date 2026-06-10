//Q: Find the position of the right most set bit

public class BM04_RightMostSetBit {
    public static void main(String[] args) {
        int n = 18; // 10010
        int position = 1;

        while((n&1) == 0){
            n >>= 1;
            position++;
        }

        System.out.println(position);
    }
}
