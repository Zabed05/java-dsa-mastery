import java.util.Arrays;

public class LS01_LinearSearch {
    public static void main(String[] args) {
        int [] arr = {12, 14, 18, 7, 93, 45};
        int target = 93;
        int ans = linearSearch(arr, target);

        System.out.println("Array:" + Arrays.toString(arr));
        if(ans == -1){
            System.out.println(target + " is not present in the array");
        }
        else{
            System.out.println(target + " present in " + (ans+1) + " position");
        }
    }

    // Function of the linear searching (return index value)
    static int linearSearch(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
