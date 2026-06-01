import java.util.Arrays;

public class A07_FindMax {
    public static void main(String[] args) {
        int[] arr = {20, 4, 18, 93, 12, 3, 34};

        int maxValue = arr[0];

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > maxValue){
                maxValue = arr[i];
            }
        }

        System.out.println("Array:" + Arrays.toString(arr));
        System.out.println("Max Value:" + maxValue);
    }
}
