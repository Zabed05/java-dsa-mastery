package Problems;

// count the number of vowels in a given String
public class countVowels {
    public static void main(String[] args) {
        String s = "kasdfiosnvmnopweio";
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e'|| ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }
        }
        System.out.println(count);
    }
}