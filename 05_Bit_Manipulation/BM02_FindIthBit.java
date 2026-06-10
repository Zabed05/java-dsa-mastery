// Find ith bit of a number

public class BM02_FindIthBit {
    public static void main(String[] args) {
        int n = 10; //1010
        int i = 2;

        int bit = (n >> i) & 1;

        System.out.println(bit);
    
    }
}
