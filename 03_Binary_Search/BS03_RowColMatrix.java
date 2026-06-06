// Matrix should be sorted in row & col wise manner

import java.util.Arrays;

public class BS03_RowColMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {28, 29, 37, 48},
            {33, 34, 38, 50} 
        };

        int target = 48;

        int[] ans = find(matrix, target);

        for(int[] a: matrix){
            System.out.println(Arrays.toString(a));
        }
    
        if(ans[0] == -1){
            System.out.println(target + " is not present in the array");
        }
        else{
        System.out.println(target + " is present in " + Arrays.toString(ans) );
        }
    }

    // function for returnning the target element's index
    static int[] find(int[][] arr, int target){
        int row = 0;
        int col = arr.length - 1;

        while(row < arr.length && col >= 0){
            if(arr[row][col] == target){
                return new int[] {row, col};
            }
            else if(arr[row][col] < target){
                row++;
            }
            else{
                col--;
            }
        }
        //if element is not found
        return new int[] {-1, -1};
    }
}
