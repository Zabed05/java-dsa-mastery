import java.util.Arrays;

public class Q02_BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8, 2, 10, 1, 3, -1, 5};

        sort(arr, arr.length-1, 0);
        System.out.println("Sorted: " + Arrays.toString(arr));
    }

    public static void sort(int[] arr, int i, int j){
        if(i == 0){
            return;
        }

        if(j < i){
            if(arr[j] > arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
            sort(arr, i, j+1);
        }
        else{
            sort(arr, i-1, 0);
        }
    }
}
