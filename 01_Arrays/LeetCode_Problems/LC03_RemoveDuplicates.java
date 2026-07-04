package LeetCode_Problems;

// 26. Remove Duplicates from Sorted Array

public class LC03_RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,1,2};

        int k = removeDuplicates(nums); 

        System.out.println(k);
    }

    static int removeDuplicates(int[] nums) {

        if(nums.length == 0){
            return 0;
        }
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if(nums[fast] != nums[slow]){
                slow ++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }
}
