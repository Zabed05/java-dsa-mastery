package Questions;

public class Q08_SearchInRotatedArr {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.println(search(arr, target));
    }

    public static int search(int[] arr, int target){
        int pivot = findPivot(arr);

        // if you did not find a pivot, it means array is not rotated
        if(pivot == -1){
            return binarySearch(arr, target, 0, arr.length-1);
        }
        // if you have found the pivot...Now you have 3 cases
        // Case 1:
        if(arr[pivot] == target){
            return pivot;
        }
        // Case 2:
        else if(target > arr[0]){
            return binarySearch(arr, target, 0, pivot - 1);
        }
        // Case 3:
        else{
            return binarySearch(arr, target, pivot + 1, arr.length-1);
        }
    }

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

    public static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start)/2;

            if(target < arr[mid]){
                end = mid - 1;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return - 1;
    }
    
    // LC: 81 Search in Rotated Sorted Array II  -->

    // this is for when array will contain duplicate elements
    public static int findPivotWithDuplicate(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            // Case 1: mid is pivot
            if(mid < end && arr[mid] > arr[mid+1]){ 
                return mid;
            }
            // Case 2: element before mid is pivot
            else if(mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            // Case 3: 
            
            // if elements at middle, start, end are equal then just skip the duplicates
            else if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot !?

                // check if start is pivot
                if(start < end && arr[start] > arr[start+1]){
                    return start;
                }
                start++; // skiping

                // check if end is pivot
                if(end > start && arr[end] < arr[end-1]){
                    return end - 1;
                }
                end--; // skiping
            }

            // left side is sorted, so pivot should be in right
            else if(arr[start] <= arr[mid]){
                start = mid + 1;
            }
            // otherwise pivot should be in left
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
}