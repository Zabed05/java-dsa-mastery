import java.util.Arrays;

public class S06_MergeSortInPlace {
    public static void main(String[] args) {
        int[] arr = {3, 4, 12, 9, 2, 5};
        System.out.println(Arrays.toString(arr));

        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int start, int end){
        if(end - start == 1){ // Base condition
            return ;
        }

        int mid = (start+end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);

        merge(arr, start, mid, end);
    }

    static void merge(int[] arr, int start, int mid, int end){
        int[] mix = new int[end - start];

        int i = start, j = mid, k = 0;
        // i pointer for first array
        // j for second
        // k for mix array

        while(i < mid && j < end){
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            }
            else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of th array is not complete,
        // copy the remaining element
        while(i < mid){
            mix[k] = arr[i];
            i++;
            k++;
        }
        while(j < end){
            mix[k] = arr[j];
            j++;
            k++;
        }
        
        // Now we are coping from mix and storing it on the original array
        for (int l = 0; l < mix.length; l++) {
            arr[start+l] = mix[l];
         }
    }
}
