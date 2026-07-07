//Given a string remove a character from that string
public class SkipChar {
    public static void main(String[] args) {
        // skip("", "baccdah");
        System.out.println(skip("baccdah"));

    }

    public static void skip(String ans, String str){
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);

        if(ch == 'a'){
            skip(ans, str.substring(1));
        }
        else{
            skip(ans + ch, str.substring(1));
        }
    }

    // doing it by returnning the string
    public static String skip(String str){
        if(str.isEmpty()){
            return "";
        }

        char ch = str.charAt(0);

        if(ch == 'a'){
            return skip(str.substring(1));
        }
        else{
            return ch + skip(str.substring(1));
        }
    }
}
