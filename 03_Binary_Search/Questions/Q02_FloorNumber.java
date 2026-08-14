package Questions;

public class Q02_FloorNumber {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};

        int target = 4;

        System.out.println("Floor value : " + floor(arr, target));
    }

    // return the index of gratest number <= target
    public static int floor(int[] arr, int target){
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
        return arr[end];
    }
}
