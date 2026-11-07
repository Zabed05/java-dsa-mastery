package LeetCode_Problems;

import java.util.Arrays;

public class LC11_MinimumMoves {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        System.out.println(minMoves(nums)); // 3
        
        System.out.println(minMoves2(nums)); // 2
    }

    // LC: 453 Minimum Moves to Equal Array Elements

    public static int minMoves(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        for(int num : nums){
            min = Math.min(min, num);
        }
        
        int ans = 0;

        for(int i = 0; i < n; i++){
            ans += nums[i] - min;
        }
        return ans;
    }

    // 462. Minimum Moves to Equal Array Elements II

    public static int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int median = nums[n/2];
        int ans = 0;

        for(int num: nums){
            ans += Math.abs(num - median);
        }

        return ans;
    }
}

// Pattern:
// Increment n-1 elements → Think of decrementing one element → Find minimum.
// Increment/decrement any element → Think of absolute distance → Find median.