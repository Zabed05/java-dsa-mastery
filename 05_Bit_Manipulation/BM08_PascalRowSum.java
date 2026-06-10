//Q: Find Sum of nth row in Pascal Triangle

public class BM08_PascalRowSum {
    public static void main(String[] args) {
        int row = 5;

        int sum = 1 << (row - 1); // for nth row, sum = 2^(n-1)

        System.out.println(sum);
    }
}
