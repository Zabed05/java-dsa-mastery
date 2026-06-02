import java.util.Arrays;

public class LS02_SearchInString {
    public static void main(String[] args) {
        String[] str = {"Zabed", "Rittik", "Rahul", "Virat"};
        String target = "Virat";

        boolean ans = search(str, target);

        System.out.println(Arrays.toString(str));

        if(ans == false){
            System.out.println(target + " is not present in the array");
        }
        else
        System.out.println(ans);

    }

    static boolean search(String[] str, String target){
        for (int i = 0; i < str.length; i++) {
            if(str[i] == target){
                return true;
            }
        }
        return false;
    }
}