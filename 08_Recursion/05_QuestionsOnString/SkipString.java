public class SkipString {
    public static void main(String[] args) {
        System.out.println(skipNotApple("abcdeapplefgh"));
    }

    // Skip the string 
    public static String skipApple(String str){
        if(str.isEmpty()){
            return "";
        }

        if(str.startsWith("apple")){
            return skipApple(str.substring(5));
        }
        else{
            return str.charAt(0) + skipApple(str.substring(1));
        }
    }

    // Skip a string if its not the required string
    public static String skipNotApple(String str){
        if(str.isEmpty()){
            return "";
        }

        if(str.startsWith("app") && !str.startsWith("apple")){
            return skipNotApple(str.substring(3)); // 3 bcz "app" size is 3
        }
        else{
            return str.charAt(0) + skipNotApple(str.substring(1));
        }
    }
}
