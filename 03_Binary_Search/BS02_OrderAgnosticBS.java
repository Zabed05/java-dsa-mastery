public class BS02_OrderAgnosticBS {
    public static void main(String[] args) {
        // int[] asc = {2, 4, 6, 9, 12, 14, 16, 20};
        int[] decen = {48, 35, 15, 14, 5, 3, -4, -20};
        int target = 14;

        int ans = orderAgnosticBS(decen, target);

        if(ans == -1){
            System.out.println("Element not found");
        }
        else{
            System.out.println("Element found at index:" + ans);
        }
    }

    static int orderAgnosticBS(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        // find whether the array is sorted in ascending order or descending order
        // boolean isAsc;
        // if(arr[start] < arr[end]){
        //     isAsc = true;
        // }
        // else{
        //     isAsc = false;
        // }
        //instead of the upper one we can also do it by only one line-->
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
