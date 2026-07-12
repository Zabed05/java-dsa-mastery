// Letter combinations of a phone number (LC: 17) (ask is Google)
public class PhonePad {
    public static void main(String[] args) {
        combinations("", "23");
    }

    public static void combinations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0'; // this will convert '2' to 2

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char)('a' + i);
            combinations(p + ch, up.substring(1));
        }
    }
}