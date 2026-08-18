package Questions;

public class Q06_MountainArray {
    public static void main(String[] args) {
        
    }
    public static int peakIndexInMountainArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = start + (end - start)/2;

            if(arr[mid] > arr[mid+1]){
                // you are in decending part of the array
                // it may be the answer, but look at left
                // thats why end != mid - 1
                end = mid;
            }
            else {
                // you are in ascending part of the arr
                start = mid + 1; // bcz we know that mid+1 element > mid so ignoring the mid
            }
        }
        // in the end start == end and pointing to the largest number bcz of the above 2 checks
        return start; //or return end; as both are equal
    }
}
