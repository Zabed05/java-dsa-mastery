package LeetCode_Problems;

import java.util.Arrays;

public class LC08_Median {
    public static void main(String[] args) {
        int[] arr1 = {0,1,3};
        int[] arr2 = {7,14,20};

        System.out.println(findMedian(arr1, arr2));
    }

    static double findMedian(int[] arr1, int[] arr2){
        int[] mix = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]){
                mix[k] = arr1[i];
                i++;
            }
            else{
                mix[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            mix[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            mix[k] = arr2[j];
            j++;
            k++;
        }
        
        System.out.println(Arrays.toString(mix));
        if(k%2 == 0){
            return (mix[(k-1)/2] + mix[k/2]) / 2.0;
        }
        else{
            return mix[k/2];
        }
    }
}
