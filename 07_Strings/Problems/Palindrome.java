package Problems;

public class Palindrome {
    public static void main(String[] args) {
        String s = "dad";
        System.out.println(isPalindrome(s));
    }

    static boolean isPalindrome(String s){
        int i = 0, j = s.length()-1;

        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
