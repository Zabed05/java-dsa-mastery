import java.util.Arrays;

public class LS07_EvenDigit {
    public static void main(String[] args) {
        int[] nums = {12, 1, 455, 6789, 23, 444};

        System.out.println(Arrays.toString(nums));

        System.out.println("No. of numbers containing even Digit:" + count(nums));
    }

    static int count(int[] nums){
        int count = 0;
        for (int num : nums) {
            if(even(num)){
                count++;
            }
        }
        return count;
    }

    // function to check whether a number contains even no. of digit
    static boolean even(int num){
        int numberOfDigits = digits(num);

        // if(numberOfDigits % 2 ==0){
        //     return true;
        // }
        // return false;

        return numberOfDigits % 2 == 0; // in one line
        
    }

    // count number of digits in a nnumber
    // static int digits(int num){

    //     //if number is negetive it will convert into positive
    //     if(num < 0){
    //         num = num * -1;
    //     }

    //     if(num == 0){
    //         return 1;
    //     }

    //     int count = 0;
    //     while(num > 0){
    //         count++;
    //         num = num / 10; 
    //     }
    //     return count;
    // }

    // Optimized of digits():
    static int digits(int num){
        if(num < 0){
            num = num * -1;
        }

        return (int)(Math.log10(num)) + 1;
    }
}
