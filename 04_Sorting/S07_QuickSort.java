import java.util.Arrays;

public class S07_QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums, int low, int hi){

        if(low >= hi){ // base case
            return;
        }

        int start = low;
        int end = hi;
        int mid = start + (end-start)/2;
        int pivot = nums[mid]; // we take the middle element as pivot

        while(start <= end){
            while(nums[start] < pivot){
                start++;
            }
            while(nums[end] > pivot){
                end--;
            }

            if(start <= end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        // recursive call

        sort(nums, low, end); //LHS of pivot
        sort(nums, start, hi); //RHS of pivot
    }
}
