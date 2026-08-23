package Questions;

public class Q10_SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println(splitArray(arr, k));
    }

    public static int splitArray(int[] arr, int k){
        int minValue = findLargest(arr);
        int maxValue = sum(arr);

        // we have to apply BS
        int start = minValue;
        int end = maxValue;

        while(start < end){
            int mid = start + (end - start)/2;

            //calculate how many pieces you can divide this in with this max
            int sum = 0;
            int pieces = 1;

            for(int num : arr){
                if(sum + num > mid){
                    // you cannot add this in this subarry, make a new
                    // say that you add this num in new subarray, then sum = num
                    sum = num;
                    pieces++;
                }
                else{
                    sum += num;
                }
            }

            if(pieces > k){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return end; // here start == end
    }

    // for finding largest element
    public static int findLargest(int[] arr){
        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }

    // Sum of the entire array
    public static int sum(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}