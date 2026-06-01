import java.util.Arrays;

public class A05_SwapElement {
    public static void main(String[] args) {
        
        int[] arr = {12, 14, 2, 6, 8};

        System.out.println("Before swaping:" + Arrays.toString(arr));

        swap(arr, 0, 2);
        System.out.println("After swapping:" + Arrays.toString(arr));

    }

    static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
