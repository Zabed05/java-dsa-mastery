package Questions;

public class Q11_RotationCount {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(countRotation(arr));
    }

    private static int countRotation(int[] arr){
        int pivot = findPivot(arr);

        return pivot + 1;
    }

    // finding the pivot index
    public static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            // Case 1:
            if(mid < end && arr[mid] > arr[mid+1]){ //we check this (mid < end) bcz of preventing index out of bound error as we check on arr[mid+1], it may be possible that when mid = end
                return mid;
            }
            // Case 2:
            else if(mid > 0 && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            // Case 3:
            else if(arr[mid] <= arr[start]){
                end = mid -  1;
            }
            // Case 4:
            else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
