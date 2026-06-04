import java.util.Arrays;

public class LS05_SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6, 7},
            {8,9}
        };

        int target = 19;
        
        int[] ans = searchIn2D(arr, target);

        for(int[] a: arr){
            System.out.println(Arrays.toString(a));
        }
    
        if(ans[0] == -1){
            System.out.println(target + " is not present in the array");
        }
        else{
        System.out.println(target + " is present in " + Arrays.toString(ans) );
        }
    }

    static int[] searchIn2D(int[][] arr, int target){
        if(arr.length == 0){
            return new int[] {-1, -1};
        }

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if(arr[row][col] == target){
                    return new int[] {row, col};
                }
            }
        }
        //if element is not found
        return new int[] {-1, -1};
    }
}