package Questions;

// Find position of an element in a sorted array of infinite numbers..

public class Q05_InfiniteArray {
    public static void main(String[] args){
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 30, 35, 40};
        int target = 10;

        System.out.println(findingRange(arr, target));
    }

    public static int findingRange(int[] arr, int target){
        //start with the box of size 2
        int start = 0;
        int end = 1;
        
        // condition for the target lie in the range
        while(target > arr[end]){
            //keep doubling the box size
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }

        return binarySearch(arr, target, start, end);
    }

    public static int binarySearch(int[] arr, int target, int start, int end){
        
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target < arr[mid]){
                end = mid + 1;
            }
            else if(target > arr[mid]){
                start = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}