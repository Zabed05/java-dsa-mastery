import java.util.Arrays;

public class S02_SelectionSort {
    public static void main(String[] args){
        int[] arr = {3, 5, 8, 1, 4, 2};

        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            // find the max item in the remaining array and swap with correct index

            int last = arr.length - i - 1;
            int maxValue = findMaxIndex(arr, 0, last);

            swap(arr, maxValue, last);
        }
    }

    static int findMaxIndex(int[] arr, int start, int end){
        int max = start;
        for (int i = start; i <= end; i++) {
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
