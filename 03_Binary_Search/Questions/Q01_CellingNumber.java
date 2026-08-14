package Questions;

public class Q01_CellingNumber {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};

        int target = 4;

        System.out.println("Celling value : " + celling(arr, target));
    }

    // return the index of smallest number >= target
    public static int celling(int[] arr, int target){

        // but what if the target is greater than the greatest element in the array
        if(target > arr[arr.length - 1]){
            return -1;
        }

        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(target == arr[mid]){
                return arr[mid];
            }
            else if(target < arr[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return arr[start];
    }
}