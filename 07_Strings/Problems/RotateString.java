package Problems;

// LC: 796 Rotate String

// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
// A shift on s consists of moving the leftmost character of s to the rightmost position.
// For example, if s = "abcde", then it will be "bcdea" after one shift.

public class RotateString {
    public static void main(String[] args) {

        //Ex: Input: s = "abcde", goal = "cdeab"  ,  Output: true
        String s = "abcde";
        String goal = "cdeab";

        System.out.println(rotateString(s, goal));
    }

    static public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }

        for(int i = 0; i < s.length(); i++){
            if(s.equals(goal)){
                return true;
            }

            s = s.substring(1) + s.charAt(0);
        }

        return false;
    }


    // Also can be done like this-->
    public boolean rotateString2(String s, String goal) {
        if(s.length() != goal.length())
        {
            return false;
        }
        return (s+s).contains(goal); 
    }
}