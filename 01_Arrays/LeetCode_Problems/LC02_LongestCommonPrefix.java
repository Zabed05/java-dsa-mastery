package LeetCode_Problems;

// 14. Longest Common Prefix
/* Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "". */



import java.util.Arrays;

public class LC02_LongestCommonPrefix {
    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};
        System.out.println(Arrays.toString(strs));
        System.out.println(lcp(strs));
    }

    static String lcp(String[] strs){
        String prefix = strs[0];

        if(strs == null || strs.length == 0){
            return "";
        }

        for (int i = 0; i < strs.length; i++) {
            while(!strs[i].startsWith(prefix)){
                System.out.println(prefix);
                prefix = prefix.substring(0, prefix.length()-1);

                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }
}
