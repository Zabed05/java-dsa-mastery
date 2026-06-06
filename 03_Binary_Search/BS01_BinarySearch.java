public class BS01_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 9, 12, 14, 16, 20}; // array must be sorted
        int target = 14;

        int ans = binarySearch(arr, target);

        if(ans == -1){
            System.out.println("Element not found");
        }
        else{
            System.out.println("Element found at index:" + ans);
        }
    }

    // return the index value of the target element
    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){

            int mid = start + (end - start) / 2;
            //as we know the array is sorted in ascending order
            if(target > arr[mid]){
                start = mid + 1;
            }
            else if(target < arr[mid]){
                end = mid - 1;
            }
            else{
                return mid; //return the index value (element found)
            }
        }
        return -1; //element not found
    }
}