package Questions;

public class Q07_SearchInMountain {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;

        System.out.println(search(arr, target));
    }

    public static int search(int[] arr, int target){
        int peak = peakIndexInMountainArray(arr);

        int firstTry = orderAgnositcBS(arr, target, 0, peak);
        if(firstTry != -1){
            return firstTry;
        }
        // 
        return orderAgnositcBS(arr, target, peak+1, arr.length-1);
    }

    // This is for finding the peak index from the Array
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while(start < end){
            int mid = start + (end - start)/2;

            if(arr[mid] > arr[mid+1]){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return start;
    }

    // This is for searching on asc and dec order
    public static int orderAgnositcBS(int[] arr, int target, int start, int end){

        boolean isAsc = arr[start] < arr[end];

        while(start <= end){

            int mid = start + (end - start) / 2;

            if(arr[mid] == target){ // common for both ascending and descending order
                return mid;
            }

            //condition for Ascending order
            if(isAsc){
                if(target > arr[mid]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            //condition for Descending order
            else{
                if(target < arr[mid]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
