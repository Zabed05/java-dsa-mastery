import java.util.Arrays;

public class LS03_SearchInRange {
    public static void main(String[] args) {
        int [] arr = {12, 3, 18, 7, 93, 3};
        int target = 3;

        int ans = linearSearch(arr, target, 2, 5);

        System.out.println("Array:" + Arrays.toString(arr));
        if(ans == -1){
            System.out.println(target + " is not present in the array");
        }
        else{
            System.out.println(target + " present in " + (ans+1) + " position");
        }
    }

    static int linearSearch(int[] arr, int target, int start, int end){

        if(arr.length == 0){
            return -1;
        }

        for (int i = start; i <= end; i++) {
            if(arr[i] == target){
                return i;
            }
        }

        return -1;
    }
}
