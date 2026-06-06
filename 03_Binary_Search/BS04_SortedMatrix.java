import java.util.Arrays;

public class BS04_SortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        int target = 15;
        int[] ans = search(matrix, target);

        for(int[] m: matrix){
            System.out.println(Arrays.toString(m));
        }
    
        if(ans[0] == -1){
            System.out.println(target + " is not present in the array");
        }
        else{
        System.out.println(target + " is present in " + Arrays.toString(ans) );
        }
    }

    //simple binarySearch code(needed for when only 1 row exists, for searching four halfs)
    static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target){
        while(cStart <= cEnd){
            int mid = cStart + (cEnd - cStart) / 2;

            if(matrix[row][mid] == target){
                return new int[] {row, mid};
            }
            else if(matrix[row][mid] > target){
                cEnd = mid - 1;
            }
            else{
                cStart = mid + 1;
            }
        }
        return new int[] {-1, -1};
    }

    static int[] search(int[][] matrix, int target){
        // STEP 1:
        //find number of rows and columns
        int rows = matrix.length;
        int cols = matrix[0].length;
        //Edge cases: 
        if(cols == 0){ // if matrix is empty
            return new int[] {-1, -1};
        }
        if(rows == 1){ // if only one row exists, perform normal bianrysearach on that row
            binarySearch(matrix, 0, 0, cols-1, target);
        }

        // STEP 2: Reduce rows using middle column
        int cMid = cols / 2; //selecting the mid col
        int rStart = 0;
        int rEnd = rows - 1;

        // continue while more than 2 rows remain
        while(rStart < (rEnd - 1)){
            int mid = rStart + (rEnd - rStart) / 2;

            if(matrix[mid][cMid] == target){
                return new int[] {mid, cMid};
            }
            if(matrix[mid][cMid] > target){ // remove below rows
                rEnd = mid;
            }
            else{
                rStart = mid;  
            }
        }
        //now we have only two rows

        //check whether the target is in the column of 2 rows
        if(matrix[rStart][cMid] == target){
            return new int[] {rStart, cMid};
        }
        if(matrix[rEnd][cMid] == target){
            return new int[] {rEnd, cMid};
        }


        //search in 1st half
        if(target <= matrix[rStart][cMid-1]){
            return binarySearch(matrix, rStart, 0, cMid-1, target);
        }

        //search in 2nd half
        if(target >= matrix[rStart][cMid+1] && target <= matrix[rStart][cols-1]){
            return binarySearch(matrix, rStart, cMid+1, cols-1, target);
        }

        //search in 3rd half
        if(target <= matrix[rEnd][cMid-1]){
            return binarySearch(matrix, rEnd, 0, cMid-1, target);
        }

        //search in 4th half
        else{
            return binarySearch(matrix, rEnd, cMid+1, cols-1, target);
        }
    }
}