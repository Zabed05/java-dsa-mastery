// 189. Rotate Array
/*Given an integer array nums, rotate the array to the right by k steps, where k is non-negative */

import java.util.Arrays;
public class LC07_RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotateRight(arr, k);
        // rotatLeft(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotateRight(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        reverse(nums, 0, n-1); // Reverse whole Array

        reverse(nums, 0, k-1); // Reverse first-half

        reverse(nums, k, n-1); // Reverse second-half

    }

    public static void rotatLeft(int[] nums, int k){
        int n = nums.length;
        k %= n;

        reverse(nums, 0, k-1); // Reverse First-half
        reverse(nums, k, n-1); // Reverse Second-half
        reverse(nums, 0, n-1); // Reverse whole aray
    }

    static void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

    }
}
