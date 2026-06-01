import java.util.Arrays;

public class A06_ReverseArray {
    public static void main(String[] args) {
        
        int[] arr = {12, 14, 2, 6, 8, 0};

        System.out.println("Original Array:" + Arrays.toString(arr));

        reverse(arr);
        System.out.println("Reversed Array:" + Arrays.toString(arr));

    }

    // for reversing the array we need to swap 
    static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    static void reverse(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }

    } 
}
