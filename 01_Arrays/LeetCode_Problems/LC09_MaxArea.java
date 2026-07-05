package LeetCode_Problems;

// 11. Container With Most Water

public class LC09_MaxArea {

    // Brute Force (O(n^2))
    // public static int maxArea(int[] height){
    //     int max = 0;
    //     for (int i = 0; i < height.length; i++) {
    //         for (int j = 0; j < height.length; j++) {
    //             int ht = Math.min(height[i], height[j]);
    //             int wd = j-i;

    //             int area = ht*wd;

    //             max = Math.max(max, area);
    //         }
    //     }
    //     return max;
    // }


    // Optimal Solution
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;

        while(left < right){
            int wd = right-left;
            int ht = Math.min(height[left], height[right]); 
            int Currarea = wd*ht;

            maxArea = Math.max(maxArea, Currarea);

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println("Max area: " + maxArea(height));
    }
}
