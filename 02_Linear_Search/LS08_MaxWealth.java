public class LS08_MaxWealth {
    public static void main(String[] args) {
        int[][] arr = {
            {3, 5},
            {5, 1, 0},
            {1, 2, 3}
        };

        System.out.println(maxWealth(arr));
    }

    static int maxWealth(int[][] accounts){
        int max = Integer.MIN_VALUE;

        for (int row = 0; row < accounts.length; row++) {
            int rowSum = 0;
            for (int col = 0; col < accounts[row].length; col++) {

                rowSum += accounts[row][col]; // calculate sum for a single row
            }
            if(rowSum > max){
                    max = rowSum;
                }
        }
        return max;
    }
}
