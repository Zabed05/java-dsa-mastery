// 1. Two Sum
/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. */

import java.util.Arrays;

public class LC01_TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(Sum(arr, target)));
    }

    // Brute Force Approach (Time Complexity: O(n^2))
    
    static int[] Sum(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] + arr[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}
