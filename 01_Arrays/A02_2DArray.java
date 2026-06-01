import java.util.Arrays;
import java.util.Scanner;

public class A02_2DArray {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Row and Column no of the array:");
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] arr = new int[row][col];
        
        System.out.println("Enter elements:");
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        // Display
        System.out.println("Output:");
        for(int[] a: arr){
            System.out.println(Arrays.toString(a));
        }
        sc.close();
    }
}