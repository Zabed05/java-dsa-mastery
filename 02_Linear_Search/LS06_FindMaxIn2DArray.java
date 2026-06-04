import java.util.Arrays;

public class LS06_FindMaxIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
            {12, 14, 3},
            {1, 18, 73,},
            {9, 4, 18}
        };

        for(int[] a: arr){
            System.out.println(Arrays.toString(a));
        }

        int result = findMax(arr);
        System.out.println("Max value:" + result);
    }

    static int findMax(int[][] arr){
        int maxValue = Integer.MIN_VALUE;

        // for (int row = 0; row < arr.length; row++) {
        //     for (int col = 0; col < arr.length; col++) {
        //         if(arr[row][col] > maxValue){
        //             maxValue = arr[row][col];
        //         }
        //     }
        // }
        // using for-each loop:
        for (int[] ints : arr) {
            for (int element : ints){
                if(element > maxValue){
                    maxValue = element;
                }
            }
        }
        return maxValue;
    }
}
