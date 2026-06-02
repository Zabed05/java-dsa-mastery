import java.util.Arrays;

public class LS04_FindMin {
    public static void main(String[] args) {

        int[] arr = {12, 28, 14, 7, 45, 93};
        System.out.println(Arrays.toString(arr));

        int result = findMin(arr);
        System.out.println("Minimum value is " + result);
    }

    static int findMin(int[] arr){
        int minValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < minValue){
                minValue = arr[i];
            }
        }
        return minValue;
    }
}