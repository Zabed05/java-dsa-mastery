public class Q03_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {4, 8, 12, 13, 14, 21};
        int target = 14;

        int ans = search(arr, target, 0, arr.length-1);

        if(ans == -1){
            System.out.println(target + " is not present in the array");
        }
        else{
            System.out.println(target + " present at index " + ans);
        }
        
    }

    static int search(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start) / 2;

        if(target == arr[mid]){
            return mid;
        }

        if(target > arr[mid]){
            return search(arr, target, mid+1, end);
        }

        return search(arr, target, start, mid-1);
    }
}
